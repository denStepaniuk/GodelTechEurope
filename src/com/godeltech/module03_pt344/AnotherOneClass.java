package com.godeltech.module03_pt344;

import java.util.stream.Stream;

public class AnotherOneClass {

    public static void main(String[] args) {
        // TODO: 3/4/2021 work with collections, especially Map, put statement in method and inside of him divide by
        // TODO: 3/4/2021 group of class, for example, persons divided by salary beyond 50k and above 50k;

        Runnable fillPersonsList = StreamAPILesson::fillPersonsList;
        fillPersonsList.run();
        StreamAPILesson.fillPersonsList();
        StreamAPILesson.personList.forEach(System.out::println);

    }

}
