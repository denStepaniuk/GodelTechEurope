package com.godeltech.module03_pt344;

import java.io.Serializable;

/**
 * As usual class for test;
 */
public class AnotherPerson implements Serializable {
    private String country;
    private MenNames name;
    private int age;
    private int salary;

    public AnotherPerson(String country, MenNames name, int age, int salary) {
        this.country = country;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public MenNames getName() {
        return name;
    }

    public void setName(MenNames name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "AnotherPerson{" +
                "name - " + name +
                ", age = " + age +
                ", salary = " + salary +
                '}';
    }
}
