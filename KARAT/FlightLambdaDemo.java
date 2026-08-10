package com;

import java.util.ArrayList;
import java.util.List;


class FlightDetails {

    private int flightId;
    private String flightNumber;
    private String source;
    private String destination;
    private double price;

    public FlightDetails(int flightId, String flightNumber,
                  String source, String destination,
                  double price) {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.price = price;
    }

    public int getFlightId() {
        return flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Flight ID : " + flightId +
                "\nFlight Number : " + flightNumber +
                "\nSource : " + source +
                "\nDestination : " + destination +
                "\nPrice : ₹" + price + "\n";
    }
}


@FunctionalInterface
interface FlightOperation {
    void execute(FlightDetails flight);
}


public class FlightLambdaDemo {

    public static void main(String[] args) {

        List<FlightDetails> flights = new ArrayList<>();

        flights.add(new FlightDetails(101, "AI101", "Hyderabad", "Delhi", 4500));
        flights.add(new FlightDetails(102, "6E202", "Mumbai", "Bangalore", 6500));
        flights.add(new FlightDetails(103, "SG303", "Hyderabad", "Chennai", 5500));
        flights.add(new FlightDetails(104, "UK404", "Delhi", "Pune", 7200));
        flights.add(new FlightDetails(105, "AI505", "Kolkata", "Mumbai", 4800));

        // 1. Display all flight details
       

        FlightOperation displayAll = flight ->
                System.out.println(flight);

        flights.forEach(displayAll::execute);

        // 2. Display flights whose price is greater than 5000
       

        FlightOperation expensiveFlights = flight -> {
            if (flight.getPrice() > 5000) {
                System.out.println("FLIGHTS PRICE > 5000 :" + flight);
            }
        };

        flights.forEach(expensiveFlights::execute);

        // 3. Display flights from Hyderabad
        

        FlightOperation sourceFlights = flight -> {
            if (flight.getSource().equalsIgnoreCase("Hyderabad")) {
                System.out.println("FLIGHTS FROM HYDERABAD : " + flight);
            }
        };

        flights.forEach(sourceFlights::execute);

        // 4. Display flight number and destination
        System.out.println("\n===== FLIGHT NUMBER AND DESTINATION =====");

        FlightOperation flightDetails = flight ->
                System.out.println(
                        "Flight Number : "
                                + flight.getFlightNumber()
                                + " | Destination : "
                                + flight.getDestination());

        flights.forEach(flightDetails::execute);

        // 5. Calculate 10% discount on flight price
       

        FlightOperation discountOperation = flight -> {

            double discountedPrice =
                    flight.getPrice() - (flight.getPrice() * 0.10);

            System.out.println(
                    "Flight Number : " + flight.getFlightNumber()
                            + " | Original Price : ₹" + flight.getPrice()
                            + " | Discounted Price : ₹" + discountedPrice);
        };

        flights.forEach(discountOperation::execute);
    }
}