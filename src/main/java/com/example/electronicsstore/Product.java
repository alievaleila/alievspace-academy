package com.example.electronicsstore;

public class Product {

    private String name;
    private double price;

    public Product(String name, double price) {
        this.price = price;
        this.name = name;
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
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Error: Price cannot be negative.");
        }
    }

    public void displayInfo() {
        System.out.println("Name: " + getName() + ", Price: $" + getPrice());
    }

    public void discount(double amount) {
        setPrice(getPrice() - amount);
    }

    public void discount(int percentage) {
        setPrice(this.price - (this.price * percentage / 100));
    }
}
