package com.godeltech.module03_pt313;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MultiDimArrayStarter {

    public static void main(String[] args) {
        //add Integer types;
        MultiDimArray<Integer> integers = new MultiDimArray<>(new Integer[1][3]);
        integers.setStatementXY(0, 2, 159);
        System.out.println(integers.getStatementXY(0, 2));

        //add String types;
        MultiDimArray<String> strings = new MultiDimArray<>(new String[1][3]);
        strings.setStatementXY(0, 1, "Hello!");
        System.out.println(strings.getStatementXY(0, 1));

        //add custom types;
        MultiDimArray<Person> people = new MultiDimArray<>(new Person[1][2]);
        people.setStatementXY(0, 0, new Person("Georg", 18));
        for (int i = 0; i < people.size(); i++) {
            for (int j = 0; j < people.size(); j++) {
                System.out.println(people.getStatementXY(i,j));
            }
        }
        //add trough interface;
        Collection<Integer> collection = new MultiDimArray<>(new Integer[1][5]);
        collection.add(456);
        System.out.println("This collection " + collection.toString());
        /**
         * Done with iterator which implemented inside class;
         */
        Iterator<?> iterator = integers.iterator();
        while(iterator.hasNext()){
            System.out.println("Iterator - " + iterator.next());
        }
        /**
         * Done with streams and multithreading;
         */
        String s = Arrays.toString(collection.parallelStream().toArray());
        System.out.println(s);
    }
}

class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "com.godeltech.module03_pt313.Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}