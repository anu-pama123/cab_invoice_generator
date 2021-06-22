package com.bridgelabz;

import java.util.List;

public class InvoiceGenerator extends RideRepository {
    private static final int NORMAL_RIDE_COST_PER_TIME = 1;
    private static final double NORMAL_RIDE_MINIMUM_COST_PER_KILOMETER = 10;
    private static final double NORMAL_RIDE_MINIMUM_FARE = 5;
    private static final int PREMIUM_RIDE_COST_PER_TIME = 2;
    private static final double PREMIUM_RIDE_MINIMUM_COST_PER_KILOMETER = 15;
    private static final double PREMIUM_RIDE_MINIMUM_FARE = 20;

    public double calculateFare(double distance, int time, String rideType) {
        if (rideType == "Normal") {
            double totalFare = distance * NORMAL_RIDE_MINIMUM_COST_PER_KILOMETER + time * NORMAL_RIDE_COST_PER_TIME;
            return Math.max(totalFare, NORMAL_RIDE_MINIMUM_FARE);
        }
        else {
            double totalFare = distance * PREMIUM_RIDE_MINIMUM_COST_PER_KILOMETER + time * PREMIUM_RIDE_COST_PER_TIME;
            return Math.max(totalFare, PREMIUM_RIDE_MINIMUM_FARE);
        }
    }

    public double calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time, ride.rideType);
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
                totalFare += this.calculateFare(ride.distance, ride.time, ride.rideType);
            }
        }
        return totalFare;
    }
}