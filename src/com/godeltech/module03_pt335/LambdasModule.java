package com.godeltech.module03_pt335;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdasModule {

    public static void main(String[] args) {
        /**
         * List of pojo;
         */
        List<Person> personList = new ArrayList<>();

        personList.add(new Person("A", 123, 12));
        personList.add(new Person("B", 234, 23));
        personList.add(new Person("C", 345, 55));
        personList.add(new Person("D", 456, 44));
        personList.add(new Person("F", 567, 56));
        personList.add(new Person("E", 789, 48));
//        personList.forEach(a -> a.setSalary(a.getSalary() + 100));
//        personList.forEach(System.out::println);
//        System.out.println();
//
//        System.out.println("Predicate test:");// better use when needs to compare some elements and acquire specify;
//        Predicate<Integer> predicate = number -> number >= 44;
//        System.out.println(predicate.test(50));
//
//        System.out.println("Function test:");//
//        Function<Integer, Integer> function = con -> con + 4444;
//        System.out.println(function.apply(new Person("Vas", 333, 20).getSalary()));
//
//        System.out.println("Consume test:"); //do some actions on object, return nothing;
//        Consumer<Integer> consumer = x -> {
//            int y = x + 23;
//            System.out.println("Consumer result for X: " + y);
//        };
//        consumer.accept(123);
//
//        System.out.println("Supplier test:");//nothing to add in arguments as parameters,must return type in <>;
//        Supplier<Person> supplier = () -> new Person("qwe", 2, 33);
//        System.out.println(supplier.get());

        Predicate<Person> isReach = x -> x.getSalary() > 300;
        Predicate<Person> isAged = x -> x.getAge() > 50;
        System.out.println(findAll(personList, isReach.and(isAged))+"\n");

        Function<Person, String> function = Person::getName;
        Function<String, String> function1 = x -> "Hello " + x;
        Function<Person, String> compose = function1.compose(function);
        System.out.println(compose.apply(personList.get(2)));

    }

    /**
     * Method represents logic for searching statements describes lambdas interfaces (Predicate);
     */
    static List<Person> findAll(List<Person> personList, Predicate<Person> predicate){
        List<Person> personArrayList = new ArrayList<>();
        for (Person p : personList){
            if (predicate.test(p)){
                personArrayList.add(p);
            }
        }
        return personArrayList;
    }

}

/**
 * Usual class for tests on him lambdas methods;
 */
class Person {

    private String name;
    private int salary;
    private int age;

    public Person(String name, int salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
                ", age=" + age +
                '}';
    }
}
