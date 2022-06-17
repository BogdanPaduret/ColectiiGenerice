package com.company.implementate;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class Probleme {


    @Test
    public void pb1() {
        //verificare daca textul este balantat
        String text = "]{constantin [merg]e [(la[] mare) (distanta) de (casa)]}";

        Stiva<Character> stiva = new Stiva<>();

        for (int i = 0; i < text.length(); i++) {
            Character c = text.charAt(i);


            switch (c) {
                case '(':
                case '[':
                case '{':
                    stiva.push(c);
                    break;
            }


            if (stiva.isEmpty()) {
                switch (c) {
                    case ')':
                    case ']':
                    case '}':
                        stiva.push(c);
                        break;
                }
            } else {
                switch (c) {
                    case ')':
                        if (stiva.peek() == '(') {
                            stiva.pop();
                        }
                        break;
                    case ']':
                        if (stiva.peek() == '[') {

                            stiva.pop();
                        }
                        break;
                    case '}':
                        if (stiva.peek() == '{') {
                            stiva.pop();
                        }
                        break;
                }
            }


        }

        if (stiva.isEmpty()) {
            System.out.println("Textul este balantat");
        } else {
            System.out.println("Textul NU este balantat!");
        }
    }

    @Test
    public void pb2() {
        //inversare text folosind stiva
        String text = "Ana are mere multe.\nBogdan are banane putine.";

        Stiva<Character> stiva = new Stiva<>();

        for (int i = 0; i < text.length(); i++) {
            stiva.push(text.charAt(i));
        }

        String reverse = "";

        while (!stiva.isEmpty()) {
            reverse += stiva.peek();
            stiva.pop();
        }

        System.out.println(reverse);
    }

    @Test
    public void pb3() {
        //sortare lista folosind stiva

    }

    @Test
    public void coadaPb1Vechi() {
        //de sortat un vector tip string folosind coada
        Coada<Character> buffer = new Coada<>();
        Coada<Character> sorted = new Coada<>();

        String input = "acb";

        while (input.length() > 0) {
            Character previous = input.charAt(0);
            buffer.push(previous);
            int count = 0;
            for (int i = 1; i < input.length(); i++) {
                Character c = input.charAt(i);
                if (c.compareTo(previous) < 0) {
                    popAll(buffer);
                    c = 0;
                }
                buffer.push(c);
                previous = c;
                c++;
            }
            transfer(buffer, sorted);
            input = input.substring(0, input.length() - count - 1);
        }
        System.out.println(show(sorted));
    }

    public void popAll(Coada c) {
        while (!c.isEmpty()) {
            c.pop();
        }
    }

    public void transfer(Coada source, Coada receiver) {
        while (!source.isEmpty()) {
            receiver.push(source.peek());
            source.pop();
        }
    }

    public String show(Coada coada) {
        String string = "";
        while (!coada.isEmpty()) {
            string += coada.peek();
            coada.pop();
        }
        return string;
    }

    @Test
    public void coadaPb1() {
        //de sortat un vector tip string folosind coada
        Coada<Character> coada = new Coada<>();

        String input = "pakcozpsojfa";

        while (input.length() > 0) {
            int i = smallest(input);
            Character c = input.charAt(i);
            coada.push(c);

            if (i == 0) {
                input = input.substring(i + 1);
            } else {
                input = input.substring(0, i) + input.substring(i + 1);
            }
        }

        String toPrint = "";
        while (!coada.isEmpty()) {
            toPrint += coada.peek();
            coada.pop();
        }
        System.out.println(toPrint);

    }

    public int smallest(String string) {
        int index = 0;
        Character c = string.charAt(index);
        for (int i = 0; i < string.length(); i++) {
            Character check = string.charAt(i);
            if (check.compareTo(c) < 0) {
                index = i;
                c = string.charAt(index);
            }
        }
        return index;
    }

    @Test
    public void p13_1() {
        Lista<Integer> lista = new Lista();
        lista.addLast(1);
        lista.addLast(2);
        lista.addLast(3);
        lista.addLast(4);
        lista.addLast(5);
        lista.addLast(6);
        lista.addLast(7);

        System.out.println(showList(lista));
        lista = downsize(lista);
        System.out.println(showList(lista));
    }
    public Lista downsize(Lista lista) {
        Coada buffer = new Coada();
        int size = lista.size();
        for (int i = 0; i < size; i=i+2) {
            buffer.push(lista.getData(i));
        }
        Lista downsizedList = new Lista();
        while (!buffer.isEmpty()) {
            downsizedList.addLast(buffer.peek());
            buffer.pop();
        }
        return downsizedList;
    }
    public String showList(Lista lista) {
        String string = "";
        int size = lista.size();
        for (int i = 0; i < size; i++) {
            string += lista.getData(i).toString();
        }
        return string;
    }

    @Test
    public void p13_6() {
        Lista<Integer> lista = new Lista();
        lista.addLast(0);
        lista.addLast(1);
        lista.addLast(2);
        lista.addLast(3);
        lista.addLast(4);
        lista.addLast(5);
        System.out.println(showList(lista));
        lista = reverse(lista);
        System.out.println(showList(lista));
    }
    public Lista reverse(Lista<Integer> lista) {
        Stiva<Integer> buffer = new Stiva();
        int size = lista.size();
        for (int i = 0; i < size; i++) {
            buffer.push(lista.getData(i));
        }

        Lista reversedList = new Lista();
        while (!buffer.isEmpty()) {
            reversedList.addLast(buffer.peek());
            buffer.pop();
        }
        return reversedList;
    }

    @Test
    public void p13_11() {
        //vezi clasa CircularList
    }

    @Test
    public void p13_12() {
        //asa este deja lista implementata daca am inteles bine (nu avem previous)
    }

    @Test
    public void p13_13() {
        //as vrea sa fac la curs, nu am inteles bine ce trebuie sa faca dummy node
    }

    @Test
    public void p13_14() {
        //polinomul - a se verifica clasa Polynomial
    }


}
