package com.fly.server.learndemo.javaknowlege;

import lombok.Data;

import java.io.Serializable;

/**
 * description: Employee
 * date: 2021/3/2 16:31
 * version: 1.0
 *
 * @author: LIGEL
 */
@Data
public class Employee implements Serializable {

    private static final long serialVersionUID = 3957216702352071792L;
    private String name;
    private double salary;
    private int age;

    public Employee(String name, double salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }
}
