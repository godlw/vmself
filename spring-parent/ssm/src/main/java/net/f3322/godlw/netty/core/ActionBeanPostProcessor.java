package net.f3322.godlw.netty.core;

import net.f3322.godlw.netty.invote.Action;
import net.f3322.godlw.netty.invote.ActionMapUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
@Component
public class ActionBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
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

        return bean;
    }

}
