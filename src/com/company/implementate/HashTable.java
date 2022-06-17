package com.company.implementate;

import java.util.NoSuchElementException;

public class HashTable<K, V extends Comparable<V>> {

    private Lista<Entry<K, V>>[] hashtable;

    public HashTable(int size) {
        hashtable = new Lista[size];

        for (int i = 0; i < hashtable.length; i++) {
            hashtable[i] = new Lista<>();
        }
    }

    //create
    public int hashFunction(K key) {
        String string = key.toString();
        int c = 0;
        for (int i = 0; i < string.length(); i++) {
            c += string.charAt(i);
        }
        return c % hashtable.length;
    }

    public void put(K key, V value) {
        int position = hashFunction(key);
        hashtable[position].addLast(new Entry<>(key, value));
    }

    //read
    public V get(K key) throws NoSuchElementException{
        int position = hashFunction(key);
        Lista<Entry<K, V>> workingList = hashtable[position];

        Entry<K, V> neededEntry = new Entry(key, null);

        int listIndex = workingList.getIndex(neededEntry);

        if (listIndex >= 0) {
            return workingList.getData(listIndex).getValue();
        } else {
            throw new NoSuchElementException("Elementul nu exista");
        }

    }

    public boolean exists(K key) {
        int pos = hashFunction(key);

        Lista<Entry<K, V>> workingList = hashtable[pos];

        int listIndex = workingList.getIndex(new Entry<>(key, null));

        if (listIndex == -1) {
            return false;
        } else {
            return true;
        }
    }

    //delete
    public void remove(K key) {
        int pos = hashFunction(key);

        Lista<Entry<K, V>> workingList = hashtable[pos];

        int listIndex = workingList.getIndex(new Entry<>(key, null));

        workingList.remove(listIndex);
    }

}
