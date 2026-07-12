package com.example.electronicsstore;

public class Laptop extends Product {

    private final int ram;

    public Laptop(String name, double price, int ram) {
        super(name, price);
        this.ram = ram;
    }

    public int getRam() {
        return ram;
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: " + getName() + ", Price: $" + getPrice() + ", Ram: " + getRam() + "GB");
    }
}
