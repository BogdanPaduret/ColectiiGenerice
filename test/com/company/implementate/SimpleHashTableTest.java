package com.company.implementate;

import com.company.models.Client;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleHashTableTest {

    @Test
    void addTest() {
        SimpleHashTable<String, Client> sht = new SimpleHashTable();

        Client client = new Client(1, "ana", 123.4, false);
        Client client1 = new Client(2, "bogdan", 542.1, false);
        Client client2 = new Client(3, "cristian", 1256.6, true);
        Client client3 = new Client(4, "dumitru", 1230.1, true);
        Client client4 = new Client(5, "elena", 54.1, false);

        String string = "Ana";
        String string1 = "Andrei";
        String string2 = "Manuel";
        String string3 = "Vict";
        String string4 = "Ale";

        sht.put(string, client);
        sht.put(string1, client1);
        sht.put(string2, client2);
        sht.put(string3, client3);
        sht.put(string4, client4);

//        sht.show();

        int ana = sht.findKey(string);
        int andrei = sht.findKey(string1);
        int manuel = sht.findKey(string2);
        int vict = sht.findKey(string3);
        int ale = sht.findKey(string4);
        int no = sht.findKey("ele");

        assertEquals(3, ana);
        assertEquals(6, andrei);
        assertEquals(7, manuel);
        assertEquals(4, vict);
        assertEquals(5, ale);
        assertEquals(-1, no);

        sht.remove(string);

        sht.show();

//        assertEquals();

//        assertEquals(6, andrei);
//        assertEquals(7, manuel);
//        assertEquals(4, vict);
//        assertEquals(3, ale);

    }


}