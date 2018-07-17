package net.f3322.godlw.UserMapperTest;


import net.f3322.godlw.mapper.ClientMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(value = {"classpath:mybatis-config.xml"})
public class UserMapperTest {



    @Autowired
    private ClientMapper clientMapper;

    @Test
    public void selecttest() {
        System.out.println(clientMapper.findAll().size());
    }

}
