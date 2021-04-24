package com.dylan.learnrpc.prenetty;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.*;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

/**
 * @author Dylan
 * @Date : Created in 13:12 2021/4/23
 * @Description :
 * @Function :
 */
public class MyNetty {

    public static void main(String[] args) {

//        myByteBuf();
        try {
//            客户端模式
//            clientModel();
//            服务端模式
//            serverMode();
//            netty客户端模式
//            nettyClient();
//            Netty服务端模式
            nettyServer();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * 客户端模式
     * @throws InterruptedException
     */
    public static void clientModel() throws InterruptedException {
        NioEventLoopGroup thread = new NioEventLoopGroup(1);

        NioSocketChannel client = new NioSocketChannel();

        thread.register(client);

        ChannelPipeline p = client.pipeline();
        p.addLast(new MyClientHandler());

        ChannelFuture connect = client.connect(new InetSocketAddress("192.168.105.53", 9090));
        ChannelFuture sync = connect.sync();

        ByteBuf byteBuf = Unpooled.copiedBuffer("Hello world".getBytes(StandardCharsets.UTF_8));
        ChannelFuture send = client.writeAndFlush(byteBuf);
        // 保证send动作完成
        send.sync();

        // 通过sync拿到channel后，确定断开后向下执行
        sync.channel().closeFuture().sync();
        System.out.println("client over...");
    }

    /**
     * 服务端模式
     * @throws InterruptedException
     */
    public static void serverMode() throws InterruptedException {

        NioEventLoopGroup thread = new NioEventLoopGroup(1);

        NioServerSocketChannel server = new NioServerSocketChannel();
        // 注册server
        thread.register(server);
        ChannelPipeline p = server.pipeline();
        // 在server的pipeline中添加接收连接的handler
        p.addLast(new MyAcceptHandler(thread, new ChannelInitHandler()));
        // 绑定端口，准备好接收连接
        ChannelFuture bind = server.bind(new InetSocketAddress("192.168.0.110", 9090));
        bind.sync().channel().closeFuture().sync();
        System.out.println("server closed.");
    }

    /**
     * Netty的客户端
     * @throws InterruptedException
     */
    public static void nettyClient() throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup(1);
        Bootstrap bs = new Bootstrap();
        ChannelFuture connect = bs.group(group)
                .channel(NioSocketChannel.class)
//                .handler(new ChannelInitHandler())
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline p = socketChannel.pipeline();
                        p.addLast(new MyClientHandler());
                    }
                })
                .connect(new InetSocketAddress("192.168.110.110", 9090));
        // 连接结束（sync()）后,先获取到连接的channel
        Channel client = connect.sync().channel();

        ByteBuf byteBuf = Unpooled.copiedBuffer("Hello server".getBytes());
        ChannelFuture send = client.writeAndFlush(byteBuf);

        send.sync();

        client.closeFuture().sync();


    }

    /**
     * Netty的服务端
     */
    public static void nettyServer() throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup(1);

        ServerBootstrap sbs = new ServerBootstrap();

        ChannelFuture bind = sbs.group(group, group)
                .channel(NioServerSocketChannel.class)
//                .handler(new MyAcceptHandler(group, new ChannelInitHandler()))
//                .childHandler(new ChannelInitHandler())
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        pipeline.addLast(new MyClientHandler());
                    }
                })
                .bind(new InetSocketAddress("192.168.0.110", 9090));
        Channel channel = bind.sync().channel();

        channel.closeFuture().sync();
    }


//    检测新建的、写入一次的、写入两次的、写入三次的、写满之后的ByteBuf的状态
//    public static void myByteBuf(){
//        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer(8, 20);
//        ByteBuf byteBuf1 = UnpooledByteBufAllocator.DEFAULT.buffer(8, 20);
//        ByteBuf byteBuf2 = PooledByteBufAllocator.DEFAULT.buffer(8, 20);
//
//
//        print(byteBuf);
//        byteBuf.writeBytes(new byte[]{1, 2, 3, 4});
//        print(byteBuf);
//    }
//    public static void print(ByteBuf byteBuf){
//        System.out.println("是否可读：" + byteBuf.isReadable());
//        System.out.println("可读位置：" + byteBuf.readerIndex());
//        System.out.println("可读大小：" + byteBuf.readableBytes());
//        System.out.println("是否可写：" + byteBuf.isWritable());
//        System.out.println("可写位置：" + byteBuf.writerIndex());
//        System.out.println("可写大小：" + byteBuf.writableBytes());
//        System.out.println("是否堆外：" + byteBuf.isDirect());
//        System.out.println("实际大小：" + byteBuf.capacity());
//        System.out.println("最大大小：" + byteBuf.maxCapacity());
//    }
}

/**
 * 服务端接收连接的handler
 */
class MyAcceptHandler extends ChannelInboundHandlerAdapter {

    private final EventLoopGroup selector;
    private final ChannelHandler channelInitHandler;

    /**
     * 初始化该类时，传入注册用的selector和桥梁handler，桥梁handler的作用是作为一个通用的handler向客户端添加其他自定义的handler，添加完毕后会将自己从客户端的pipeline中删掉
     * @param selector
     * @param channelInitHandler
     */
    public MyAcceptHandler(EventLoopGroup selector, ChannelInitHandler channelInitHandler) {
        this.selector = selector;
        this.channelInitHandler = channelInitHandler;
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel registered.");
    }

    /**
     * 这是server的用于接收的handler，所以这个方法一定是框架帮我们处理好的一个连接
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        // 转换成一个客户端连接
        SocketChannel client = (SocketChannel) msg;
        // 在客户端连接的pipeLine中添加桥梁handler
        client.pipeline().addLast(channelInitHandler);
        // 将客户端连接注册到服务端连接所在的selector
        selector.register(client);
    }
}

/**
 * 桥梁handler
 * 将这个方法作为桥梁,它也是一个handler，是shareable的，它的作用是在客户端注册成功后把一些用户想要用到的自定义handler添加到pipeline中去，然后再将自己从pipeline中剔除
 * 这样不会导致同一个handler对象的重复利用
 */
@ChannelHandler.Sharable
class ChannelInitHandler extends ChannelInboundHandlerAdapter {

    /**
     * 当注册成功后，将一些自定义的handler给注册到客户端的pipeline，最后功成身退，将自己从客户端的pipeline中remove掉
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        Channel client = ctx.channel();
        ChannelPipeline p = client.pipeline();
        p.addLast(new MyClientHandler());
        p.remove(this);
    }
}
/**
 * 用户自定义handler
 * 这个handler应该是用户自己来实现的，不应该强行复用到pipeline中，但是可以用一个公共的桥梁将自己添加
 */
//@ChannelHandler.Sharable
class MyClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel registered.");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel active.");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        CharSequence str = byteBuf.getCharSequence(0, byteBuf.readableBytes(), StandardCharsets.UTF_8);

        ctx.writeAndFlush(byteBuf);
        System.out.println(str);


    }
}

