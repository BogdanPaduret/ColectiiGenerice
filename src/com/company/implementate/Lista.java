package com.company.implementate;

import com.company.models.Client;

import java.util.Comparator;

public class Lista<T extends Comparable<T>>{
    private Node<T> head = null;

    //create
    public void addFirst(T data) {
        if (head == null) {
            head = new Node<T>(data, null);
        } else {
            Node<T> node = new Node(data, head);
            head = node;
        }
    }
    public void addLast(T data) {
        if (head == null) {
            addFirst(data);
        } else {
            Node<T> currentLast = getNode(size() - 1);
            Node<T> node = new Node(data, null);
            currentLast.setNext(node);
        }
    }

    public void add(T data, int index) throws IndexOutOfBoundsException {
        if (size() > index) {
            if (index > 0) {
                Node<T> previous = getNode(index - 1);
                Node<T> current = previous.getNext();
                Node<T> node = new Node(data, current);
                previous.setNext(node);
            } else {
                addFirst(data);
            }
        } else if (size() == index) {
            addLast(data);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    //read
    public void set(T data, int index) {
        Node<T> node = getNode(index);
        node.setData(data);
    }

    public Node<T> getFirst() {
         return head;
    }
    public Node<T> getNode(int index) throws IndexOutOfBoundsException {
        if (size() > index) {
            Node<T> node = head;
            int c = 0;
            while (node != null) {
                if (c == index) {
                    return node;
                }
                c++;
                node = node.getNext();
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
        return null;
    }
    public T getData(int index) throws IndexOutOfBoundsException {
        if (size() > index) {
            Node<T> loop = head;
            int c = 0;
            while (loop != null) {
                if (c == index) {
                    return loop.getData();
                }
                c++;
                loop = loop.getNext();
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
        return null;
    }
    public int getIndex(Node<T> node) {
        Node<T> loop = head;
        int c = 0;
        while (loop != null) {
            if (loop == node) {
                return c;
            }
            c++;
            loop = loop.getNext();
        }
        return -1;
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

    public Node<T> getNext(Node<T> node) {
        return node.getNext();
    }

    public int size() {
        int c = 0;
        Node<T> node = head;
        while (node != null) {
            c++;
            node = node.getNext();
        }
        return c;
    }

    //update
    public void sortAscending(Comparator<T> comparator) {
        boolean flag;
        do {
            flag = true;
            for (int i = 0; i < size(); i++) {
                Node<T> node0 = getNode(i);
                Node<T> node1 = node0.getNext();
                T data0 = node0.getData();
                T data1;
                try {
                    data1 = node1.getData();
                    if (comparator.compare(data0, data1) > 0) {
                        T data = data0;
                        set(data1, i);
                        set(data, i + 1);
                        flag = false;
                    }
                } catch (NullPointerException e) {
                }

            }
        } while (flag == false);
    }
    public void sortDescending(Comparator<T> comparator) {
        boolean flag;
        do {
            flag = true;
            for (int i = 0; i < size(); i++) {
                Node<T> node0 = getNode(i);
                Node<T> node1 = node0.getNext();
                T data0 = node0.getData();
                T data1;
                try {
                    data1 = node1.getData();
                    if (comparator.compare(data0, data1) < 0) {
                        T data = data0;
                        set(data1, i);
                        set(data, i + 1);
                        flag = false;
                    }
                } catch (NullPointerException e) {
                }
            }
        } while (flag == false);
    }

    public void sortAscending() {
        boolean flag;
        do {
            flag = true;
            for (int i = 0; i < size(); i++) {
                Node<T> node0 = getNode(i);
                Node<T> node1 = node0.getNext();
                T data0 = node0.getData();
                T data1;
                try {
                    data1 = node1.getData();
                    if (data0.compareTo(data1)>0) {
                        T data = data0;
                        set(data1, i);
                        set(data, i + 1);
                        flag = false;
                    }
                } catch (NullPointerException e) {
                }

            }
        } while (flag == false);
    }
    public void sortDescending() {
        boolean flag;
        do {
            flag = true;
            for (int i = 0; i < size(); i++) {
                Node<T> node0 = getNode(i);
                Node<T> node1 = node0.getNext();
                T data0 = node0.getData();
                T data1;
                try {
                    data1 = node1.getData();
                    if (data0.compareTo(data1)<0) {
                        T data = data0;
                        set(data1, i);
                        set(data, i + 1);
                        flag = false;
                    }
                } catch (NullPointerException e) {
                }

            }
        } while (flag == false);
    }

    //delete
    public void remove(int index) throws IndexOutOfBoundsException {
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

    public void clear() {
        head = null;
    }

    //cel mai mare
    public T greatest() {
        Node<T> loop = head;
        T data = loop.getData();
        while (loop != null) {
            if (loop.getData().compareTo(data) > 0) {
                data = loop.getData();
            }
            loop = loop.getNext();
        }
        return data;
    }
    public T greatest(Comparator<T> comparator) {
        Node<T> loop = head;
        T data = loop.getData();
        while (loop != null) {
            if (comparator.compare(loop.getData(), data) > 0) {
                data = loop.getData();
            }
            loop = loop.getNext();
        }
        return data;
    }

    //cel mai  mic
    public T smallest() {
        Node<T> loop = head;
        T data = loop.getData();
        while (loop != null) {
            if (loop.getData().compareTo(data) < 0) {
                data = loop.getData();
            }
            loop = loop.getNext();
        }
        return data;
    }
    public T smallest(Comparator<T> comparator) {
        Node<T> loop = head;
        T data = loop.getData();
        while (loop != null) {
            if (comparator.compare(loop.getData(), data) < 0) {
                data = loop.getData();
            }
            loop = loop.getNext();
        }
        return data;
    }


}
