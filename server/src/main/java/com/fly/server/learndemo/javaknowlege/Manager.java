package com.fly.server.learndemo.javaknowlege;

import java.io.Serializable;

/**
 * description: Manager
 * date: 2021/3/2 16:29
 * version: 1.0
 *
 * @author: LIGEL
 */

public class Manager extends Employee implements Serializable {
    private static final long serialVersionUID = -3425977266199113756L;
    private String name;
    private double salary;
    private int age;
    private Employee secretary;

    public Manager(String name, double salary, int age) {
        super(name,salary,age);
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    public Employee getSecretary() {
        return secretary;
    }

    public void setSecretary(Employee secretary) {
        this.secretary = secretary;
    }
}
