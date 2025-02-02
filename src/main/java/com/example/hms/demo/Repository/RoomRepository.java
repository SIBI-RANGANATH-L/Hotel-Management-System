package com.example.hms.demo.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.hms.demo.Model.Room;

public interface RoomRepository extends  MongoRepository<Room, String>{


    // Method to find a room by its roomNumber
    Room findRoomByRoomNumber(String roomNumber);

    List<Room> getByStatus(String string);

    // Custom query to find all rooms occupied by a specific user
    @Query("{ 'occupants': ?0 }")
    List<Room> findAllByOccupantsContaining(String userId);

    


    
    
}
