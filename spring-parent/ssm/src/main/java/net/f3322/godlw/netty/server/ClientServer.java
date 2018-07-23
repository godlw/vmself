package net.f3322.godlw.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;

import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import net.f3322.godlw.netty.decode.MessageDecoder;
import net.f3322.godlw.netty.encode.MessageEncoder;
import net.f3322.godlw.netty.handler.ServerHandler;
import org.springframework.stereotype.Component;



@Component
public class ClientServer extends Thread {
    private int port=9000;

    public void run(){
        EventLoopGroup boosloopgroup=new NioEventLoopGroup();
        EventLoopGroup workgroup=new NioEventLoopGroup();
        ByteBuf headbuff=Unpooled.buffer(8);
        headbuff.writeBytes("\r".getBytes());
        try {
            ServerBootstrap bootstrap=new ServerBootstrap();

            bootstrap.group(boosloopgroup,workgroup).channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline()
                                    .addLast("encoder",new MessageEncoder())
                                    .addLast("decoder",new MessageDecoder())
                                    .addFirst(new LineBasedFrameDecoder(65535))
                                    .addLast(new ServerHandler());
                        }
                    }).option(ChannelOption.SO_BACKLOG,1024)
                    .childOption(ChannelOption.SO_KEEPALIVE,true);
            ChannelFuture future=bootstrap.bind("127.0.0.1",port).sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            workgroup.shutdownGracefully();
            boosloopgroup.shutdownGracefully();
        }
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
