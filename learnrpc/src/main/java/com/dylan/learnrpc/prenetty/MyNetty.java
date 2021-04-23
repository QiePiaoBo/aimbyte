package com.dylan.learnrpc.prenetty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * @author Dylan
 * @Date : Created in 13:12 2021/4/23
 * @Description :
 * @Function :
 */
public class MyNetty {

    public static void main(String[] args) {

        myByteBuf();


    }

    public static void clientModel(){
        NioEventLoopGroup thread = new NioEventLoopGroup(1);

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
