package com.company.implementate;

public class Stiva<T extends Comparable<T>> {

    //Last In First Out

    private Lista<T> stiva;

    public Stiva() {
        stiva = new Lista();
    }

    public void push(T data) {
        stiva.addFirst(data);
    }

    public void pop() {
        stiva.remove(0);
    }

    public T peek() {
        return stiva.getData(0);
    }

    public boolean isEmpty() {
        int size = stiva.size();
        if (size > 0) {
            return false;
        } else {
            return true;
        }
    }


}
