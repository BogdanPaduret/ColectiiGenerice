package com.company.implementate;

import javax.management.InstanceNotFoundException;

public class CircularList<T extends  Comparable<T>>{

    private Node<T> head = null;
    private Node<T> tail = null;

    //create
    public void addFirst(T data) {
        if (head == null) {
            head = new Node<>(data, null);
            head.setNext(head);
            tail = head;
        } else {
            head = new Node<>(data, head);
            tail.setNext(head);
        }
    }
    public void addLast(T data) {
        if (head == null) {
            addFirst(data);
        } else {
            Node<T> node = new Node<>(data, head);
            tail.setNext(node);
            tail = node;
        }
    }
    public void add(T data, int index) throws IndexOutOfBoundsException{
        int size = size();
        if (size > index) {
            if (index == 0) {
                addFirst(data);
            } else {
                Node<T> previous = getNode(index - 1);
                Node<T> current = previous.getNext();
                Node<T> node = new Node<>(data, current);
                previous.setNext(node);
            }
        } else if (size == index) {
            addLast(data);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    //read
    public int size() {
        int c = 0;
        if (head != null) {
            c++;
            Node<T> node = head.getNext();
            while (node != head) {
                c++;
            }
        }
        return c;
    }

    public Node<T> getNode(int index) throws IndexOutOfBoundsException{
        if (size() > index) {
            if (index == 0) {
                return head;
            } else {
                Node<T> node = head.getNext();
                int c = 1;
                while (node != head) {
                    if (c == index) {
                        return node;
                    }
                    c++;
                    node = node.getNext();
                }
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
        return null;
    }

    //update
    public void set(T data, int index) {
        getNode(index).setData(data);
    }

    //delete
    public void delete(int index) throws IndexOutOfBoundsException {
        if (index == 0) {
            head = getNode(index).getNext();
        } else if (size() > index) {
            Node<T> previous = getNode(index - 1);
            Node<T> node = previous.getNext();
            previous.setNext(node.getNext());
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

}
