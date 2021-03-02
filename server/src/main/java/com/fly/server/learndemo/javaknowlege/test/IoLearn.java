package com.fly.server.learndemo.javaknowlege.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * description: i/0学习demo
 * date: 2021/3/2 15:58
 * version: 1.0
 *
 * @author: LIGEL
 */
public class IoLearn {


    public static void main(String[] args) {
        try(InputStream inputStream = new FileInputStream("/D:\\Resources\\电子书\\Go语言\\go语言高并发与微服务实战.pdf"))
        {
            int available = inputStream.available();
            if (available >0) {
                byte[] data= new byte[available];
                int read = inputStream.read(data);
                if (read > 0) {
                    System.out.println("读取成功！");
                }
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
