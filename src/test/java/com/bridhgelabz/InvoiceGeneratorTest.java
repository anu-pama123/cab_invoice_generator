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
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25, fare,0.0);
    }

    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinimumFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, fare,0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {new Ride(1,2.0, 5), new Ride(2,0.1, 1)};
        double fare = invoiceGenerator.calculateFare(rides);
        Assert.assertEquals(30, fare,0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnAverageFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {new Ride(1,2.0, 5), new Ride(2,0.1, 1)};
        double fare = invoiceGenerator.calculateAverage(rides);
        Assert.assertEquals(15, fare,0.0);
    }

    @Test
    public void whenGivenIdInvoiceServiceGetsListOfRides_shouldReturnInvoice() {
        RideRepository rideRepositoryObject = new RideRepository();
        rideRepositoryObject.rides.add(new Ride(1,2.0, 5));
        rideRepositoryObject.rides.add(new Ride(2,2.0, 5));
        rideRepositoryObject.rides.add(new Ride(1,2.0, 5));
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Assert.assertEquals(50,invoiceGenerator.getInvoiceForId(1, rideRepositoryObject.rides));
    }
}

