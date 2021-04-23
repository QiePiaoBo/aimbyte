package com.dylan.learnrpc.prenetty;

import io.netty.buffer.*;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.EventExecutorGroup;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
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
            clientModel();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void clientModel() throws InterruptedException {
        NioEventLoopGroup thread = new NioEventLoopGroup(1);

        NioSocketChannel client = new NioSocketChannel();

        thread.register(client);

        ChannelPipeline p = client.pipeline();
        p.addLast(new MyHandler());

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

    public static void myByteBuf(){
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer(8, 20);
        ByteBuf byteBuf1 = UnpooledByteBufAllocator.DEFAULT.buffer(8, 20);
        ByteBuf byteBuf2 = PooledByteBufAllocator.DEFAULT.buffer(8, 20);


        print(byteBuf);
        byteBuf.writeBytes(new byte[]{1, 2, 3, 4});
        print(byteBuf);
    }
    public static void print(ByteBuf byteBuf){
        System.out.println("是否可读：" + byteBuf.isReadable());
        System.out.println("可读位置：" + byteBuf.readerIndex());
        System.out.println("可读大小：" + byteBuf.readableBytes());
        System.out.println("是否可写：" + byteBuf.isWritable());
        System.out.println("可写位置：" + byteBuf.writerIndex());
        System.out.println("可写大小：" + byteBuf.writableBytes());
        System.out.println("是否堆外：" + byteBuf.isDirect());
        System.out.println("实际大小：" + byteBuf.capacity());
        System.out.println("最大大小：" + byteBuf.maxCapacity());
    }


}
class MyHandler extends ChannelInboundHandlerAdapter {

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
