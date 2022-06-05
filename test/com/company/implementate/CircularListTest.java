package com.company.implementate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class CircularListTest {

    private CircularList<String> stringsList;

    @BeforeEach
    public void init() {
        stringsList = new CircularList<>();
    }

    @Test
    public void addFirstTest() {
        String[] strings = {"bat", "mere", "calc", "ana", "viorel"};

        for (String string : strings) {
            stringsList.addFirst(string);
        }

        String soll = "viorel\nana\ncalc\nmere\nbat\n";
        String ist = "";
        int size = stringsList.size();
        for (int i = 0; i < size; i++) {
            ist += stringsList.getData(i) + "\n";
        }
        assertEquals(soll, ist);
    }

    @Test
    public void addLastTest() {
        String[] strings = {"bat", "mere", "calc", "ana", "viorel"};

        for (String string : strings) {
            stringsList.addLast(string);
        }

        String soll = "bat\nmere\ncalc\nana\nviorel\n";
        String ist = "";
        int size = stringsList.size();
        for (int i = 0; i < size; i++) {
            ist += stringsList.getData(i) + "\n";
        }
        assertEquals(soll, ist);
    }

    @Test
    public void addTest() {
        String[] strings = {"bat", "mere", "calc", "ana", "viorel"};

        stringsList.add(strings[1], 0);
        stringsList.add(strings[3], 1);
        stringsList.add(strings[2], 1);
        stringsList.add(strings[4], 3);
        stringsList.add(strings[0], 0);

        String soll = "bat\nmere\ncalc\nana\nviorel\n";
        String ist = "";
        int size = stringsList.size();
        for (int i = 0; i < size; i++) {
            ist += stringsList.getData(i) + "\n";
        }
        assertEquals(soll, ist);
    }

    @Test
    public void sizeTest() {
        String[] strings = {"bat", "mere", "calc", "ana", "viorel"};

        for (String string : strings) {
            stringsList.addLast(string);
        }

        int size = stringsList.size();

        assertEquals(5, size);
    }

    @Test
    public void getNodeUTest() {
        String[] strings = {"bat", "mere", "calc", "ana", "viorel"};

        for (String string : strings) {
            stringsList.addLast(string);
        }

        Node<String> stringNode = stringsList.getNodeU(6);
        assertEquals("mere",stringNode.getData());
    }

    @Test
    public void getDataUTest() {
        String[] strings = {"bat", "mere", "calc", "ana", "viorel"};

        for (String string : strings) {
            stringsList.addLast(string);
        }

        String stringNode = stringsList.getDataU(6);
        assertEquals("mere",stringNode);
    }

    @Test
    public void getNodeTest() {
        String[] strings = {"bat", "mere", "calc", "ana", "viorel"};

        for (String string : strings) {
            stringsList.addLast(string);
        }

        Node<String> stringNode = stringsList.getNode(1);
        assertEquals("mere",stringNode.getData());
    }

    @Test
    public void getDataTest() {
        String[] strings = {"bat", "mere", "calc", "ana", "viorel"};

        for (String string : strings) {
            stringsList.addLast(string);
        }

        String stringNode = stringsList.getData(1);
        assertEquals("mere",stringNode);
    }

    @Test
    public void getIndexDataTest() {
        String[] strings = {"bat", "mere", "calc", "ana", "viorel"};

        for (String string : strings) {
            stringsList.addLast(string);
        }

        String toTest = "mere";
        int soll = 1;

        int ist = stringsList.getIndex(toTest);

        assertEquals(soll, ist);
    }

    @Test
    public void getIndexNodeTest() {
        String[] strings = {"bat", "mere", "calc", "ana", "viorel"};

        for (String string : strings) {
            stringsList.addLast(string);
        }

        Node<String> toTest = stringsList.getNode(1);
        int soll = 1;
        int ist = stringsList.getIndex(toTest);

        assertEquals(soll,ist);
    }

    @Test
    public void getIndexNodeFalseTest() {
        String[] strings = {"bat", "mere", "calc", "ana", "viorel"};

        for (String string : strings) {
            stringsList.addLast(string);
        }

        Node<String> toTest = new Node<>("mere", stringsList.getNode(stringsList.getIndex("calc")));
        String toTestString = toTest.toString();
        String receivedString = stringsList.getNode(stringsList.getIndex("mere")).toString();

        assertEquals(toTestString,receivedString);

        //nodul contine aceleasi data, cum pot sa fac sa-mi recunoasca ca fiind acelasi nod?
        int soll = 1;
        int ist = stringsList.getIndex(toTest);

        assertEquals(soll,ist);
    }

    @Test
    public void setTest() {
        String[] strings = {"bat", "mere", "calc", "ana", "viorel"};

        for (String string : strings) {
            stringsList.addLast(string);
        }

        String replace = "----";

        stringsList.set(replace, 2);

        String soll = replace;
        String ist = stringsList.getData(2);

        assertEquals(soll, ist);
    }

    @Test
    public void deleteTest() {
        String[] strings = {"bat", "mere", "calc", "ana", "viorel"};

        for (String string : strings) {
            stringsList.addLast(string);
        }

        int size = stringsList.size();
        assertEquals(5, size);

        stringsList.delete(2);
        size = stringsList.size();

        assertEquals(4, size);
        assertNotEquals("calc", stringsList.getData(2));
        assertEquals("ana", stringsList.getData(2));


    }

}