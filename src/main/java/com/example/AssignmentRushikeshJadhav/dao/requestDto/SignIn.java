package com.example.AssignmentRushikeshJadhav.dao.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*  EVEN THOUGH SIGN UP AND SIGN IN REQUEST BODIES ARE SAME
    I HAVE CREATED TWO SEPARATE CLASSES
    BECAUSE IN FUTURE IF USER CLASS IS UPDATED WITH MORE ATTRIBUTES
    AND SIGN UP PARAMETERS ARE INCREASED WE WILL STILL PASS USERNAME AND PASSWORD FOR SIGN IN
 */

/*
    DTO for Sign in request
    Sign request should contains
        username
        password
 */

//Data for getters & setters, Builder for object building
//Noargs and allArgs constrctors for parameterized and non-parameterized constructor
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignIn {
    private String username;
    private String password;
}
