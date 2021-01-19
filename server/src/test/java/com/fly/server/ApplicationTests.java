package com.fly.server;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.yaml.snakeyaml.Yaml;
import java.util.Map;

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
        Yaml yaml= new Yaml();
        Map<String, Object> ret = (Map<String, Object>) yaml.load(this
                .getClass().getClassLoader().getResourceAsStream("test.yaml"));
        System.out.println(ret);
    }
}
