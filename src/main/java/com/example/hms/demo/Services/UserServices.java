package com.example.hms.demo.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hms.demo.Model.User;
import com.example.hms.demo.Repository.UserRepository;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepo;

    public void updateRoom(String userId, String roomNo) {
        
        Optional<User> optionalUser = userRepo.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setRoom(roomNo); 
            userRepo.save(user);
        }

    }

    
    
}
