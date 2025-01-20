package com.example.hms.demo.Model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Room")
public class Room {
    private int roomNumber;
    private String roomType; // e.g., Single, Double, Suite
    private double pricePerNight;
    private String status; // e.g., Available, Occupied, Out of Service
    private List<String> amenities; // e.g., WiFi, TV
    private List<Occupant> occupants; // List of occupants (if any)
    private String lastCleaned;

    // Constructors
    public Room() {
    }

    public Room(int roomNumber, String roomType, double pricePerNight, String status, List<String> amenities, List<Occupant> occupants, String lastCleaned) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.status = status;
        this.amenities = amenities;
        this.occupants = occupants;
        this.lastCleaned = lastCleaned;
    }

    // Getters and Setters
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
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

    public List<Occupant> getOccupants() {
        return occupants;
    }

    public void setOccupants(List<Occupant> occupants) {
        this.occupants = occupants;
    }

    public String getLastCleaned() {
        return lastCleaned;
    }

    public void setLastCleaned(String lastCleaned) {
        this.lastCleaned = lastCleaned;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", roomType='" + roomType + '\'' +
                ", pricePerNight=" + pricePerNight +
                ", status='" + status + '\'' +
                ", amenities=" + amenities +
                ", occupants=" + occupants +
                ", lastCleaned=" + lastCleaned +
                '}';
    }
}