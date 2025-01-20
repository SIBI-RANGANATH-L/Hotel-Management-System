package com.example.hms.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.hms.demo.Model.Room;

public interface RoomRepository extends  MongoRepository<Room, String>{
    
}
