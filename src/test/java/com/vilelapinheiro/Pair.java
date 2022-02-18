package com.vilelapinheiro;

/**
 * Representa uma tupla de 2 itens
 * @author Leonardo Vilela Pinheiro
 */
public class Pair<T, U> {
    final private T value1;
    final private U value2;

    public Pair(T value1, U value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public T getValue1() {
        return value1;
    }

    public U getValue2() {
        return value2;
    }
}
