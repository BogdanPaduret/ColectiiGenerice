package com.company.implementate;

public class Coada<T extends Comparable<T>> {

    //First In First Out

    private Lista<T> coada;

    public Coada() {
        coada = new Lista<>();
    }

    public void push(T data) {
        coada.addLast(data);
    }

    public void pop() {
        coada.remove(0);
    }

    public T peek() {
        return coada.getData(0);
    }

    public boolean isEmpty() {
        if (coada.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

}
