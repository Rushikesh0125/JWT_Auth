package com.example.AssignmentRushikeshJadhav.dao.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
    DTO for Sign up request
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
public class SignUp {
    private String username;
    private String password;
}
