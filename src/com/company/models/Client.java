package com.company.models;

import java.util.Comparator;

public class Client implements Comparable<Client>{

    private int id;
    private String name;
    private double credit;
    private boolean VIP;

    public Client(int id, String name, double credit, boolean VIP) {
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.VIP = VIP;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getCredit() {
        return credit;
    }
    public void setCredit(double credit) {
        this.credit = credit;
    }

    public boolean isVIP() {
        return VIP;
    }
    public void setVIP(boolean VIP) {
        this.VIP = VIP;
    }

    @Override
    public boolean equals(Object o) {
        Client client = (Client) o;
        return this.id == client.id &&
                this.name.equals(client.name) &&
                this.credit == client.credit &&
                this.VIP == client.VIP;
    }

    @Override
    public int compareTo(Client o) {
        Integer thisId = this.id;
        Integer clientId = o.id;
        return thisId.compareTo(clientId);
    }

    @Override
    public String toString() {
        String string = "";
        string += "ID: " + this.id + "\n";
        string += "Name: " + this.name + "\n";
        string += "Credit: " + this.credit + "\n";
        string += "VIP: " + this.VIP + "\n";
        return string;
    }
}
