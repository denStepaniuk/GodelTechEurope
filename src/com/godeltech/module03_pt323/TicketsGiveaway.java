package com.godeltech.module03_pt323;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Сэмулировать работу по раздаче скидочных купонов на сайте магазина.
 * Число купонов(n) ограничено и устанавливается в начале работы магазина.
 * Каждый пользователь может взять только ограниченное количество купонов(m).
 * После того как все купоны разобраны подсчитать сколько купонов имеется у каждого пользователя
 * и суммарное число купонов у всех пользователей.
 */
public class TicketsGiveaway {

    public static void main(String[] args) {
    ExecutorService exec = Executors.newFixedThreadPool(100);
        for(int i = 0; i <= 100; i++){
            exec.submit(new Costumer(i));
        }
    }
}

class Store {

    int ticketQuantity;
    int maxTicketPerCostumer;

    public Store(int ticketQuantity, int maxTicketPerCostumer) {
        this.ticketQuantity = ticketQuantity;
        this.maxTicketPerCostumer = maxTicketPerCostumer;
    }

    public int getTicketQuantity() {
        return ticketQuantity;
    }

    public int getMaxTicketPerCostumer() {
        return maxTicketPerCostumer;
    }
}

class Costumer implements Runnable {
    int ticketOwn;
    int costumerId;

    public Costumer(int costumerId) {
        this.costumerId = costumerId;
    }

    @Override
    public void run() {

    }
}