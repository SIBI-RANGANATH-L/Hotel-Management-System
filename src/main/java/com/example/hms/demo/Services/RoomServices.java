package com.example.hms.demo.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

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

    public Room updateRoomStatusAndOccupants(String roomNumber, String status, List<?> occupants) {


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

    public List<String> getRoomListOfUser(String userId) {

        List<Room> lst= roomRepo.findAllByOccupantsContaining(userId);
        List<String> roomList = new ArrayList<>();

        for(int i=0;i<lst.size();i++){
            roomList.add(lst.get(i).getRoomNumber());
        }
        return roomList;    
    }

   

     
}