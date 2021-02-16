package com.godeltech.module03_pt313;

import java.util.*;

public class MultidimArray<T> implements Collection <T>{

    T [][] array;

    public MultidimArray(T[][] array) {
        this.array = array;
    }

    public T[][] getArray() {
        return array;
    }

    public static void randomFillNumbers(Integer[][] array){
        Random random = new Random();
        for (int i = 0; i < array.length - 1; i++){
            for (int j = 0; j < array.length; j++) {
                array[i][j] = random.nextInt(100) + 1;
            }
        }

    }

    public static void main(String[] args) {

        MultidimArray<Integer> integers = new MultidimArray<>(new Integer[10][10]);
        System.out.println(integers.getArray().length);
        randomFillNumbers(integers.getArray());
        System.out.println(Arrays.deepToString(integers.getArray()));

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
