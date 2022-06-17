package com.company.implementate;

public class SimpleHashTable <K,V> {

    private Entry<K,V>[]hashtable;

    public SimpleHashTable(){
        hashtable= new Entry[10];
    }

    public void put(K key , V value) {
        int pozitie = hashKey(key);
        if (occupied(pozitie)) {
            int stop = pozitie;
            if (pozitie == hashtable.length - 1) {
                pozitie = 0;
            } else {
                pozitie++;
            }
            while (occupied(pozitie) && pozitie != stop) {
                pozitie = hashKey2(key, pozitie);
            }
        }
        if (occupied(pozitie)) {
            System.out.println("sadas");
        } else {
            hashtable[pozitie] = new Entry<>();
            hashtable[pozitie].setKey(key);
            hashtable[pozitie].setValue(value);
        }
    }

    private  int hashKey(K key){
        return  key.toString().length()%hashtable.length;
    }

    private int hashKey2(K key, int p) {
        return (p + 1) % hashtable.length;
    }

    private boolean occupied(int index){
        return hashtable[index]!=null;
    }

    public void show() {
        int c = 0;
        for (Entry<K, V> data : hashtable) {
            if (data != null) {
                System.out.println(c + ": " + data.getValue().toString());
            } else {
                System.out.println(c + ": is null");
            }
            c++;
        }
    }

    public int findKey(K key) {
        int pozitie = hashKey(key);

        if (hashtable[pozitie] != null && hashtable[pozitie].getKey().equals(key)) {
            return pozitie;
        }
        int stop = pozitie;
        if (pozitie == hashtable.length - 1) {
            pozitie = 0;
        } else {
            pozitie++;
        }


        while (occupied(pozitie) && pozitie != stop) {
            if (hashtable[pozitie].getKey().equals(key)) {
                return pozitie;
            }
            pozitie = hashKey2(key, pozitie);
        }
        return -1;
    }

    public Entry<K, V>[] getTable() {
        return hashtable;
    }

    public void remove(K key) {
        SimpleHashTable<K, V> cleanTable = new SimpleHashTable<>();
        for (Entry<K, V> entry : hashtable) {
            if (entry != null && entry.getKey() != key) {
                cleanTable.put(entry.getKey(), entry.getValue());
            }
        }
        hashtable = cleanTable.getTable();
    }

}
