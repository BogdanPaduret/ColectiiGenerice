package com.company.implementate;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class SortedHashTable<K, V extends Comparable<V>> {

    private Set<Entry<K, V>>[] hashtable;

    public SortedHashTable(int size, Comparator<Entry<K, V>> comparator) {

        hashtable = new Set[size];

        for (int i = 0; i < size; i++) {
            hashtable[i] = new Set<>();
            hashtable[i].setComparator(comparator);
        }
    }

    //create
    private int hashFunction(K key) {
        String string = key.toString();
        int c = 0;

        for (int i = 0; i < string.length(); i++) {
            c += string.charAt(i);
        }

        return c % hashtable.length;
    }
    public void put(K key, V value) {
        int pos = hashFunction(key);
        try {
            hashtable[pos].add(new Entry<>(key, value));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //read
    public V get(K key) throws NoSuchElementException {
        int position = hashFunction(key);
        Set<Entry<K, V>> workingList = hashtable[position];

        Entry<K, V> neededEntry = new Entry<>(key, null);

        int listIndex = workingList.getIndex(neededEntry);

        if (listIndex >= 0) {
            return workingList.getData(listIndex).getValue();
        } else {
            throw new NoSuchElementException("Elementul nu exista");
        }
    }

    //delete
    public void remove(K key) {
        int position = hashFunction(key);
        Set<Entry<K, V>> workingList = hashtable[position];

        int listIndex = workingList.getIndex(new Entry<>(key, null));

        workingList.remove(listIndex);
    }
}
