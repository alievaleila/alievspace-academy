package com.example.employee;

class Developer extends Employee {

    int projectCount;

    Developer(String name, double baseSalary, int projectCount) {
        super(name, baseSalary);
        this.projectCount = projectCount;
    }

    @Override
    double calculateSalary() {
        return baseSalary + (projectCount * 200);
    }
}