package com.company.controllers;

import com.company.implementate.Entry;
import com.company.implementate.HashTable;
import com.company.implementate.Lista;
import com.company.models.Client;
import com.company.models.Masina;

import java.io.File;
import java.util.Scanner;

public class HashtableController {

    private HashTable<Client, Lista<Masina>> hashTable;
    private String pathRoot;
    private Lista<Client> listaClienti;

    //constructor
    public HashtableController(String pathRoot, int size) {
        this.pathRoot = pathRoot;
        hashTable = new HashTable(size);
        listaClienti = loadClients();
        load();
    }

    //read
    public void load() {
//        Lista<Client> listaClienti = loadClients();
        Lista<Masina> listaMasini = loadCars();

        int clientsSize = listaClienti.size();
        int carsSize = listaMasini.size();

        for (int i = 0; i < clientsSize; i++) {
            Client client = listaClienti.getData(i);
            Lista<Masina> masiniClient = new Lista<>();
            for (int j = 0; j < carsSize; j++) {
                Masina masina = listaMasini.getData(j);
                if (masina.getOwnerId() == client.getId()) {
                    masiniClient.addFirst(masina);
                }
            }
            hashTable.put(client, masiniClient);
        }
    }
    private Lista<Client> loadClients() {
        Lista<Client> listaClienti = new Lista<>();

        try {
            File clients = new File(pathRoot + "/clients");
            Scanner clientScanner = new Scanner(clients);
            while (clientScanner.hasNext()) {
                String line = clientScanner.nextLine();
                if (line != "") {
                    String[] input = line.split("/");

                    int id = Integer.parseInt(input[0]);
                    String name = input[1];
                    double credit = Double.parseDouble(input[2]);
                    boolean vip = Boolean.parseBoolean(input[3]);

                    listaClienti.addFirst(new Client(id, name, credit, vip));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaClienti;
    }
    private Lista<Masina> loadCars() {
        Lista<Masina> listaMasini = new Lista<>();

        try {
            File cars = new File(pathRoot + "/cars");
            Scanner carsScanner = new Scanner(cars);
            while (carsScanner.hasNext()) {
                String line = carsScanner.nextLine();
                if (line != "") {
                    String[] input = line.split("/");

                    int id = Integer.parseInt(input[0]);
                    String name = input[1];
                    double price = Double.parseDouble(input[2]);
                    boolean sold = Boolean.parseBoolean(input[3]);
                    int ownerId = Integer.parseInt(input[4]);

                    listaMasini.addFirst(new Masina(id, name, price, sold, ownerId));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaMasini;
    }

    public Lista<Masina> getCars(Client client) {
        return hashTable.get(client);
    }

    public Client getClient(int index) {
        return listaClienti.getData(index);
    }

    //

}
