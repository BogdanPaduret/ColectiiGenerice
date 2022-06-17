package com.company.implementate;

public class Entry<K, V> implements Comparable<Entry<K,V>> {

    private  K key;

    private V value;

    public Entry(){};
    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        String string = "";
        string += "Key: " + key.toString();
        return string;
    }

    @Override
    public boolean equals(Object o) {
        Entry entry = (Entry) o;
        return this.key.equals(entry.key);
    }



    @Override
    public int compareTo(Entry<K, V> o) {
        return 0;//o.getValue().compareTo(value);
    }
}
