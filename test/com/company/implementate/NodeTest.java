package com.company.implementate;

import com.company.comparators.ClientCreditComparator;
import com.company.comparators.ClientNameComparator;
import com.company.models.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    Lista<Client> lista;

    @BeforeEach
    public void setUp() {
        lista = new Lista();
    }

    @Test
    public void sizeTest() {

        Client client = new Client(1, "client0", 1234.56, true);
        Client client1 = new Client(2, "client1", 234.56, false);
        Client client2 = new Client(3, "client2", 3456.78, true);

        assertEquals(0, lista.size());

        lista.addFirst(client);
        assertEquals(1, lista.size());

        lista.addFirst(client1);
        assertEquals(2, lista.size());

        lista.addLast(client2);
        assertEquals(3, lista.size());
    }

    @Test
    public void addFirstLastTest() {
        Client client = new Client(1, "client0", 1234.56, true);
        Client client1 = new Client(2, "client1", 234.56, false);
        Client client2 = new Client(3, "client2", 3456.78, true);

        lista.addFirst(client);
        lista.addFirst(client1);
        lista.addLast(client2);

        assertEquals("client1", lista.getNode(0).getData().getName());
        assertEquals("client2", lista.getNode(lista.size() - 1).getData().getName());
    }

    @Test
    public void setTest() {
        Client client = new Client(1, "client0", 1234.56, true);
        Client client1 = new Client(2, "client1", 234.56, false);
        Client client2 = new Client(3, "client2", 3456.78, true);

        lista.addLast(client2);
        lista.addFirst(client1);
        lista.addFirst(client);

        Client client3 = new Client(4, "client3", 456.78, false);

        lista.set(client3, 1);

        assertEquals("client3", lista.getNode(1).getData().getName());
    }

    @Test
    public void addTest() {
        Client client = new Client(0, "client0", 1234.56, true);
        Client client1 = new Client(1, "client1", 234.56, false);
        Client client2 = new Client(2, "client2", 3456.78, true);
        Client client3 = new Client(3, "client3", 456.78, false);

        lista.add(client, 0);
        lista.add(client1, 0);
        lista.add(client2, 1);
        lista.add(client3, 1);

        assertEquals(4, lista.size());
        assertEquals(1, lista.getNode(0).getData().getId());
        assertEquals(3, lista.getNode(1).getData().getId());
        assertEquals(0, lista.getNode(lista.size() - 1).getData().getId());

        assertEquals(1, lista.getData(0).getId());
        assertEquals(3, lista.getData(1).getId());
        assertEquals(0, lista.getData(lista.size() - 1).getId());

    }

    @Test
    public void removeTest() {
        Client client = new Client(0, "client0", 1234.56, true);
        Client client1 = new Client(1, "client1", 234.56, false);
        Client client2 = new Client(2, "client2", 3456.78, true);
        Client client3 = new Client(3, "client3", 456.78, false);

        lista.addLast(client);
        lista.addLast(client1);
        lista.addLast(client2);
        lista.addLast(client3);

        assertEquals(4, lista.size());

        lista.remove(0);
        assertEquals(3, lista.size());
        assertEquals(1, lista.getNode(0).getData().getId());

        lista.remove(1);
        assertEquals(2, lista.size());
        assertEquals(3, lista.getNode(1).getData().getId());

        lista.remove(1);
        assertEquals(1, lista.size());
    }

    @Test
    public void getTest() {
        Client client = new Client(0, "client0", 1234.56, true);
        Client client1 = new Client(1, "client1", 234.56, false);
        Client client2 = new Client(2, "client2", 3456.78, true);
        Client client3 = new Client(3, "client3", 456.78, false);

        lista.addLast(client);
        lista.addLast(client1);
        lista.addLast(client2);
        lista.addLast(client3);

        Node<Client> node = lista.getNode(1);
        Client review = lista.getData(2);

        assertEquals(0, lista.getIndex(client));
        assertEquals(1, lista.getIndex(client1));
        assertEquals(2, lista.getIndex(client2));
        assertEquals(3, lista.getIndex(client3));

        assertEquals(1, lista.getIndex(node));

        assertEquals(2, review.getId());

    }

    @Test
    public void sortAscendingComparatorTest() {
        Client client = new Client(0, "Bogdan", 1234.56, true);
        Client client1 = new Client(1, "Victor", 234.56, false);
        Client client2 = new Client(2, "Ana", 3456.78, true);
        Client client3 = new Client(3, "Daniel", 456.78, false);

        lista.addLast(client);
        lista.addLast(client1);
        lista.addLast(client2);
        lista.addLast(client3);

        lista.sortAscending(new ClientNameComparator());

        assertEquals("Ana", lista.getData(0).getName());
        assertEquals("Bogdan", lista.getData(1).getName());
        assertEquals("Daniel", lista.getData(2).getName());
        assertEquals("Victor", lista.getData(3).getName());
    }

    @Test
    public void sortDescendingComparatorTest() {
        Client client = new Client(0, "Daniel", 1234.56, true);
        Client client1 = new Client(1, "Ana", 234.56, false);
        Client client2 = new Client(2, "Victor", 3456.78, true);
        Client client3 = new Client(3, "Bogdan", 456.78, false);

        lista.addLast(client);
        lista.addLast(client1);
        lista.addLast(client2);
        lista.addLast(client3);

        lista.sortDescending(new ClientNameComparator());

        assertEquals("Victor", lista.getData(0).getName());
        assertEquals("Daniel", lista.getData(1).getName());
        assertEquals("Bogdan", lista.getData(2).getName());
        assertEquals("Ana", lista.getData(3).getName());
    }

    @Test
    public void sortAscending() {
        Client client = new Client(2, "Bogdan", 1234.56, true);
        Client client1 = new Client(3, "Victor", 234.56, false);
        Client client2 = new Client(0, "Ana", 3456.78, true);
        Client client3 = new Client(1, "Daniel", 456.78, false);

        lista.addLast(client);
        lista.addLast(client1);
        lista.addLast(client2);
        lista.addLast(client3);

        lista.sortAscending();
        assertEquals(0, lista.getData(0).getId());
        assertEquals(1, lista.getData(1).getId());
        assertEquals(2, lista.getData(2).getId());
        assertEquals(3, lista.getData(3).getId());
    }

    @Test
    public void greatestTest() {
        Client client = new Client(2, "Bogdan", 1234.56, true);
        Client client1 = new Client(3, "Victor", 234.56, false);
        Client client2 = new Client(0, "Ana", 3456.78, true);
        Client client3 = new Client(1, "Daniel", 456.78, false);

        lista.addLast(client);
        lista.addLast(client1);
        lista.addLast(client2);
        lista.addLast(client3);

        assertEquals(3, lista.greatest().getId());
    }

    @Test
    public void smallestTest() {
        Client client = new Client(2, "Bogdan", 1234.56, true);
        Client client1 = new Client(3, "Victor", 234.56, false);
        Client client2 = new Client(0, "Ana", 3456.78, true);
        Client client3 = new Client(1, "Daniel", 456.78, false);

        lista.addLast(client);
        lista.addLast(client1);
        lista.addLast(client2);
        lista.addLast(client3);

        assertEquals(0, lista.smallest().getId());
    }

    @Test
    public void greatestGenericTest() {
        Client client = new Client(2, "Bogdan", 1234.56, true);
        Client client1 = new Client(3, "Victor", 234.56, false);
        Client client2 = new Client(0, "Ana", 3456.78, true);
        Client client3 = new Client(1, "Daniel", 456.78, false);

        lista.addLast(client);
        lista.addLast(client1);
        lista.addLast(client2);
        lista.addLast(client3);

        assertEquals("Victor", lista.greatest(new ClientNameComparator()).getName());
        assertEquals(3456.78, lista.greatest(new ClientCreditComparator()).getCredit());
    }

    @Test
    public void smallestGenericTest() {
        Client client = new Client(2, "Bogdan", 1234.56, true);
        Client client1 = new Client(3, "Victor", 234.56, false);
        Client client2 = new Client(0, "Ana", 3456.78, true);
        Client client3 = new Client(1, "Daniel", 456.78, false);

        lista.addLast(client);
        lista.addLast(client1);
        lista.addLast(client2);
        lista.addLast(client3);

        assertEquals("Ana", lista.smallest(new ClientNameComparator()).getName());
        assertEquals(234.56, lista.smallest(new ClientCreditComparator()).getCredit());

    }

}