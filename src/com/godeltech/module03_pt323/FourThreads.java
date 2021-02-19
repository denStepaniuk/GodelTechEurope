package com.godeltech.module03_pt323;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Создать 4 потока(через Executor Service), вставить из каждого потока по 5 млн любых Long в один общий array list.
 * Вывести общее время выполнения всех потоков в миллисекундах в консоль.
 * После завершения работы всех потоков вывести размер коллекции в консоль.
 */

public class FourThreads {
    static List<Long> longList = new ArrayList<>();

    // TODO: 2/19/2021 refactor main method for correct time displayed how threads work
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 5; i++) {
            long startTime = System.currentTimeMillis();
            service.submit(new Threader());
            long finishTime = System.currentTimeMillis();
            System.out.println("Total time for " + Thread.currentThread().getName() + " is " + (finishTime - startTime));
        }
    }

    private static void fillCollection(List<Long> list) {

    }

    public void viewSize(List<Long> list) {
        System.out.println("Collection size:" + list.size());
    }

    public List<Long> getLongList() {
        return longList;
    }
}

class Threader extends Thread {

    @Override
    public void run() {
        FourThreads fourThreads = new FourThreads();
        for (int i = 0; i < 5_000_000; i++) {

            fillCollection(fourThreads.getLongList());
//            System.out.println(Thread.currentThread().getName());
        }
        fourThreads.viewSize(fourThreads.getLongList());
    }

    void fillCollection(List<Long> list) {
        Random random = new Random();
        list.add(random.nextLong());
    }
}