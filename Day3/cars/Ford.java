package com.company;

public class Ford extends Car {

    private int gear;
    private String model;

    public Ford(int registrationYear, int mileage, String direction, String type, int seats, int gear, String model) {
        super(registrationYear, mileage, direction, type, seats);
        this.gear = gear;
        this.model = model;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }
}


