package com.company.implementate;

import com.company.models.Term;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {

    @Test
    public void sizeTest() {
        Polynomial p = new Polynomial();
        p.add(new Term(2, 5));
        p.add(new Term(3, 3));
        p.add(new Term(1, 7));

        int size = p.size();

        assertEquals(3, size);
    }

    @Test
    public void showTest() {
        Polynomial p = new Polynomial();
        p.add(new Term(2, 7));
        p.add(new Term(-3, 3));
        p.add(new Term(1, 5));

        String soll = "x\u2075-3x\u00b3+2x\u2077";
        String ist = p.show();

        System.out.println(soll);
        System.out.println(ist);

        assertEquals(soll, ist);
    }

    @Test
    public void sortSelfTest() {
        Polynomial p = new Polynomial();
        p.add(new Term(2, 7));
        p.add(new Term(-3, 3));
        p.add(new Term(1, 5));

        p.sort();

        String soll = "2x\u2077+x\u2075-3x\u00b3";
        String ist = p.show();

        System.out.println(soll);
        System.out.println(ist);

        assertEquals(soll, ist);
    }

    @Test
    public void termMultiplyTest() {
        Polynomial p = new Polynomial();
        p.add(new Term(2, 7));
        p.add(new Term(-3, 3));
        p.add(new Term(1, 5));

        p.print();

        Term term = new Term(2, 2);

        p.termMultiply(term);

        String soll = "2x\u2077-6x\u2075+4x\u2079";
        String ist = p.show();

        System.out.println(soll);
        System.out.println(ist);

        assertEquals(soll,ist);

    }

    @Test
    public void termMultiply2Test() {
        Polynomial polynomial = new Polynomial();
        polynomial.add(1, 1);
        polynomial.add(3, 1);

        Term term = new Term(2, 1);

        polynomial.termMultiply(term);

        String soll = "6x²+2x²";
        String ist = polynomial.show();

        assertEquals(soll, ist);

    }

    @Test
    public void removeTest() {
        Polynomial p = new Polynomial();
        p.add(new Term(2, 7));
        p.add(new Term(-3, 3));
        p.add(new Term(1, 5));

        p.print();
        p.remove(1);

        p.print();
    }

    @Test
    public void copyTest() {
        Polynomial p0 = new Polynomial();
        p0.add(2, 7);
        p0.add(-3, 3);
        p0.add(5, 10);

        Polynomial p1 = new Polynomial();
        p1.copy(p0);

        System.out.println(p0.toString());

        assertEquals(p0.toString(), p1.toString());
    }

    @Test
    public void multiplyTest() {
        Polynomial p0 = new Polynomial();
        p0.add(2, 7);
        p0.add(-3, 3);

        Polynomial p1 = new Polynomial();
        p1.add(1, 5);
        p1.add(2, 2);

        System.out.println("p0:");
        p0.print();
        System.out.println("p1:");
        p1.print();

        p0.multiply(p1);

        p0.print();

    }

}