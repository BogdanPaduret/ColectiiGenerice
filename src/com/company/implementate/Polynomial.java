package com.company.implementate;

import com.company.models.Term;

public class Polynomial {

    Lista<Term> lista = new Lista<>();

    //create
    public void add(Term term) {
        lista.addFirst(term);
    }
    public void add(int coefficient, int power) {
        lista.addFirst(new Term(coefficient,power));
    }

    public void copy(Polynomial polynomial) {
        this.clear();
        Node<Term> loop = polynomial.getFirstNode();
        while (loop != null) {
            this.lista.addLast(loop.getData());
            loop = loop.getNext();
        }
    }

    //read
    public int size() {
        return lista.size(); //prima bucla
    }
    public Node<Term> getFirstNode() {
        return lista.getFirst();
    }
    public String show() {
        String string = "";
        Node<Term> loop = getFirstNode();
        string += loop.getData().toString();
        loop = loop.getNext();
        while (loop != null) {
            if (loop.getData().getCoefficient() >= 0) {
                string += "+";
            }
            string += loop.getData().toString();
            loop = loop.getNext();
        }
        return string;
    }
    public void print() {
        System.out.println(this.show());
    }

    public String compareContent() {
        String string = "";
        Node<Term> loop = getFirstNode();
        while (loop != null) {
            string += loop.toString();
            loop = loop.getNext();
        }
        return string;
    }

    //update
    public static Polynomial multiply(Polynomial p0, Polynomial p) {

        Polynomial p1 = new Polynomial();
        p1.copy(p);

        p.clear();

        int outerSize = p0.size();
        int innerSize = p1.size();

        Node<Term> outerLoop = p0.getFirstNode();
        while (outerLoop != null) {
            Node<Term> innerLoop = p1.getFirstNode();
            while (innerLoop != null) {
                p.add(innerLoop.getData().multiply(outerLoop.getData()));
                innerLoop=innerLoop.getNext();
            }
            outerLoop=outerLoop.getNext();
        }

        return p;
    }
    public void multiply(Polynomial polynomial) {
        multiply(polynomial, this);
    }
    public static Polynomial termMultiply(Polynomial polynomial, Term term) {
        int size = polynomial.size();
        Node<Term> loop = polynomial.getFirstNode();
        while (loop != null) {
            loop.setData(loop.getData().multiply(term));
            loop = loop.getNext();
        }
        return polynomial;
    }
    public void termMultiply(Term term) {
        termMultiply(this, term);
    }
    public void sort() {
        lista.sortDescending();
    }

    //delete
    public void remove(int index) {
        lista.remove(index);
    }
    public void clear() {
        lista.clear();
    }


}
