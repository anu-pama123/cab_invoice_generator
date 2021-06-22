package com.bridgelabz;

public class Ride {
    public final int id;
    public final double distance;
    public final int time;
    public String rideType;

    public Ride(int id, double distance, int time, String rideType) {
        this.distance = distance;
        this.time = time;
        this.id = id;
        this.rideType = rideType;
    }
}
