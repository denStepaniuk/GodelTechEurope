package com.godeltech;

import java.util.TreeSet;

public class Car implements Comparable<Car> {
    private String model;
    private int cost;

    public Car(String model, int cost) {
        this.model = model;
        this.cost = cost;
    }

    public String getModel() {
        return model;
    }

    public int getCost() {
        return cost;
    }

    public static void main(String[] args) {
        TreeSet<Car> cars = new TreeSet<>();
        cars.add(new Car("SomeCar", 34));
        cars.add(new Car("SomeCar", 324));
        cars.add(new Car("SomeCar", 341));
        cars.add(new Car("SomeCar", 434));
        cars.add(new Car("SomeCar", 3234));
        cars.add(new Car("SomeCar", 345));
        cars.add(new Car("SomeCar", 3224));

        for (Car car : cars){
            System.out.println(car.cost);
        }

    }

    @Override
    public int compareTo(Car anotherCarCost) {
        if (this.cost < anotherCarCost.cost) {
            return -1;
        } else if (this.cost > anotherCarCost.cost) {
            return 1;
        }
        return 0;
    }
}
