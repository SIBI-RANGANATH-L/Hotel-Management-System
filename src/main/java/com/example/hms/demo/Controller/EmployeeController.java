package com.example.hms.demo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hms.demo.Model.Employee;
import com.example.hms.demo.Repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepo;

    // CREATE
    @PostMapping("/addEmployee")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        employeeRepo.save(employee);
        return ResponseEntity.ok("Employee Added");
    }

    // READ
    @GetMapping("/getEmployees")
    public ResponseEntity<?> getAllEmployees() {
        return ResponseEntity.ok(employeeRepo.findAll());
    }

    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable String id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        if(employee.isPresent()) {
            return ResponseEntity.ok(employee.get());
        }
        return ResponseEntity.status(404).body("Employee not found");
    }

    // UPDATE
    @PatchMapping("/updateEmployee")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
        if (employeeRepo.existsById(employee.getId())) {
            employeeRepo.save(employee);
            return ResponseEntity.ok("Employee updated");
        }
        return ResponseEntity.status(404).body("Employee not found");
    }

    // DELETE
    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id) {
        if (employeeRepo.existsById(id)) {
            employeeRepo.deleteById(id);
            return ResponseEntity.ok("Employee deleted");
        }
        return ResponseEntity.status(404).body("Employee not found");
    }
}
