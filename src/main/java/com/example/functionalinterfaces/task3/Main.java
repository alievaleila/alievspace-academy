package com.example.functionalinterfaces.task3;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        Product apple = new Product("apple", 100.0);

        Consumer<Product> applyDiscount = p -> {
            double dis = p.getPrice() * 0.9;
            p.setPrice(dis);
            System.out.println(p.getPrice());
        };

        applyDiscount.accept(apple);
    }
}
