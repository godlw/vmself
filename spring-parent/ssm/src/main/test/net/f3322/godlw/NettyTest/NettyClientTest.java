package net.f3322.godlw.NettyTest;

import net.f3322.godlw.netty.controller.UserController;
import net.f3322.godlw.netty.core.ActionMap;
import net.f3322.godlw.netty.invote.Action;
import net.f3322.godlw.netty.invote.ActionMapUtil;
import net.f3322.godlw.netty.message.Header;
import net.f3322.godlw.netty.message.Message;
import org.apache.ibatis.javassist.bytecode.ByteArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Scanner;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class NettyClientTest {

    @Test
    public void clienTest(){
        try {
            Socket socket=new Socket("127.0.0.1",9090);
            InputStream in=socket.getInputStream();
            OutputStream out=socket.getOutputStream();
            String str="111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
            byte[] by=str.getBytes("utf-8");
            Header header = new Header((byte) 1, (byte) 1, (byte) 1, (byte) 1, (byte) 1, "713f17ca614361fb257dc6741332caf2", by.length, 1);
            Message msg=new Message(header,str);
            out.write(msg.toByte());
            out.flush();
            StringBuffer buffer=new StringBuffer();
            byte[] bt=new byte[1024];
            while((in.read(bt)!=-1)){
                buffer.append(bt);
                System.out.println(new String(bt));
                bt=new byte[1024];
            }
            in.close();
            out.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Full(){
        Object bean=new UserController();
        Method[] methods=bean.getClass().getMethods();
        for (Method method:methods){
            ActionMap actionMap=method.getAnnotation(ActionMap.class);
            if (actionMap!=null){
                Action action=new Action();
                action.setMethod(method);
                action.setObject(bean);
                ActionMapUtil.put(actionMap.key(),action);
            }
        }

        try {
            Action action1= ActionMapUtil.get(1);
           System.out.println(action1.getMethod().invoke(UserController.class,"login"));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
