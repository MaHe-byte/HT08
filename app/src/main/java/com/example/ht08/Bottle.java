package com.example.ht08;

public class Bottle {
    private String name;
    private String manufacturer;
    private double total_energy;
    private double size;
    private double price;

    public Bottle(){
        name = "Pepsi Max";
        manufacturer = "Pepsi";
        total_energy = 0.3;
        size = 0.5;
        price = 1.8;

    }
    public Bottle(String name2, String manuf, double totE, double siz, double prc){
        name = name2;
        manufacturer = manuf;
        total_energy = totE;
        size = siz;
        price = prc;
    }

    public String getName(){
        return name;
    }
    public String getManufacturer(){
        return manufacturer;
    }
    public double getEnergy(){
        return total_energy;
    }
    public double getSize(){
        return size;
    }
    public double getPrice(){
        return price;
    }
}