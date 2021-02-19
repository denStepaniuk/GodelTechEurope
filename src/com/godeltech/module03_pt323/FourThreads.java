package com.godeltech.module03_pt323;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Создать 4 потока(через Executor Service), вставить из каждого потока по 5 млн любых Long в один общий array list.
 * Вывести общее время выполнения всех потоков в миллисекундах в консоль.
 * После завершения работы всех потоков вывести размер коллекции в консоль.
 */

public class FourThreads {
    static List<Long> longList = new ArrayList<>();
    static int counter;
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++){

                }
            }
        });
        executor.shutdown();
        System.out.println("Hello from Main!");
    }

}
