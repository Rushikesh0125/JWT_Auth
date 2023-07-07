package com.example.AssignmentRushikeshJadhav.controller;

import com.example.AssignmentRushikeshJadhav.dao.requestDto.SignIn;
import com.example.AssignmentRushikeshJadhav.dao.requestDto.SignUp;
import com.example.AssignmentRushikeshJadhav.dao.response.JwtAuthResponse;
import com.example.AssignmentRushikeshJadhav.service.AuthService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Rest controller annotation to denote class as controller for spring application
//Request mapping to provide a path for requests
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthService authenticationService;

    /*
        Invokes sign up function from auth service
        it returns jwt response (a jwt token string) with Response status 200
        Post mapping with username and password to be provided as request body
     */
    @PostMapping("/signup")
    public ResponseEntity<JwtAuthResponse> signup(@RequestBody SignUp request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    /*
        Invokes sign in function from auth service
        it returns jwt response (a jwt token string) with Response status 200
        Post mapping with username and password to be provided as request body
        JWT Token to be provided as an auth token with "Bearer " as prefix
     */
    @PostMapping("/signin")
    public ResponseEntity<JwtAuthResponse> signin(@RequestBody SignIn request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}
