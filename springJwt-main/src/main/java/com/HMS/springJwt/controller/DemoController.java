package com.HMS.springJwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public ResponseEntity<String> demo() {
        return ResponseEntity.ok("Hello from secured url");
    }

    @GetMapping("/admin_only")
    public ResponseEntity<String> adminOnly() {
        return ResponseEntity.ok("Hello from admin only url");
    }

    @GetMapping("/manager_only")
    public ResponseEntity<String> managerOnly(){
        return ResponseEntity.ok("Manager services");
    }

    @GetMapping("/employee_only")
    public ResponseEntity<String> employeeOnly(){
        return ResponseEntity.ok("employee services");
    }
}
