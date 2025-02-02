package com.example.hms.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.hms.demo.Model.Employee;

@Repository
public interface EmployeeRepository  extends MongoRepository<Employee, String>{
    


}
