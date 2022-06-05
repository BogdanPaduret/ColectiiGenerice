package com.company.comparators;

import com.company.models.Client;

import java.util.Comparator;

public class ClientCreditComparator implements Comparator<Client> {
    @Override
    public int compare(Client o1, Client o2) {
        Double o1Credit = o1.getCredit();
        Double o2Credit = o2.getCredit();
        return o1Credit.compareTo(o2Credit);
    }

}
