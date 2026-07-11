package com.example.animalsound;

public class Main {
    public static void main(String[] args) {

        Cat cat = new Cat();
        Dog dog = new Dog();
        Cow cow = new Cow();

        cat.makeSound();
        dog.makeSound();
        cow.makeSound();
    }
}
