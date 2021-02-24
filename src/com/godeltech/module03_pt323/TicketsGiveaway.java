package com.godeltech.module03_pt323;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Сэмулировать работу по раздаче скидочных купонов на сайте магазина.
 * Число купонов(n) ограничено и устанавливается в начале работы магазина.
 * Каждый пользователь может взять только ограниченное количество купонов(m).
 * После того как все купоны разобраны подсчитать сколько купонов имеется у каждого пользователя
 * и суммарное число купонов у всех пользователей.
 */
public class TicketsGiveaway {
    static int quantityOfTickets = 1000;
    static int quantityOfCostumers = 100;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <= quantityOfTickets; i++) {
            Store.getTicketList().add(new Ticket(i));
        }

        ExecutorService exec = Executors.newFixedThreadPool(quantityOfCostumers);
        for (int i = 0; i <= quantityOfCostumers; i++) {
            exec.submit(new Costumer(i));
        }
        exec.shutdown();
        exec.awaitTermination(15, TimeUnit.SECONDS);
        System.out.println("___________________________________________________________");
        System.out.println("Total tickets costumers have: " + (quantityOfTickets - Store.getTicketList().size()));
        System.out.println("Total costumers come: " + Costumer.costumers);
    }
}

/**
 * Class realise store/keeper of tickets;
 */
class Store {
    static List<Ticket> ticketList = new LinkedList<>();
    static final int maxTicketPerCostumer = 10;

    public static List<Ticket> getTicketList() {
        return ticketList;
    }
}

/**
 * Class realise tickets for giveaway;
 */
class Ticket {
    int ticketId;

    public Ticket(int ticketId) {
        this.ticketId = ticketId;
    }
}

/**
 * Class realise costumer which takes a tickets;
 */
class Costumer implements Runnable {
    static int costumers;
    int ticketOwn;
    int costumerId;
    final Object lock = new Object();

    public Costumer(int costumerId) {
        this.costumerId = costumerId;
        costumers++;
    }

    void getTickets() {
        Random random = new Random();
        /**
         * Random giveaway of tickets, no more than maxTicketPerCostumer count;
         */
        if (!Store.getTicketList().isEmpty()) {
            for (int i = 0; i <= random.nextInt(Store.maxTicketPerCostumer); i++) {
                Store.getTicketList().remove(random.nextInt(Store.getTicketList().size() - 1));
                this.ticketOwn++;
            }
        } else {
            return;
        }
        System.out.println("Costumer N:" + this.costumerId + " have " + this.ticketOwn + " tickets.");
    }

    @Override
    public void run() {
        getTickets();
    }
}