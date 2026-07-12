package com.example.library_management_system;

class Book extends Publication implements Borrowable {

    private String author;

    public Book(String title, int year, String author) { super(title, year); this.author = author; }

    @Override
    void displayInfo() { System.out.println("Book: " + getTitle() + ", Author: " + author); }

    public void borrowItem(String user) { setBorrowedBy(user); }
    public void returnItem() { setBorrowedBy(null); }
}