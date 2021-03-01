package com.fly.server;

import com.fly.common.utils.IdGen;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * description: Test
 * date: 2021/1/18 22:50
 * author: LIBEL
 * version: 1.0
 */
@SpringBootTest
public class ApplicationTests {
    /*
     * description:  关于Id生成算法测试 生成一百四十万个
     * version: 1.0
     * date: 2021/2/26 12:51
     * @author: LIGEL
     * @param null
     * @return
     */
    @Test
    void IdGeneratorTest() {
        long avg = 0;
        for (int k = 0; k < 10; k++) {
            List<Callable<Long>> partitions = new ArrayList<Callable<Long>>();
            final IdGen idGen = IdGen.get();
            for (int i = 0; i < 1400000; i++) {
                partitions.add(new Callable<Long>() {
                    @Override
                    public Long call() throws Exception {
                        return idGen.nextId();
                    }
                });
            }
            System.out.println("id数量："+partitions.size());
            ExecutorService executorPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
            try {
                long s = System.currentTimeMillis();
                executorPool.invokeAll(partitions, 10000, TimeUnit.SECONDS);
                long s_avg = System.currentTimeMillis() - s;
                avg += s_avg;
                System.out.println("完成时间需要: " + s_avg / 1.0e3 + "秒");
                executorPool.shutdown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("平均完成时间需要: " + avg / 10 / 1.0e3 + "秒");

    }


}
