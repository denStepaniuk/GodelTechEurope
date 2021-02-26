package com.godeltech.module03_pt335;

public class LambdasModule {
    public static void main(String[] args) {

        System.out.println(summary(1, 2, (a, b) -> a + b));
    }

    static Integer summary(int a, int b, Summator s) {
        return s.sum(a, b);
    }
}

@FunctionalInterface
interface Summator {
    int sum(int x, int y);
}