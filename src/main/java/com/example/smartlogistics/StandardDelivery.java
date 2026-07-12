package com.example.smartlogistics;

public class StandardDelivery implements LogisticsService {

    @Override
    public void processDelivery(Parcel parcel) {

        parcel.setStatus("In_Progress");

        printSystemLog("Parcel is being processed. Code: " + parcel.getTrackingCode() + ", New status: " + parcel.getStatus());
    }
}
