package com;
import java.util.*;

public class FlightBooking {

    public static void main(String[] args) {

        
        var flightNumber = "QP908";
        var flightPrice = 5500.50;
        var passengerName = "Sarah";
        var numberOfSeats = 2;
        var bookingStatus = true;

        
        var flights = List.of(
                "QP908",
                "6E501",
                "U9067",
                "SG789"
        );

        //  using var
        var passengerNames = new ArrayList<String>();
        passengerNames.add("Sarah");
        passengerNames.add("Rahul");
        passengerNames.add("Anita");

       
        var flightMap = new HashMap<Integer, String>();
        flightMap.put(101, "QP908");
        flightMap.put(102, "6E501");
        flightMap.put(103, "U9067");

       
        var totalTicketPrice = flightPrice * numberOfSeats;
        var discountAmount = totalTicketPrice * 0.10; 
        var finalBookingAmount = totalTicketPrice - discountAmount;

       
       
        System.out.println("Passenger Name : " + passengerName);
        System.out.println("Flight Number  : " + flightNumber);
        System.out.println("Flight Price   : " + flightPrice);
        System.out.println("Seats Booked   : " + numberOfSeats);
        System.out.println("Booking Status : " + bookingStatus);

       
        System.out.println("Passenger List: " + passengerNames);
        System.out.println("Flight Map: " + flightMap);

        
        System.out.println("Total Ticket Price : " + totalTicketPrice);
        System.out.println("Discount Amount    : " + discountAmount);
        System.out.println("Final Amount       : " + finalBookingAmount);
    }
}
