package com;

import java.util.List;

record FlightDetails1(
        int flightId,
        String flightNumber,
        String source,
        String destination,
        double price) { }


record Passenger(
        int passengerId,
        String name,
        String passportNumber) { }


record Booking(
        int bookingId,
        FlightDetails1 flight,
        Passenger passenger,
        int numberOfSeats) { }

public class RecordDemo {
    public static void main(String[] args) {

        
        FlightDetails1 f1 = new FlightDetails1(1, "AI101", "Mumbai", "Delhi", 4500);
        FlightDetails1 f2 = new FlightDetails1(2, "AI102", "Pune", "Bangalore", 5500);
        FlightDetails1 f3 = new FlightDetails1(3, "AI103", "Chennai", "Hyderabad", 6200);
        FlightDetails1 f4 = new FlightDetails1(4, "AI104", "Kolkata", "Goa", 4800);
        FlightDetails1 f5 = new FlightDetails1(5, "AI105", "Delhi", "Dubai", 15000);

        List<FlightDetails1> flights = List.of(f1, f2, f3, f4, f5);

        
        for (FlightDetails1 flight : flights) {
            System.out.println("Flight Number : " + flight.flightNumber());
            System.out.println("Source        : " + flight.source());
            System.out.println("Destination   : " + flight.destination());
            System.out.println("Price         : " + flight.price());
            System.out.println("Complete Info : " + flight);
            System.out.println();
        }

       
        flights.stream()
                .filter(flight -> flight.price() > 5000)
                .forEach(System.out::println);

        
        Passenger p1 = new Passenger(101, "Sana", "IND12345");
        Passenger p2 = new Passenger(102, "alex", "IND67890");

        
        Booking b1 = new Booking(1001, f2, p1, 2);
        Booking b2 = new Booking(1002, f5, p2, 1);

        
        
        System.out.println(b1);
        System.out.println(b2);
    }
}