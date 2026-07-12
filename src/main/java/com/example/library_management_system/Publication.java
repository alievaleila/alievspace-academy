package com.example.library_management_system;

abstract class Publication {

    private String title;
    private int year;
    private String borrowedBy;

    public Publication(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() { return title; }

    public String getBorrowedBy() { return borrowedBy; }

    protected void setBorrowedBy(String user) { this.borrowedBy = user; }

    abstract void displayInfo();
}