package com.godeltech.module03_pt313;
/**
 * 2. Создать аннотацию, которую можно поместить на поля класса, которая генерирует случайное значение в этом поле.
 * Поля могут быть с типами: Integer, Boolean, String. Создать обработчик аннотации, который будет содержать логику генерации случайных значений.
 */

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Random;

public class TestAnnotationMain {

    public static void main(String[] args) throws IllegalAccessException {
        TestAnnotationMain test = new TestAnnotationMain();
        Car car = new Car();
        test.print(car, car.getClass());
        Class<Car> carClass = Car.class;
        Field[] declaredFields = carClass.getDeclaredFields();
        for (Field field : declaredFields){
            System.out.println(field.getName() + ", " + field.getType());
        }
    }

    void print(Object o, Class<? extends Car> c) throws IllegalAccessException {
        Random random = new Random();
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
            for (Annotation annotation : declaredAnnotations) {
                if (annotation.annotationType().equals(RandomStatements.class)) {
                    field.setInt(o, random.nextInt(100));
                    System.out.println("Integer statement: " + field.get(o));

                }
            }
        }
    }
}

class Car {
    @RandomStatements
    int id;
    boolean isPetrol;
    String model;

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", isPetrol=" + isPetrol +
                ", model='" + model + '\'' +
                '}';
    }
}