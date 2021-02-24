package com.godeltech.module03_pt323;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Имеется 4 завода по производству деталей и 4 завода по обработке этих деталей. имеется 1 склад.
 * Деталь представлена в виде простого Long. Склад представлен в виде коллекции с размером 1000.
 * Каждый завод-производитель после запуска делает по 2 млн деталей, и отправляет их на склад.
 * Соответственно, завод по обработке достаёт/извлекает детали со склада.
 * Задача - выбрать корректную реализацию коллекции (та что отвечает за склад), запустить эти 8 потоков,
 * вывести в консоль суммарное количество обработанных деталей четырьмя заводам-обработчиками и время затраченное
 * на обработку. Все детали должны быть обработаны т.е. заводы-обработчики должны обработать 4 Х 2_000_000 = 8 млн деталей суммарно.
 */
public class FourFactory {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 4; i++) {
            new Thread(new FactoryProducer()).start();
        }

        for (int i = 1; i <= 4; i++) {
            new Thread(new FactoryConsumer()).start();
        }

        TimeUnit.SECONDS.sleep(10);
        System.out.println("Shipped to consumers: " + MassMarkets.getMassMarkets().size());
    }

}

/**
 * Represent an object for store a collection;
 */
class MassMarkets {
    static BlockingQueue<Long> massMarkets = new LinkedBlockingQueue<>();

    public static BlockingQueue<Long> getMassMarkets() {
        return massMarkets;
    }
}

/**
 * Some thing like MassMarket class;
 */
class Warehouse {
    private static final int STORAGE_CAPACITY = 1_000;
    static BlockingQueue<Long> storage = new LinkedBlockingQueue<>(STORAGE_CAPACITY);

    public static BlockingQueue<Long> getStorage() {
        return storage;
    }
}

/**
 * Class realise logic of "produce" things, eventually, add long decimals into collection;
 */
class FactoryProducer implements Runnable {
    Random random = new Random();
    long detail = random.nextLong();

    @Override
    public void run() {
        try {
            produce();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void produce() throws InterruptedException {
        for (int i = 1; i <= 2_000_000; i++) {
            Warehouse.getStorage().put(detail);
        }
        System.out.println(Thread.currentThread() + " produce complete.");
    }
}

/**
 * Class simulate unloading "things" from warehouse;
 */
class FactoryConsumer implements Runnable {

    @Override
    public void run() {
        try {
            consume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void consume() throws InterruptedException {
        for (int i = 1; i <= 2_000_000; i++) {
            MassMarkets.getMassMarkets().put(Warehouse.getStorage().take()); //put statements into collection for view result;
        }
        System.out.println(Thread.currentThread() + " consume complete.");
    }
}
