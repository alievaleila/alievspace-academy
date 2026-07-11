package com.example.employee;

abstract class Employee {
    String name;
    double baseSalary;

    Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    abstract double calculateSalary();

    void displayInfo() {
        System.out.println("Employee: " + name + ", Calculated salary: " + calculateSalary());
    }
}