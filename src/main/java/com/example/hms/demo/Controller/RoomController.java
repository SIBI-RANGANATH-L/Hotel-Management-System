// package com.example.hms.demo.Controller;

// import java.io.IOException;
// import java.util.List;

// import javax.servlet.http.HttpServletResponse;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.hms.demo.Model.Room;
// import com.example.hms.demo.RoomRepository;

// import springfox.documentation.annotations.ApiIgnore;

// @RestController
// public class RoomController {

//     @Autowired
//     private RoomRepository roomRepo;

//     @ApiIgnore
//     @RequestMapping("/")
//     public void redirect(HttpServletResponse response) throws IOException {
//         response.sendRedirect("/swagger-ui.html");
//     }

//     @GetMapping("/rooms")
//     public ResponseEntity<?> getAllRooms() {
//         try {
//             // Fetch all rooms from the database
//             List<Room> rooms = roomRepo.findAll();
//             return ResponseEntity.ok(rooms);
//         } catch (Exception e) {
//             // Handle and return the error gracefully
//             return ResponseEntity.status(500).body("Error fetching rooms: " + e.getMessage());
//         }
//     }
// }
package com.example.hms.demo.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hms.demo.Model.Room;
import com.example.hms.demo.RoomRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Room Controller", description = "APIs related to Room operations")
public class RoomController {

    @Autowired
    private RoomRepository roomRepo;

    @RequestMapping("/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/rooms")
    @Operation(summary = "Get all rooms", description = "Retrieve a list of all available rooms")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of rooms"),
        @ApiResponse(responseCode = "500", description = "Internal server error while fetching rooms")
    })
    public ResponseEntity<?> getAllRooms() {
        try {
            // Fetch all rooms from the database
            List<Room> rooms = roomRepo.findAll();
            return ResponseEntity.ok(rooms);
        } catch (Exception e) {
            // Handle and return the error gracefully
            return ResponseEntity.status(500).body("Error fetching rooms: " + e.getMessage());
        }
    }
}
