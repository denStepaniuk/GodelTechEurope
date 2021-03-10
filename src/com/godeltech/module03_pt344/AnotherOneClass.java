package com.godeltech.module03_pt344;
/**
 * Divine by type which AnotherPerson class have;
 */

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnotherOneClass {

    public static void main(String[] args) {

//        Runnable fillPersonsList = StreamAPILesson::fillPersonsList;
//        fillPersonsList.run();
//        StreamAPILesson.fillPersonsList();
//        StreamAPILesson.personList.forEach(System.out::println);
        divineByTypes(StreamAPILesson.fillPersonsList(), AnotherPerson::getCountry);
    }

    private static <R> void divineByTypes(List<AnotherPerson> list, Function<AnotherPerson, R> function) {
        Map<R, List<AnotherPerson>> collect = list.stream().collect(Collectors.groupingBy(function));
        collect.keySet().forEach(x -> System.out.println(x + "\n" + collect.get(x)));
    }

}
