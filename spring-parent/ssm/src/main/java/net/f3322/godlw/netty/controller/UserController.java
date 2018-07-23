package net.f3322.godlw.netty.controller;

import io.netty.channel.ChannelHandlerContext;
import net.f3322.godlw.netty.core.ActionMap;
import net.f3322.godlw.netty.core.NettyController;
import net.f3322.godlw.netty.message.Message;

@NettyController
public class UserController {

    @ActionMap(key=1)
    public String login(ChannelHandlerContext ct, Message message){
       ct.writeAndFlush(message);
        return "ok";
    }

}
