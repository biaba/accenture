package com.company;

import java.sql.SQLOutput;

public class Vehicle {

    private int speed;
    private int registrationYear;
    private int mileage;

    public Vehicle(int registrationYear, int mileage) {
        this.registrationYear = registrationYear;
        this.mileage = mileage;
    }

    public void traveling(int distance) {
        if(this instanceof Car) {
            if(((Car) this).getTimeToService()){
                System.out.println("REMINDER: Go to service");
            }
            System.out.println("INFO: should be checked in every 1 0000 miles");
            int start = this.mileage+1;
            int end = this.mileage+distance;
            while(start<=end){
                if(start%1000==0){
                    ((Car) this).setTimeToService(true);
                }
                start++;
            }

        }
        mileage+=distance;
    }

    public void increaseSpeed(int amount) {
        this.speed+=amount;
    }

    public void decreaseSpeed(int amount) {
        if(amount>this.speed){
            this.speed=0;
        }else{
            this.speed-=amount;
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getRegistrationYear() {
        return registrationYear;
    }

    public void setRegistrationYear(int registrationYear) {
        this.registrationYear = registrationYear;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
}
