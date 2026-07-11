package com.example.employee;

public class Main {
    public static void main(String[] args) {

        Employee manager = new Manager("Əli", 2000);
        Employee developer = new Developer("Vəli", 1500, 3);

        manager.displayInfo();
        developer.displayInfo();
    }
}