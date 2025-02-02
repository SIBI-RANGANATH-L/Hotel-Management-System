package com.example.hms.demo.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;



@Document(collection = "employee")  
public class Employee {

    @Id
    @Field("_id")   
    private String id;

    @Field("name")
    private String name;

    @Field("available")
    private boolean available;

    public Employee(String id, String name,boolean available) {
        this.id = id;
        this.name = name;
        this.available = available;
    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getAvailable() {
        return available;
    }

    public void setAvalibale(boolean available) {
        this.available = available;
    }

    
    
    
}
