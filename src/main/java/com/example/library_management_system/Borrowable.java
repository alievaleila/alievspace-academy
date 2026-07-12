package com.example.library_management_system;

interface Borrowable {

    void borrowItem(String user);
    void returnItem();
}