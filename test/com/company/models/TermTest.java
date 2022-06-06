package com.company.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TermTest {

    @Test
    public void test() {
        Term term = new Term(5, -2);
        System.out.println(term);
        String soll = "5x\u207b\u00b2";
        assertEquals(soll,term.toString());
        assertNotEquals(soll,term); //de ce nu returneaza toString-ul???

        term = new Term(1, -3);
        System.out.println(term);
        soll = "x\u207b\u00b3";
        assertEquals(soll, term.toString());

        term = new Term(0, -5);
        System.out.println(term);
        soll = "0x\u207b\u2075";
        String sollNo0 = "";
        assertEquals(soll, term.toString());
        assertEquals(sollNo0,term.toStringNo0());

    }

    @Test
    public void compareTest() {
        Term term0 = new Term(10, 3);
        System.out.println(term0);
        Term term1 = new Term(5, 5);
        System.out.println(term1);
        Term term2 = new Term(1, 2);
        System.out.println(term2);
        Term term3 = new Term(3, 2);
        System.out.println(term3);
        Term term4 = new Term(0, 10);
        System.out.println(term4);
        Term term5 = new Term(0, 2);
        System.out.println(term5);
        Term term6 = new Term(-2, 5);
        System.out.println(term6);

        assertEquals(-1, term0.compareTo(term1));
        assertEquals(1, term1.compareTo(term2));
        assertEquals(-1, term2.compareTo(term3));
        assertEquals(1, term3.compareTo(term4));
        assertEquals(0, term4.compareTo(term5));
        assertEquals(1, term5.compareTo(term6));

    }
}