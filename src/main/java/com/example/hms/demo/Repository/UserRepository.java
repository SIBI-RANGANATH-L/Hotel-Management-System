package com.example.hms.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.hms.demo.Model.User;

public interface UserRepository extends MongoRepository<User, String> {
   
}