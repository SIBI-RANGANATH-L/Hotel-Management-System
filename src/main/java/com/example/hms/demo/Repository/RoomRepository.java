package com.example.hms.demo.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.hms.demo.Model.Room;

public interface RoomRepository extends  MongoRepository<Room, String>{


    // Method to find a room by its roomNumber
    Room findRoomByRoomNumber(String roomNumber);

    List<Room> getByStatus(String string);

    


    
    
}
