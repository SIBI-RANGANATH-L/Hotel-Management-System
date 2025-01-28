package com.example.hms.demo.Model;

public class Occupant {
    private String name; // Name of the occupant
    private String checkInDate; // Check-in date
    private String checkOutDate; // Check-out date

    // Constructors
    public Occupant() {
    }

    public Occupant(String name, String checkInDate, String checkOutDate) {
        this.name = name;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    // toString Method
    @Override
    public String toString() {
        return "Occupant{" +
                "name='" + name + '\'' +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                '}';
    }
}
