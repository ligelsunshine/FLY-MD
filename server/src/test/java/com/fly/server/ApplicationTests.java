package com.fly.server;

import com.fly.server.learndemo.BeanDemo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * description: Test
 * date: 2021/1/18 22:50
 * author: LIBEL
 * version: 1.0
 */
@SpringBootTest
public class ApplicationTests {
    @Test
    void contextLoads() {
        BeanDemo beanDemo= new BeanDemo();
        beanDemo.helloBean("ligel");

    }

}
