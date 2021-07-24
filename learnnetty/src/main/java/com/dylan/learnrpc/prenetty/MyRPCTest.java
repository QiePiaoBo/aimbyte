package com.dylan.learnrpc.prenetty;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @author Dylan
 * @Date : 2021/4/24 - 13:34
 * @Description : 需求：通信、连接数量、拆包、动态代理、序列化反序列化、协议封装、连接池
 * @Function :
 */
public class MyRPCTest {

    public static void main(String[] args) {
//        模拟客户端
        get();
    }

    public static void get(){
        new Thread(()->{
            server();
        }).start();
        System.out.println("Server started.");
        Car car = proxyGet(Car.class); // 动态代理
        car.ooxx("hello");


//        Fly fly = proxyGet(Fly.class); // 动态代理
//        fly.xxoo("hello");
    }

    public static void server(){
        NioEventLoopGroup boss = new NioEventLoopGroup(1);
        NioEventLoopGroup worker = boss;
        ServerBootstrap sbs = new ServerBootstrap();
        ChannelFuture bind = sbs.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                        System.out.println("server accept client port : " + nioSocketChannel.remoteAddress().getPort());
                        ChannelPipeline p = nioSocketChannel.pipeline();
                        p.addLast(new ServerRequestHandler());
                    }
                }).bind(new InetSocketAddress("localhost", 9090));
        try {
            bind.sync().channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * 根据入参获取对象
     * @param interfaceInfo
     * @param <T>
     * @return
     */
    public static <T>T proxyGet(Class<T> interfaceInfo){
        // 实现各个版本的动态代理
        ClassLoader classLoader = interfaceInfo.getClassLoader();
        Class<?>[] methodInfo = {interfaceInfo};


        return (T)Proxy.newProxyInstance(classLoader, methodInfo, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                // 需要在这里处理客户端对服务方的调用过程
                // 1. 调用服务、方法、参数  -> 封装成message     [content]
                String name = interfaceInfo.getName();
                String methodName = method.getName();
                Class<?>[] parameterTypes = method.getParameterTypes();

                MyContent myContent = new MyContent();
                myContent.setArgs(args);
                myContent.setMethodName(methodName);
                myContent.setName(name);
                myContent.setParameterTypes(parameterTypes);

                ByteArrayOutputStream outInMemory = new ByteArrayOutputStream();
                ObjectOutputStream out = new ObjectOutputStream(outInMemory);
                out.writeObject(myContent);
                byte[] msgBody = outInMemory.toByteArray();
                // 2. requestID + message , 本地要缓存这些信息
                // 协议：【header】【msgBody】
                MyHeader header = createHeader(msgBody);
                outInMemory.reset();
                out = new ObjectOutputStream(outInMemory);
                out.writeObject(header);
                byte[] msgHeader = outInMemory.toByteArray();
                // 3. 连接池，用于取得与服务端的连接
                ClientFactory factory = ClientFactory.getFactory();
                NioSocketChannel clientChannel = factory.getClient(new InetSocketAddress("localhost", 9090));
                // 4. 发送 -->通过IO,将相关的调用信息发出去
                CountDownLatch countDownLatch = new CountDownLatch(1);
                long requestId = header.getRequestId();
                ResponseHandler.addCallBack(requestId, new Runnable() {
                    @Override
                    public void run() {
                        countDownLatch.countDown();
                    }
                });
                ByteBuf byteBuf = PooledByteBufAllocator.DEFAULT.directBuffer(msgHeader.length + msgBody.length);
                byteBuf.writeBytes(msgHeader);
                byteBuf.writeBytes(msgBody);
                ChannelFuture channelFuture = clientChannel.writeAndFlush(byteBuf);
                channelFuture.sync();
                // 阻塞住，直至有事件发生
                countDownLatch.await();

                // 5. 过了一段时间后，返回从对面回来了，怎么将代码再次回到这里并往下执行（睡眠、回调等方法，需要让线程停下来，而且结果回来的时候还能再继续走下去）

                return null;
            }
        });
    }

    public static MyHeader createHeader(byte[] msgBody){
        MyHeader header = new MyHeader();
        int size = msgBody.length;
        int f = 0x14141414;
        long requestId = Math.abs(UUID.randomUUID().getLeastSignificantBits());
        header.setFlag(f);
        header.setDataLen(size);
        header.setRequestId(requestId);
        return header;
    }
}

class ServerRequestHandler extends ChannelInboundHandlerAdapter{

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        ByteBuf sendBuf = buf.copy();
        System.out.println("channel start: " + buf.readableBytes());
        if (buf.readableBytes() >= 106){
            byte[] bytes = new byte[106];
            buf.readBytes(bytes);
            ByteArrayInputStream in = new ByteArrayInputStream(bytes);
            ObjectInputStream oin = new ObjectInputStream(in);
            MyHeader header = (MyHeader) oin.readObject();
            System.out.println("Server data length: " + header.dataLen);
            System.out.println("Server requestId: " + header.getRequestId());

            if (buf.readableBytes() >= header.getDataLen()){
                byte[] data = new byte[(int)header.getDataLen()];
                buf.readBytes(data);
                ByteArrayInputStream din = new ByteArrayInputStream(data);
                ObjectInputStream doin = new ObjectInputStream(din);
                MyContent content = (MyContent) doin.readObject();

                System.out.println("Server get requestBody.name: " + content.getName());
            }else {
                System.out.println("channel else: " + buf.readableBytes());
            }
        }
        ChannelFuture channelFuture = ctx.writeAndFlush(sendBuf);
        channelFuture.sync();
    }
}



class ClientFactory{
    NioEventLoopGroup clientWorker;
    int poolSize = 1;
    Random rand = new Random();
    private ClientFactory(){
    }
    private static final ClientFactory factory;
    static {
        factory = new ClientFactory();
    }
    public static ClientFactory getFactory(){
        return factory;
    }

    // 一个客户端可以连接很多个服务端，每个服务端都有自己的连接池
    ConcurrentHashMap<InetSocketAddress, ClientPool> outBox = new ConcurrentHashMap<>();

    public NioSocketChannel getClient(InetSocketAddress address){
        ClientPool clientPool = outBox.get(address);
        if (clientPool == null){
            outBox.putIfAbsent(address, new ClientPool(poolSize));
            clientPool = outBox.get(address);
        }
        // 现在得到的池是空的,随机取得一个下标，去取连接
        int i = rand.nextInt(poolSize);
        if (clientPool.clients[i] != null && clientPool.clients[i].isActive()){
            return clientPool.clients[i];
        }
        synchronized (clientPool.lock[i]){
            clientPool.clients[i] = create(address);
            return clientPool.clients[i];
        }
    }

    private NioSocketChannel create(InetSocketAddress address) {
        // 基于netty的客户端
        clientWorker = new NioEventLoopGroup(1);
        Bootstrap bs = new Bootstrap();
        ChannelFuture connect = bs.group(clientWorker)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                        ChannelPipeline pipeline = nioSocketChannel.pipeline();
                        pipeline.addLast(new ClientResponses());
                    }
                }).connect(address);
        NioSocketChannel client = null;
        try {
            client = (NioSocketChannel) connect.sync().channel();
            return client;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}

class ResponseHandler{
    private static ConcurrentHashMap<Long, Runnable> mapping = new ConcurrentHashMap<>();
    public static void addCallBack(long requestId, Runnable cb){
        mapping.putIfAbsent(requestId, cb);
    }
    public static void runCallBack(long requestId){
        Runnable runnable = mapping.get(requestId);
        runnable.run();
        removeCB(requestId);
    }
    private static void removeCB(long requestId){
        mapping.remove(requestId);
    }

}



class ClientResponses extends ChannelInboundHandlerAdapter{

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        if (buf.readableBytes() >= 106){
            byte[] bytes = new byte[106];
            buf.readBytes(bytes);
            ByteArrayInputStream in = new ByteArrayInputStream(bytes);
            ObjectInputStream oin = new ObjectInputStream(in);
            MyHeader header = (MyHeader) oin.readObject();
            System.out.println("client datalength: " + header.dataLen);
            System.out.println("client requestId: " + header.getRequestId());
            //
            ResponseHandler.runCallBack(header.requestId);
//            if (buf.readableBytes() >= header.getDataLen()){
//                byte[] data = new byte[(int)header.getDataLen()];
//                buf.readBytes(data);
//                ByteArrayInputStream din = new ByteArrayInputStream(data);
//                ObjectInputStream doin = new ObjectInputStream(din);
//                MyContent content = (MyContent) doin.readObject();
//
//                System.out.println(content.getName());
//            }
        }

    }
}


class ClientPool{
    NioSocketChannel[] clients;
    Object[] lock;

    ClientPool(int size){
        clients = new NioSocketChannel[size]; // init 连接都是空的
        lock = new Object[size]; // 锁是可以初始化的
        for (int i = 0; i < size; i++) {
            lock[i] = new Object();
        }
    }


}

class MyHeader implements Serializable{
    // 通信上的协议
    // 1. 标识，协议类型
    // 2. UUID，requestId
    // 3. DATA_LEN
    int flag; // 32bit
    long requestId;
    long dataLen;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public long getRequestId() {
        return requestId;
    }

    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }

    public long getDataLen() {
        return dataLen;
    }

    public void setDataLen(long dataLen) {
        this.dataLen = dataLen;
    }
}

class MyContent implements Serializable{
    private String name;
    private String methodName;
    private Class<?>[] parameterTypes;
    private Object[] args;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}

interface Car{
    public void ooxx(String msg);

}

interface Fly{
    void xxoo(String msg);
}