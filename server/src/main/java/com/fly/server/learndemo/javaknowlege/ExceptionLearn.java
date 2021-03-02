package com.fly.server.learndemo.javaknowlege;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * description: ExceptionLearn
 * date: 2021/3/2 14:58
 * version: 1.0
 *
 * @author: LIGEL
 */
public class ExceptionLearn {
    public void learnTest()  {
        // 这是资源的try catch 退出try会自动关闭资源
        try(InputStream inputStream = new FileInputStream("/D:\\Resources\\电子书\\Go语言\\go语言高并发与微服务实战.pdf"))
        {
            int read = inputStream.read(new byte[1024]);
            System.out.println("这里是资源处理");
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        // 能够分析程序的运行轨迹，这里对于异常的排查还是很有用的。
        Throwable throwable = new Throwable();
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            System.out.println(stackTraceElement.getClassName());
        }
        // 获取所有进程的栈轨迹，不管程序在哪里运行，都能
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        for (Thread thread2 : allStackTraces.keySet()) {
            StackTraceElement[] stackTraceElements = allStackTraces.get(thread2);

        }
        // 断言
        assert 1>0: 12;
    }
}
