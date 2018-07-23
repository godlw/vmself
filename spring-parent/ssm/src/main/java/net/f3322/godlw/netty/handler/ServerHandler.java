package net.f3322.godlw.netty.handler;


import io.netty.channel.*;
import net.f3322.godlw.netty.invote.ActionMapUtil;
import net.f3322.godlw.netty.message.Header;
import net.f3322.godlw.netty.message.Message;

import java.lang.reflect.AccessibleObject;

public class ServerHandler extends SimpleChannelInboundHandler<Message>{

    private Header header;
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
           Message message=(Message) msg;
           ActionMapUtil.invote(header.getCammand(),ctx,message);
    }

    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, Message message) throws Exception {

    }



    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String content="我收到连接";
        header=new Header((byte)0,(byte)1,(byte)1,(byte)1,(byte)0,"713f17ca614361fb257dc6741332caf2",content.getBytes("UTF-8").length, 1);
        Message message=new Message(header,content);
        ctx.writeAndFlush(message);
    }
}
