package com.example.hms.demo.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "user")
public class User {
    
    @Id
    @Field("_id")
    private String id;

    @Field("email")  
    private String email;

    @Field("username")
    private String username;

    @Field("password")
    private String password;

    @Field("room")
    private String room;
    
    public User(){}
    public User(String id, String email, String password, String room, String username) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.room = room;
        this.username = username;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


   
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", room='" + room + '\'' +
                '}';
    }
    
    


}
