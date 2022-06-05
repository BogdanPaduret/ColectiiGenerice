package com.company.models;

public class Masina implements Comparable<Masina> {

    private int id;
    private String name;
    private double price;
    private boolean sold;

    public Masina(int id, String name, double price, boolean sold) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sold = sold;
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

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSold() {
        return sold;
    }
    public void setSold(boolean sold) {
        this.sold = sold;
    }

    @Override
    public boolean equals(Object o) {
        Masina masina = (Masina) o;
        return this.id == masina.id &&
                this.name.equals(masina.id) &&
                this.price == masina.price &&
                this.sold == masina.sold;
    }

    @Override
    public String toString() {
        String string = "";
        string += "ID: " + this.id + "\n";
        string += "Name: " + this.name + "\n";
        string += "Price: " + this.price + "\n";
        string += "Sold: " + this.sold + "\n";
        return string;
    }

    @Override
    public int compareTo(Masina o) {
        Integer thisId = this.id;
        Integer masinaId = o.id;
        return thisId.compareTo(masinaId);
    }
}
