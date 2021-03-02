package com.godeltech.module03_pt335;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdasModule {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();

        personList.add(new Person("A", 123));
        personList.add(new Person("B", 234));
        personList.add(new Person("C", 345));
        personList.add(new Person("D", 456));
        personList.add(new Person("F", 567));
        personList.add(new Person("E", 789));
        personList.forEach(a -> a.setSalary(a.getSalary() + 100));
        personList.forEach(System.out::println);
        System.out.println();

        System.out.println("Predicate test:");
        Predicate<Integer> predicate = number -> number >= 44;
        System.out.println(predicate.test(50));

        System.out.println("Function test:");//
        Function<Integer, Integer> function = con -> con + 4444;
        System.out.println(function.apply(new Person("Vas", 333).getSalary()));

        System.out.println("Consume test:"); //do some actions on object, return nothing;
        Consumer<Integer> consumer = x -> {
            int y = x + 23;
            System.out.println("Consumer result for X: " + y);
        };
        consumer.accept(123);

        System.out.println("Supplier test:");//nothing to add in arguments as parameters,must return type in <>;
        Supplier<Person> supplier = () -> new Person("qwe", 2);
        System.out.println(supplier.get());
    }



}

class Person {

    private String name;
    private int salary;

    public Person(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
