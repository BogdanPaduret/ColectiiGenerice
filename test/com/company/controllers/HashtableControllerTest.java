package com.company.controllers;

import com.company.implementate.Lista;
import com.company.models.Masina;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashtableControllerTest {

    @Test
    public void loadTest() {
        String path = "test/com/company/resources";
        HashtableController hashtableController = new HashtableController(path, 2);

        int index = 1;

        Lista<Masina> listaMasini = hashtableController.getCars(hashtableController.getClient(index));

        System.out.println(show(listaMasini));

    }

    public String show(Lista<Masina> listaMasini) {
        String string = "";

        int size = listaMasini.size();
        for (int i = 0; i < size; i++) {
            string += listaMasini.getData(i).toString() + "\n";
        }

        return string;
    }

}