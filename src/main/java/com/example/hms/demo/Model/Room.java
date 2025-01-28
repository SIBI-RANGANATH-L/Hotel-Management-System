package com.example.hms.demo.Model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "demoRoom")
public class Room {

    @Id
    @Field("_id") // Maps the MongoDB _id field to roomNumber
    private String roomNumber;
    private String roomType;
    private double pricePerNight;
    private String status;
    private List<String> amenities;
    private List<String> occupants;
    private String lastCleaned; // Change lastCleaned to Date

    // Constructors, Getters, and Setters

    public Room(String roomNumber, String roomType, double pricePerNight, String status, List<String> amenities, List<String> occupants, String lastCleaned) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.status = status;
        this.amenities = amenities;
        this.occupants = occupants;
        this.lastCleaned = lastCleaned;
    }

    // Getters and Setters
    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }

    public List<String> getOccupants() {
        return occupants;
    }

    public void setOccupants(List<String> occupants) {
        this.occupants = occupants;
    }

    public String getLastCleaned() {
        return lastCleaned;
    }

    public void setLastCleaned(String lastCleaned) {
        this.lastCleaned = lastCleaned;
    }
}