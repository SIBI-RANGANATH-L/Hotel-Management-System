package com.example.hms.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hms.demo.Model.User;
import com.example.hms.demo.Repository.UserRepository;


@RestController
@RequestMapping("/user")    
public class UserController {

    @Autowired
    UserRepository userRepo;

    // Create
    @PostMapping("/add")
public ResponseEntity<?> createUser(@RequestBody User user) {

    // System.out.println("---------------------------------------------------------------------------------------------------------");
    // // Debugging: Print user object
    // System.out.println("Received user: " + user.toString());
    // System.out.println("---------------------------------------------------------------------------------------------------------");

    userRepo.save(user);
    return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully"); 
}
    
    // Read
    @GetMapping("/get")
    public List<User> getAllUsers(){
        List<User> users = userRepo.findAll();
        return users;
    } 


    @GetMapping("get/{id}") 
    public ResponseEntity<?> getUser(@PathVariable String id){
        if(userRepo.existsById(id)){
            return ResponseEntity.status(HttpStatus.OK).body(userRepo.findById(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }


    @GetMapping("/bookedRoom/{id}")
    public ResponseEntity<Boolean> bookedRoom(@PathVariable String id){
        if(userRepo.existsById(id)){
            User user = userRepo.findById(id).get();
            if(user.getRoom()!=null){
                return ResponseEntity.status(HttpStatus.OK).body(true);
            }
            else{
                return ResponseEntity.status(HttpStatus.OK).body(false);    
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
    }

      
    

    // Update

    // Delete
    
}
