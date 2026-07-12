package com.example.functional_interfaces.task1;

public class Main {

    public static void main(String[] args) {

        StringProcessor reversed = (str -> new StringBuilder(str).reverse().toString());

        System.out.println(reversed.process("Hello"));
    }
}
