package com.example;

public class Main {
    public static void main(String[] args) {

        ParkingZone pz = new ParkingZone("Parking", 20);

        System.out.printf("Parking Zone name: " + pz.getZoneName());

        pz.parkCar("77-AA-777");
        pz.parkCar("90-BB-787");
        pz.parkCar("70-AA-999");

        pz.removeCar("55-GG-909");

        pz.showParkedCars();
    }
}