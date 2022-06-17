package com.company.implementate;

import com.company.comparators.StringsComparator;
import com.company.exceptions.ElementExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetTest {

    Set<String> set;

    @BeforeEach
    void init() {
        set = new Set<>();
    }

    @Test
    void addTest() {
        String strings = "Mihai,Ana,Victor,Victor,Bianca,Vlad";
        String[] stringsArray = strings.split(",");

        for (int i = 0; i < stringsArray.length; i++) {
            try {
                set.add(stringsArray[i]);
            } catch (ElementExistsException e) {
                System.out.println("Dublura gasita: " + stringsArray[i]);
            }
        }

        String ist = set.traverse();

        System.out.println(ist);


    }

    @Test
    void addWithComparatorTest() {
        String strings = "Mihai,Ana,Victor,Victor,Bianca,Vlad";
        String[] stringsArray = strings.split(",");

        set.setComparator(new StringsComparator());

        for (int i = 0; i < stringsArray.length; i++) {
            try {
                set.add(stringsArray[i]);
            } catch (ElementExistsException e) {
                System.out.println("Dublura gasita: " + stringsArray[i]);
            }
        }

        String ist = set.traverse();

        System.out.println(ist);

        System.out.println(set.getIndex("Bianca"));

        System.out.println(set.getData(3).toString());

    }

    @Test
    void removeTest() {
        String strings = "Mihai,Ana,Victor,Victor,Bianca,Vlad";
        String[] stringsArray = strings.split(",");

        for (int i = 0; i < stringsArray.length; i++) {
            try {
                set.add(stringsArray[i]);
            } catch (ElementExistsException e) {
                //nimic
            }
        }

        int size = set.size();
        assertEquals(5, size);

        String soll = "Ana\nBianca\nMihai\nVictor\nVlad\n";
        String ist = set.traverse();
        assertEquals(soll, ist);
        System.out.println(ist);

        set.remove(1);
        ist = set.traverse();
        soll = "Ana\nMihai\nVictor\nVlad\n";
        assertEquals(soll, ist);
        System.out.println(ist);

    }

    @Test
    void setTest() {
        String strings = "Mihai,Ana,Victor,Victor,Bianca,Vlad";
        String[] stringsArray = strings.split(",");

        for (int i = 0; i < stringsArray.length; i++) {
            try {
                set.add(stringsArray[i]);
            } catch (ElementExistsException e) {
                //nimic
            }
        }

        int size = set.size();
        assertEquals(5, size);

        String ist = set.traverse();

        System.out.println(ist);

        try {
            set.set(1, "Dumitru");
        } catch (ElementExistsException e) {
            //nimic
        }

        ist = set.traverse();

        System.out.println(ist);

    }

}