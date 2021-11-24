package com.company;

public class Car extends Vehicle {

    private String direction;
    private int numberOfSeats;
    private String type;
    private boolean timeToService;

    public Car(int registrationYear, int mileage, String direction, String type, int seats) {
        super(registrationYear, mileage);
        this.direction = direction;
        this.type = type;
        this.numberOfSeats = seats;
    }


    public void attendingService() {
        this.timeToService = false;
        System.out.println("GOOD: The car has been checked. Happy next 1000 miles");
    }

    public boolean getTimeToService() {
        return timeToService;
    }

    public void setTimeToService(boolean timeToService) {
        System.out.println("INFO: You have to go to service every 1000 miles. It's time.");
        this.timeToService = timeToService;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String newDirection) {
        this.direction = newDirection;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}


