package com.bridhgelabz;

import com.bridgelabz.InvoiceGenerator;
import com.bridgelabz.Ride;
import com.bridgelabz.RideRepository;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;

public class InvoiceGeneratorTest {

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        String rideType = "Normal";
        double fare = invoiceGenerator.calculateFare(distance, time, rideType);
        Assert.assertEquals(25, fare,0.0);
    }

    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinimumFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        String rideType = "Premium";
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time, rideType);
        Assert.assertEquals(20, fare,0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {new Ride(1,2.0, 5, "Normal"), new Ride(2,0.1, 1, "Normal")};
        double fare = invoiceGenerator.calculateFare(rides);
        Assert.assertEquals(30, fare,0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnAverageFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {new Ride(1,2.0, 5, "Premium"), new Ride(2,0.1, 1, "Noraml")};
        double fare = invoiceGenerator.calculateAverage(rides);
        Assert.assertEquals(30, fare,0.0);
    }

    @Test
    public void whenGivenIdInvoiceServiceGetsListOfRides_shouldReturnInvoice() {
        RideRepository rideRepositoryObject = new RideRepository();
        rideRepositoryObject.rides.add(new Ride(1,2.0, 5, "Normal"));
        rideRepositoryObject.rides.add(new Ride(2,2.0, 5, "Premium"));
        rideRepositoryObject.rides.add(new Ride(1,2.0, 5, "Normal"));
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Assert.assertEquals(50,invoiceGenerator.getInvoiceForId(1, rideRepositoryObject.rides));
    }
}

