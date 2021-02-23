package com.fly.server.learndemo.iocdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


/**
 * description: BeanDemo
 * date: 2021/2/19 16:23
 * version: 1.0
 * @author LIGEL
 */
public class BeanDemo {
    MyTestBean myTestBean;
    public BeanDemo() {
        Resource resource= new ClassPathResource("Application.xml");
        ApplicationContext ctx= new ClassPathXmlApplicationContext(resource.getFilename());
        myTestBean= (MyTestBean)ctx.getBean("myTestBean");
    }
    public void helloBean(String name){
        myTestBean.helloBean(name);
    }
}
