package com.godeltech.module03_pt323;

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

/**
 * Class starts executors with main thread inside;
 */
public class FourThreads {
    static List<Long> longList = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(4);

        for (int i = 0; i <= 4; i++) {
            service.submit(new Threader());
        }
        service.shutdown();
        boolean b = service.awaitTermination(5, TimeUnit.SECONDS);
        if (b) {
            viewSize(longList);
        }
    }

    /**
     * Method for view size of current collection;
     */
    static void viewSize(List<Long> list) {
        System.out.println("Collection size:" + list.size());
    }

    /**
     * Getter which return whole collection as exist;
     */
    public List<Long> getLongList() {
        return longList;
    }

    /**
     * Method which realised fill specify collection
     */
    synchronized void fillCollection(List<Long> list) {
        Random random = new Random();
        list.add(random.nextLong());
    }
}

/**
 * Class for realisation fill collections with helps of several threads;
 */
class Threader extends Thread {

    @Override
    public void run() {
        FourThreads fourThreads = new FourThreads();

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 5_000_000; i++) {
            fourThreads.fillCollection(fourThreads.getLongList());
        }
        long finishTime = System.currentTimeMillis();
        System.out.println("Thread name: " + Thread.currentThread().getName() + " spend time (millis): " + (finishTime - startTime));
    }
}