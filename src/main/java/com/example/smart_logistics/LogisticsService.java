package com.example.smart_logistics;

public interface LogisticsService {

    void processDelivery(Parcel parcel);

    default void printSystemLog(String message) {
        System.out.println("[LOG - INFO]: " + message);
    }
}
