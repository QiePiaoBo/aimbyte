package com.dylan.dychat.server;

import com.dylan.mynetty.dychat.utils.PrintUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Objects;

/**
 * @Classname DyChatServerHandler
 * @Description DyChat服务端处理器
 * @Date 2022/2/19 17:44
 */
public class DyChatServerHandler  extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        PrintUtil.printInfo("Channel %s active.", ctx.channel().id() + "");
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        PrintUtil.printInfo("Channel %s registered.", ctx.channel().id() + "");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        PrintUtil.printError("Exception channel: %s\nException cause: %s",ctx.channel().id() + "", cause.getMessage());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (Objects.nonNull(msg) && Objects.equals("thr", msg)){
            throw new Exception("Error of thr.");
        }
    }
}
