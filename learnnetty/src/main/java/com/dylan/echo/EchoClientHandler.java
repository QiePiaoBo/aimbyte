package com.dylan.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @Classname EchoClientHandler
 * @Description TODO
 * @Date 2022/1/7 14:32
 */
public class EchoClientHandler extends ChannelInboundHandlerAdapter {

    private final ByteBuf firstMessage;


    public EchoClientHandler() {
        firstMessage = Unpooled.buffer(EchoClient.SIZE);
        for(int i = 0; i < firstMessage.capacity(); i ++){
            firstMessage.writeByte((byte) i);
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(firstMessage);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ctx.write(msg);
        System.out.println(msg + "你好");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("你好世界" + cause.getMessage());
        ctx.close();
    }
}
