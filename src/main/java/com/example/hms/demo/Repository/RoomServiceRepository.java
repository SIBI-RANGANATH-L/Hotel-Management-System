package com.example.hms.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.hms.demo.Model.RoomService;

public interface   RoomServiceRepository extends MongoRepository<RoomService, String> {
    
}
