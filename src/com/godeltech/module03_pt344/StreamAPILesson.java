package com.godeltech.module03_pt344;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class StreamAPILesson {
    static final Random random = new Random();
    static MenNames s;
    static final Integer[] ints = new Integer[1_000];
    static final List<AnotherPerson> personList = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        fillArrayRandomly();
        fillPersonsList();
        workWithFiles();

        //find person who get salary > 50k;
        personList.stream()
                .filter(x -> x.getSalary() > 50_000)
                .forEach(System.out::println);

        //find first in collection;
        Optional<AnotherPerson> first = personList.stream()
                .filter(x -> x.getSalary() > 25_000)
                .findFirst();
        first.ifPresent(System.out::println);

        //find first match occurrence;
        Optional<Integer> first1 = Stream.of(ints)
                .distinct()
                .filter(x -> x == 44)
                .findFirst();
        System.out.println(first1);

        //work with arrays;
        Stream.of(ints)
                .distinct()
                .filter(x -> x % 2 == 0)
                .filter(x -> x % 5 == 0)
                .sorted()
                .forEach(System.out::println);

        //find sum of all persons salary;
        int sum = personList.stream()
                .mapToInt(AnotherPerson::getSalary)
                .sum();
        System.out.println("Sum of all occurrences: " + sum);

        //fin average statement of al persons salary;
        OptionalDouble average = personList.stream()
                .mapToInt(AnotherPerson::getSalary)
                .average();
        System.out.println("Average statement is: " + average);

        Stream.generate(Random::new)
                .map(random -> random.nextInt(100))
                .filter(x->x>0)
                .limit(15)
                .forEach(System.out::println);

    }

    private static void fillArrayRandomly() {
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(1_000) + 1;
        }
    }

    private static void fillPersonsList() {
        for (int i = 0; i < 9; i++) {
            switch (i) {
                case 1:
                    s = MenNames.ALEX;
                    break;
                case 2:
                    s = MenNames.FELIX;
                    break;
                case 3:
                    s = MenNames.GEORG;
                    break;
                case 4:
                    s = MenNames.HARRY;
                    break;
                case 5:
                    s = MenNames.JHON;
                    break;
                case 6:
                    s = MenNames.MICHAEL;
                    break;
                case 7:
                    s = MenNames.NICK;
                    break;
                case 8:
                    s = MenNames.TIM;
                    break;
                case 9:
                    s = MenNames.TOM;
                    break;
                default:
                    s = MenNames.JHON;
            }
            personList.add(new AnotherPerson(s, random.nextInt(65 - 18) + 18,
                    random.nextInt(100_000 - 25_000) + 25_000));
        }
    }

    private static void workWithFiles() throws IOException {
        Files.lines(Paths.get("C:\\Users\\d.stsepaniuk\\IdeaProjects\\GodelTechEurope\\src\\com\\godeltech\\module03_pt344\\Hrodna.txt"))
                .filter(x -> x.length() > 60)
                .peek(System.out::println)
                .forEach(x -> System.out.println("Searching value is: " + x.length()));
    }
}

/**
 * As usual class for test;
 */
class AnotherPerson {
    private MenNames name;
    private int age;
    private int salary;

    public AnotherPerson(MenNames name, int age, int salary) {
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

    @Override
    public String toString() {
        return "AnotherPerson{" +
                "name - " + name +
                ", age = " + age +
                ", salary = " + salary +
                '}';
    }
}

/**
 * Simply enum with names for create instances of AnotherPerson.class;
 */
enum MenNames {
    TOM, HARRY, NICK, TIM, ALEX, JHON, MICHAEL, FELIX, GEORG
}