package com.fly.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
<<<<<<< HEAD
@ComponentScan(value ={"com.fly.common.**","com.fly.server.**"})
=======
@ComponentScan(value ={"com.fly.common.**","com.fly.server.**.**"})
>>>>>>> main
@MapperScan({"com.fly.server.**.mapper"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
