package com.company.implementate;

import com.company.exceptions.ElementExistsException;

import java.util.Comparator;

public class Set<T extends Comparable<T>> {

    private Node<T> head = null;
    private Comparator<T> comparator = null;

    //constructori
    public Set() {

    }

    //create
    public void add(T data) throws ElementExistsException {
        if (!exists(data)) {
            if (head == null) {
                createFirstNode(data);
            } else {
                Node<T> node = createNode(data);
                Node<T> loop = head;
                Node<T> previous = null;
                while (loop != null) {

                    int compare;

                    if (comparator != null) {
                        compare = comparator.compare(loop.getData(), data);
                    }else{
                        compare = loop.getData().compareTo(data);
                    }

                    if (compare > 0) {
                        if (previous == null) {
                            head = node;
                        } else {
                            previous.setNext(node);
                        }
                        node.setNext(loop);
                        break;
                    }

                    previous = loop;
                    loop = loop.getNext();
                }
                if (loop == null) {
                    previous.setNext(node);
                }
            }
        } else {
            throw new ElementExistsException("Data already exists in set");
        }
    }

    //read
    public boolean exists(T data) {
        Node<T> loop = head;
        while (loop != null) {
            if (loop.getData().equals(data)) {
                return true;
            }
            loop = loop.getNext();
        }
        return false;
    }
    public int size() {
        int c = 0;
        Node<T> loop = head;
        while (loop != null) {
            loop = loop.getNext();
            c++;
        }
        return c;
    }
    public String traverse() {
        String string = "";

        Node<T> loop = head;
        while (loop != null) {
            string += loop.getData().toString() + "\n";
            loop = loop.getNext();
        }

        return string;
    }
    public Node<T> getNode(int index) throws IndexOutOfBoundsException{
        int c = 0;
        Node<T> loop = head;
        while (loop != null) {
            if (c == index) {
                return loop;
            }
            loop = loop.getNext();
        }
        throw new IndexOutOfBoundsException();
    }
    public int getIndex(T data) {
        Node<T> loop = head;
        int c = 0;
        while (loop != null) {
            if (loop.getData().equals(data)) {
                return c;
            }
            c++;
            loop = loop.getNext();
        }
        return -1;
    }

    public T getData(int index) throws IndexOutOfBoundsException {
        int c = 0;
        Node<T> loop = head;
        while (loop != null) {
            if (c == index) {
                return loop.getData();
            }
            c++;
            loop = loop.getNext();
        }
        throw new IndexOutOfBoundsException();
    }

    //update
    public void set(int index, T data) throws ElementExistsException{
        if (!exists(data)) {
            remove(index);
            add(data);
        } else {
            throw new ElementExistsException("Data already exists in set");
        }
    }

    //de refacut cu doua bucle while: inlocuiesti apoi megi cu while inainte sau inapoi

    public void setComparator(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    //delete
    public void remove(int index) {
        if (index == 0) {
            head = head.getNext();
        } else {
            int c = 0;

            Node<T> loop = head;
            Node<T> previous = head;

            while (loop != null) {
                if (c == index) {
                    previous.setNext(loop.getNext());
                    break;
                }
                loop = loop.getNext();
                c++;
            }
        }
    }

    //helpers
    private Node<T> createNode(T data) {
        return createNode(data, null);
    }
    private Node<T> createNode(T data, Node<T> next) {
        return new Node<>(data, next);
    }
    private void createFirstNode(T data) {
        head = createNode(data);
    }


}
