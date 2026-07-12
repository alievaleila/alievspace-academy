package com.example.librarymanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {
    public static void main(String[] args) {

        List<Publication> library = new ArrayList<>();

        library.add(new Book("Clean Code", 2008, "Robert Martin"));
        library.add(new Magazine("Java World", 2026, 12));

        String searchTerm = "clean code";
        library.stream()
                .filter(p -> p.getTitle().equalsIgnoreCase(searchTerm.trim()))
                .forEach(p -> System.out.println("Found: " + p.getTitle()));
    }
}