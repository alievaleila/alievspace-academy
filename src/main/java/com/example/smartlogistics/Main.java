package com.example.smartlogistics;

public class Main {
    public static void main(String[] args) {

        LogisticsManager manager = new LogisticsManager();

        Courier c1 = new Courier(1, "Elnur (Active Moto)", "Moto");
        Courier c2 = new Courier(2, "Anar (Active Car)", "Car");
        Courier c3 = new Courier(3, "Vüsal (Passive)", "Car");
        c3.setActive(false);

        manager.addCourier(c1);
        manager.addCourier(c2);
        manager.addCourier(c3);

        System.out.println("=== Scenario 1: Normal Parcel Creation and Code Generation ===");

        Parcel p1 = new Parcel(12.5, "Baku");

        String code1 = manager.generateCode(p1.getDestinationCity(), p1.getWeight());

        p1 = new Parcel(code1, p1.getWeight(), p1.getDestinationCity(), p1.getStatus());

        Parcel p2 = new Parcel(15.0, "Ganja");
        String code2 = manager.generateCode(p2.getDestinationCity(), p2.getWeight());
        p2 = new Parcel(code2, p2.getWeight(), p2.getDestinationCity(), p2.getStatus());

        Parcel p3 = new Parcel(4.2, "Quba");
        String code3 = manager.generateCode(p3.getDestinationCity(), p3.getWeight());
        p3 = new Parcel(code3, p3.getWeight(), p3.getDestinationCity(), p3.getStatus());

        System.out.println("Parcel 1: " + p1.getTrackingCode() + " | City: " + p1.getDestinationCity());
        System.out.println("Parcel 2: " + p2.getTrackingCode() + " | City: " + p2.getDestinationCity());
        System.out.println("Parcel 3: " + p3.getTrackingCode() + " | City: " + p3.getDestinationCity());


        System.out.println("\n=== Scenario 2: Delivery Cost Calculation ===");

        System.out.println("Standard cost for " + p1.getTrackingCode() + ": " + manager.calculateCost(p1) + " AZN");

        System.out.println("Standard cost for " + p2.getTrackingCode() + ": " + manager.calculateCost(p2) + " AZN");

        System.out.println(p1.getTrackingCode() + " (With Car courier): " + manager.calculateCost(p1, "Car") + " AZN");
        System.out.println(p1.getTrackingCode() + " (With Moto courier): " + manager.calculateCost(p1, "Moto") + " AZN");


        System.out.println("\n=== Scenario 3: Assigning Parcels to Couriers ===");
        manager.assignParcelToBestCourier(p1);
        manager.assignParcelToBestCourier(p2);


        System.out.println("\n=== Scenario 4: Error Handling (Try-Catch with Negative Weight) ===");
        Parcel faultyParcel = new Parcel(-5.0, "Lankaran");
        String faultyCode = manager.generateCode(faultyParcel.getDestinationCity(), faultyParcel.getWeight());
        faultyParcel = new Parcel(faultyCode, faultyParcel.getWeight(), faultyParcel.getDestinationCity(), faultyParcel.getStatus());

        try {
            System.out.println("Attempting to assign the faulty parcel to a courier...");
            manager.assignParcelToBestCourier(faultyParcel);
        } catch (IllegalArgumentException e) {
            System.err.println("Caught Exception: " + e.getMessage());
        } finally {
            System.out.println("Parcel processing session closed.");
        }
    }
}