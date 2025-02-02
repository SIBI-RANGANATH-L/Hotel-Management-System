package com.example.hms.demo.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hms.demo.Model.Room;
import com.example.hms.demo.Model.User;
import com.example.hms.demo.Repository.RoomRepository;
import com.example.hms.demo.Repository.UserRepository;
import com.example.hms.demo.Services.RoomServices;
import com.example.hms.demo.Services.UserServices;


@RestController
public class RoomServiceController {
    
    @Autowired
    private UserServices userServices;

    @Autowired
    private  UserRepository userRepo;

    @Autowired
    private RoomRepository roomRepo;

    @Autowired
    private RoomServices roomService;


    @PostMapping("/bookRoom/{userId}")
    public ResponseEntity<?> bookRoom(@PathVariable String userId, @RequestParam String roomNo, @RequestParam String checkIn,@RequestParam String checkOut) {

        Optional<Room> optionalRoom = roomRepo.findById(roomNo);

   
        if (!optionalRoom.isPresent()) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room not found");
        }

        Room room = optionalRoom.get();


    
        if ("booked".equalsIgnoreCase(room.getStatus())) {
            return ResponseEntity.badRequest().body("Room is already booked");
        }

   
        List<String> occupants = Arrays.asList(userId, checkIn, checkOut);
  
  
        Room bookedRoom = roomService.updateRoomStatusAndOccupants(roomNo, "booked", occupants);
        userServices.updateRoom(userId,roomNo);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(bookedRoom);
    }

    //checkout

    @PostMapping("/checkout/{UserId}")
    public ResponseEntity<?> checkout(@PathVariable String UserId,@RequestParam(required=false) String roomNo){
        Optional<User> user=userRepo.findById(UserId);
        
        if(!user.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found");
        }

       

        if(roomNo!=null){
            Optional<Room> room = roomRepo.findById(roomNo);
            if (!room.isPresent()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Room not found");
            }
            roomService.updateRoomStatusAndOccupants(roomNo, "available", null);
            return ResponseEntity.status(HttpStatus.OK).body("Checkout successful");  
        }

        List<String> roomList=roomService.getRoomListOfUser(UserId);        

        if (roomList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User does not have any rooms");
        }

        for(int i=0;i<roomList.size();i++){
            roomService.updateRoomStatusAndOccupants(roomList.get(i), "available", null);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Checkout successful");
    }

    //laundry

    //food

    //cleaning

    //maintenance

    //roomservice


}
