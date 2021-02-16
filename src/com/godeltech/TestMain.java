package com.godeltech;

import java.util.*;

public class TestMain {
    public static void main(String[] args) {
        Random random = new Random();
        Map<Integer, Integer> integerMap = new HashMap<>();
        Map<Integer, String> stringMap = new HashMap<>();
        stringMap.put(1, "as");
        stringMap.put(1231, "sdgg");
        stringMap.put(121, "asdsg");
        stringMap.put(56581, "';lfb");
        stringMap.put(61, "vmbejue");
        stringMap.put(5671, "asd");
        stringMap.put(351, "asdasdw");
        stringMap.put(71724, "e34sd");

        System.out.println(stringMap);

//        for (int i = 0; i < 100; i++) {
//            int nums = random.nextInt(10);
//            Integer frequency = integerMap.get(nums);
//            integerMap.put(nums, frequency == null ? 1 : frequency + 1);
//        }
    }

    public <T> void someMethod(List<T> list) {

    }
}
