package com.vilelapinheiro;

/**
 * Representa uma tupla de 3 itens
 * @author Leonardo Vilela Pinheiro
 */
public class Triplet<T, U, V> {
    final private T value1;
    final private U value2;
    final private V value3;

    public Triplet(T value1, U value2, V value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public T getValue1() {
        return value1;
    }

    public U getValue2() {
        return value2;
    }

    public V getValue3() {
        return value3;
    }
}