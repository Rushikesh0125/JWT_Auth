package com.example.AssignmentRushikeshJadhav.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    Get mapping with /api/v1/resource
    JWT Token to be provided as an auth token with "Bearer " as prefix
 */
//Rest controller annotation to denote class as controller for spring application
//Request mapping to provide a path for requests
@RestController
@RequestMapping("/api/v1/resource")
@RequiredArgsConstructor
public class AuthorizationController {
    //Provides access and returns Hello! authorized
    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello!! Authorized");
    }
}
