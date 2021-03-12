package com.godeltech.module03_pt351_nio;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DataTimeAPITests {

    public static void main(String[] args) {
        System.out.println("\n----------- old Java Calendar API -----------\n");
        Date date = new Date();

        Duration duration = Duration.ofDays(5);
        System.out.println("Duration " + duration);

        Period period = Period.ofDays(78);
        System.out.println("Period " + period);

        //get result of check if this date was before previous;
        long time = date.getTime();
        boolean before = date.before(new Date(13548987));

        System.out.println("Current date - " + date);
        System.out.println("Today from 1970(millis) - " + time);
        System.out.println("Is today before some new date in constructor? : " + before);

        System.out.println("\n----------- 'new' Java DateTime API -----------\n");

        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = localDate.atStartOfDay();

        //create date;
        LocalDate of = LocalDate.of(1983, 9, 28);
        System.out.println("Length of month: " + of.lengthOfMonth());
        System.out.println("Simple using of local date: " + localDate);
        System.out.println("Start of a day: " + localDateTime);
        System.out.println(localDate.getDayOfWeek() +" : "+ localDate.getDayOfMonth() +" : " + localDate.getYear() );

        //convert into ISO format;
        System.out.println("Convert to ISO format: " + localDateTime.format(DateTimeFormatter.ISO_DATE));

        //convert using pattern;
        LocalDateTime localDateTime1 = localDate.atTime(LocalTime.now());
        System.out.println("Convert using a pattern formatter: yy/mm/dd: "
                + localDateTime1.format(DateTimeFormatter.ofPattern("yy/MM//dd")));

        LocalTime parse = LocalTime.parse("15:30");
        LocalDateTime parse1 = LocalDateTime.parse("2007-12-03T10:15:30");
        System.out.println(parse1);
        System.out.println(parse);

    }
}
