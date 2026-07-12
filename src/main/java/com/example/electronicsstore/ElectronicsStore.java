package com.example.electronicsstore;

public class ElectronicsStore {
    public static void main(String[] args) {

        Laptop myLaptop = new Laptop("MacBook Pro", 2000.0, 16);

        myLaptop.displayInfo();

        myLaptop.discount(100.0);
        myLaptop.discount(10);

        myLaptop.displayInfo();
    }
}
