package com.godeltech.module03_pt313;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 1. Реализовать класс для работы с двумерным массивом на базе коллекций (интерфейса Collection).
 * a) Реализовать методы get/set значения из строки и столбца
 * b) При проходе по коллекции использовать итератор
 * c) Все методы интерфейса Collection реализовывать не нужно, можно бросать UnsupportedOperationException
 * 2. Создать аннотацию, которую можно поместить на поля класса, которая генерирует случайное значение в этом поле.
 * Поля могут быть с типами: Integer, Boolean, String. Создать обработчик аннотации, который будет содержать логику генерации случайных значений.
 */

public class MultidimArray<T> implements Collection<T> {
    static Scanner scanner = new Scanner(System.in);
    T[][] array;
    T t;

    public MultidimArray(T[][] array) {
        this.array = array;
    }

    public T[][] getArray() {
        return array;
    }

    public T getStatementXY(Integer x, Integer y){
        return this.array[x][y];
    }

    public void setStatementXY(Integer x, Integer y, T t){
        this.array[x][y] = t;
    }

    @Override
    public int size() {
        return this.getArray().length;
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not support!");
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not support!");
    }

    @Override
    public Iterator<T> iterator() {


        return null;
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not support!");
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException("Not support!");
    }

    @Override
    public boolean add(T t) {
        System.out.println("Input X " + (this.array.length - 1) + " maximum");
        int x = scanner.nextInt();
        System.out.println("Input X " + (this.array[x].length - 1) + " maximum");
        int y = scanner.nextInt();
        this.array[x][y] = t;
        return t == null ? false : true;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not support!");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not support!");

    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException("Not support!");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not support!");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not support!");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not support!");
    }

    @Override
    public String toString() {
        return "MultidimArray{" +
                "array=" + Arrays.deepToString(array) +
                '}';
    }
}
