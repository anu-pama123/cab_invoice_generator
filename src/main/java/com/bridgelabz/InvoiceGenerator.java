package com.bridgelabz;

public class InvoiceGenerator {
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_COST_PER_KILOMETER = 10;

    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        if (totalFare < 5)
            totalFare = 5;
        return totalFare;
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
}