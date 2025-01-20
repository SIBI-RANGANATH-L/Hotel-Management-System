package com.example.hms.demo.Model;



import java.util.Date;

public class Occupant {
    private String name; // Name of the occupant
    private Date checkInDate; // Check-in date
    private Date checkOutDate; // Check-out date

    // Constructors
    public Occupant() {
    }

    public Occupant(String name, Date checkInDate, Date checkOutDate) {
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

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
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
