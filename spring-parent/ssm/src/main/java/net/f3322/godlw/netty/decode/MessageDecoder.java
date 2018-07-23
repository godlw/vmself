package net.f3322.godlw.netty.decode;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.CorruptedFrameException;
import net.f3322.godlw.netty.message.Header;
import net.f3322.godlw.netty.message.Message;

import java.util.List;

public class MessageDecoder extends ByteToMessageDecoder {
    /**包长度志头**/
    public static final int HEAD_LENGHT = 15;
    /**标志头**/
    public static final byte PACKAGE_TAG = 0x01;
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> out) throws Exception {
            byteBuf.markReaderIndex();
            if (byteBuf.readableBytes()<HEAD_LENGHT){
                throw new CorruptedFrameException("包长度问题");
            }
            byte tag=byteBuf.readByte();
            if (tag!=PACKAGE_TAG){
                throw new CorruptedFrameException("标志问题");
            }
        byte encode = byteBuf.readByte();
        byte encrypt = byteBuf.readByte();
        byte extend1 = byteBuf.readByte();
        byte extend2 = byteBuf.readByte();
        byte sessionByte[] = new byte[32];
        byteBuf.readBytes(sessionByte);
        String sessionid = new String(sessionByte,"UTF-8");
        int length = byteBuf.readInt();
        int cammand=byteBuf.readInt();
        Header header = new Header(tag,encode, encrypt, extend1, extend2, sessionid, length, cammand);
        byte[] data=new byte[length];
        byteBuf.readBytes(data);
        Message message = new Message(header,new String(data,"UTF-8"));
        out.add(message);
    }
}
