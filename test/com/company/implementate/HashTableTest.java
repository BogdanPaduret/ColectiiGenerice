package com.company.implementate;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    public void initTest() {
        HashTable<Integer, String> hashTable = new HashTable<>(5);

    }

    @Test
    public void findKeyTest() {
        HashTable<String, Integer> hashTable = new HashTable<>(10);

        String keyInput = "ana,bogdan,cristi,marian,aan,bgdoan,ciistr";
        String[] keys = keyInput.split(",");

        Integer[] values = new Integer[keys.length];

        int c = 0;

        for (int i = 0; i < keys.length; i++) {
            values[i] = c;
            c++;
        }

        for (int i = 0; i < keys.length; i++) {
            hashTable.put(keys[i], values[i]);
        }

        assertEquals(5, hashTable.get(keys[5]));

    }

    @Test
    public void removeTest() {
        HashTable<String, Integer> hashTable = new HashTable<>(10);

        String keyInput = "ana,bogdan,cristi,marian,aan,bgdoan,ciistr";
        String[] keys = keyInput.split(",");

        Integer[] values = new Integer[keys.length];

        int c = 0;

        for (int i = 0; i < keys.length; i++) {
            values[i] = c;
            c++;
        }

        for (int i = 0; i < keys.length; i++) {
            hashTable.put(keys[i], values[i]);
        }

        String workingKey = keys[2];

        assertTrue(hashTable.exists(workingKey));
        hashTable.remove(workingKey);
        assertThrows(NoSuchElementException.class, () ->{
            hashTable.get(workingKey);
        });
        assertFalse(hashTable.exists(workingKey));

    }

}