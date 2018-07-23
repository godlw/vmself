package net.f3322.godlw.NettyTest;

import net.f3322.godlw.netty.core.ActionBeanPostProcessor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(value = {"classpath:spring-config.xml"})
public class NettyTest {

    @Autowired
    private ActionBeanPostProcessor actionBeanPostProcessor;
    @Test
    public void nettytunTest(){

    }
}
