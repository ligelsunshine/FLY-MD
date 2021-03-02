package com.fly.server.learndemo.javaknowlege.test;

import com.fly.server.learndemo.javaknowlege.Employee;
import com.fly.server.learndemo.javaknowlege.Manager;

import java.io.*;

/**
 * description: ObjectStreamTest
 * date: 2021/3/2 16:28
 * version: 1.0
 *
 * @author: LIGEL
 */
public class ObjectStreamTest   {
    /**
     * description: 这种序列化是深拷贝，如果直接调用对象的clone方法，是浅拷贝
     * version: 1.0
     * date: 2021/3/2 16:53
     * @author: LIGEL
     * @param args
     * @return void
     */
    public static void main(String[] args) throws IOException {
        // 判断文件是否存在
        String path = "C:\\Users\\LIGEL\\Desktop\\employee.bat";
        File file = new File(path);
        if (file.exists()) {
            file.createNewFile();
        }
        Employee harry = new Employee("harry", 123, 123);
        Manager car1 = new Manager("car1", 11111, 3131);
        car1.setSecretary(harry);
        Manager tony = new Manager("Tony Test", 4000, 31313);
        tony.setSecretary(harry);
        Employee[] staff = new Employee[3];
        staff[0] = car1;
        staff[1] = harry;
        staff[2] = tony;
        // 将对象序列化出去
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(staff);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 读取对象流，相当于拷贝对象
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {

            Employee[] newStaff = (Employee[]) in.readObject();
            newStaff[0].setSalary(100000);
            for (Employee employee : newStaff) {
                System.out.println("序列化的对象" + employee);
            }
            for (Employee employee : staff) {
                System.out.println("序列化之前的对象：" + employee);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 释放资源，将序列化的资源清空
            try {
                if (file.exists()) {
                    // 删除文件
                    file.delete();
                    // 下面代码是清空文件
                    /*file.createNewFile();
                    FileWriter fileWriter = new FileWriter(file);
                    fileWriter.write("");
                    fileWriter.flush();
                    fileWriter.close();*/
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
