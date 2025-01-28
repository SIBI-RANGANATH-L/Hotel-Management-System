package com.example.hms.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.hms.demo.Model.Occupant;
import com.example.hms.demo.Model.Room;
import com.example.hms.demo.Repository.RoomRepository;

@Service
public class RoomServices {

    @Autowired
    private RoomRepository roomRepo;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Room updateRoom(String roomNumber, Room updatedRoom) {
        Query query = new Query(Criteria.where("roomNumber").is(roomNumber));
        Update update = new Update()
                .set("roomType", updatedRoom.getRoomType())
                .set("pricePerNight", updatedRoom.getPricePerNight())
                .set("status", updatedRoom.getStatus())
                .set("amenities", updatedRoom.getAmenities())
                .set("occupants", updatedRoom.getOccupants())
                .set("lastCleaned", updatedRoom.getLastCleaned());

        mongoTemplate.findAndModify(query, update, Room.class);
        return mongoTemplate.findOne(query, Room.class);
    }

    public Room updateRoomStatusAndOccupants(int roomNumber, String status, List<Occupant> occupants) {


        Query query = new Query(Criteria.where("roomNumber").is(roomNumber));
        Update update = new Update()
                .set("status", status)
                .set("occupants", occupants);

        mongoTemplate.findAndModify(query, update, Room.class);
        return mongoTemplate.findOne(query, Room.class);
    }

    public Room findRoomByRoomNumber(String roomNumber) {
        return roomRepo.findRoomByRoomNumber(roomNumber);
    }

   

     
}