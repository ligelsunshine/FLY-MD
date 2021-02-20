package com.fly.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author LIGEL
 */
@SpringBootApplication
@ComponentScan(value ={"com.fly.common.**","com.fly.server.**.**","com.fly.server.**"})
@MapperScan({"com.fly.server.**.mapper"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
