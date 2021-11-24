package com.company;

public class Main {

    public static void main(String[] args) {

        Car c = new Car(2020, 58000, "forward","family", 7);
        Vehicle isCar = c;
        Vehicle notCar = new Vehicle(2018, 300000);


        notCar.traveling(1000);
        isCar.setSpeed(60);
        // if car is traveling technical chek-up should be done every 1000 miles
        c.traveling(1800);

        // checking that Vehicle and Car are referring to same object
        System.out.println(c.getSpeed()+" after traveling the mileage is: " + notCar.getMileage()+" "+isCar.getMileage()+" "+ c.getMileage());

    }
}



