package com.example.functionalinterfaces.task4;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        Predicate<String> hasMinLength = s -> s.length() >= 8;

        Predicate<String> hasDigit = s -> s.matches(".*\\d.*");

        Predicate<String> hasNoSpaces = s -> !s.contains(" ");

        Predicate<String> passwordValidator = hasMinLength.and(hasDigit).and(hasNoSpaces);

        String[] testPasswords = {"Pass1234", "pass", "pass 123", "password"};

        for (String p : testPasswords) {
            System.out.println("Password: \"" + p + "\" - Is valid? " + passwordValidator.test(p));
        }
    }
}
