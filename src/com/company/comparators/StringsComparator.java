package com.company.comparators;

import java.util.Comparator;

public class StringsComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        Integer c1 = hashfunction(o1);
        Integer c2 = hashfunction(o2);
        return c1.compareTo(c2);
    }

    private int hashfunction(String string) {
        int c = 0;
        for (int i=0; i < string.length(); i++) {
            c += string.charAt(i);
        }
        return c;
    }
}
