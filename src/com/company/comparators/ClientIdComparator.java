package com.company.comparators;

import com.company.models.Client;

import java.util.Comparator;

public class ClientIdComparator implements Comparator<Client> {
    @Override
    public int compare(Client o1, Client o2) {
        Integer o1Id = o1.getId();
        Integer o2Id = o2.getId();
        return o1Id.compareTo(o2Id);
    }

}
