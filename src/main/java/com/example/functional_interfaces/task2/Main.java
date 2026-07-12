package com.example.functional_interfaces.task2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        List<Integer> grades = Arrays.asList(98, 25, 34, 84);

        Predicate<Integer> isPassed = grade -> grade >= 51;

        System.out.println("Passed grades: ");

        grades.stream().filter(isPassed).forEach(System.out::println);
    }
}
