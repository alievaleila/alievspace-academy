package com.example.librarymanagementsystem;

interface Borrowable {

    void borrowItem(String user);
    void returnItem();
}