package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;

public class InvoiceGenerator extends RideRepository {
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_COST_PER_KILOMETER = 10;
    private static final double MINIMUM_FARE = 5;

    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    public double calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }

    public double calculateAverage(Ride[] rides) {
        double average = calculateFare(rides) / rides.length;
        return average;
    }

    public int getInvoiceForId(int id, List<Ride> rides){
        int totalFare = 0;
        for(Ride ride : rides) {
            if(ride.id == id){
                totalFare += this.calculateFare(ride.distance, ride.time);
            }
        }
        return totalFare;
    }
}