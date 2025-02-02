package com.example.hms.demo.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hms.demo.Model.Occupant;
import com.example.hms.demo.Model.Room;
import com.example.hms.demo.Repository.RoomRepository;
import com.example.hms.demo.Services.RoomServices;

import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@Tag(name = "Room Controller", description = "APIs related to Room operations")
public class RoomController {

  @Autowired
  private RoomRepository roomRepo;

  @Autowired
  private RoomServices roomServices;

  @RequestMapping("/")
  public void redirect(HttpServletResponse response) throws IOException {
    response.sendRedirect("/swagger-ui.html");
  }

  
  @GetMapping("/rooms")
  public ResponseEntity<?> getAllRooms() {
    try {
      List<Room> rooms = roomRepo.findAll();
      return ResponseEntity.ok(rooms);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
        "Error fetching rooms: " + e.getMessage()
      );
    }
  }


  @GetMapping("/rooms/{roomNo}")
  public ResponseEntity<Room> getRoomByNumber(
    @PathVariable("roomNo") String roomNumber
  ) {
    try {
      Room room = roomServices.findRoomByRoomNumber(roomNumber);
      if (room != null) {
        return ResponseEntity.ok(room);
      }
      return ResponseEntity.notFound().build();
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @PostMapping("/rooms")
  public ResponseEntity<?> addRoom(@RequestBody Room room) {
    String newRoomNumber = room.getRoomNumber();
    if (roomRepo.findById(newRoomNumber).isPresent()) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body(
        "Room with number " + newRoomNumber + " already exists"
      );
    }

    Room newRoom = roomRepo.save(room);
    return ResponseEntity.status(HttpStatus.CREATED).body(newRoom);
  }

  @GetMapping("/rooms/available")
  public ResponseEntity<List<Room>> getAvailableRooms() {
    try {
      List<Room> room = roomRepo.getByStatus("Available");
      return ResponseEntity.ok(room);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
  

  @PutMapping("rooms/{roomNumber}")
  public ResponseEntity<?> updateRoom(@PathVariable String roomNumber,@RequestBody Room updatedRoom){
    if(roomServices.findRoomByRoomNumber(roomNumber)==null){
      Room room=roomRepo.save(updatedRoom);
      return ResponseEntity.status(HttpStatus.CREATED).body(room);
    }
    Room room=roomServices.updateRoom(roomNumber,updatedRoom);
    return ResponseEntity.ok(room);

  }

  @PatchMapping("rooms/{roomNumber}/{status}")
  public ResponseEntity<?> updateRoomStatus(@PathVariable String roomNumber, @PathVariable String status,@RequestBody(required=false) List<Occupant> occupants){
        if(StringUtils.isEmpty(status)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Status is required");
        }
        Room updatedRoom = roomServices.updateRoomStatusAndOccupants(roomNumber, status, occupants != null ? occupants :null);
        return ResponseEntity.ok(updatedRoom);
  }

  @DeleteMapping("rooms/{roomNumber}")
  public ResponseEntity<?> deleteRoom(@PathVariable String roomNumber){
    Room room = roomServices.findRoomByRoomNumber(roomNumber);
    if(room ==null){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Room does not exist");
    }

    roomRepo.deleteById(roomNumber);

  
    return ResponseEntity.status(HttpStatus.ACCEPTED).body("Room deleted successfully");
  }


}
