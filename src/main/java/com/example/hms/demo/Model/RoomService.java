package com.example.hms.demo.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;



@Document(collection = "roomservice")
public class RoomService {

    @Id
    @Field("_id")
    private String serviceId;
    @Field("user")
    private String userId;
    @Field("assignedEmployee")
    private Employee assignedEmployee;
    @Field("serviceType")
    private String serviceType;
    @Field("description")
    private String description;
    @Field("serviceStatus")
    private String serviceStatus;

    public  RoomService() {
    }
    
    public RoomService(String serviceId, String userId, Employee assignedEmployee, String serviceType, String description, String serviceStatus) {
        this.serviceId = serviceId;
        this.userId = userId;
        this.assignedEmployee = assignedEmployee;
        this.serviceType = serviceType;
        this.description = description;
        this.serviceStatus = serviceStatus;
    }


    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Employee getAssignedEmployee() {
        return assignedEmployee;
    }

    public void setAssignedEmployee(Employee assignedEmployee) {
        this.assignedEmployee = assignedEmployee;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    
    
}
