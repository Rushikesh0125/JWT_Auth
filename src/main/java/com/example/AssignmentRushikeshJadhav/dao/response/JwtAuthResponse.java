package com.example.AssignmentRushikeshJadhav.dao.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
    Response object for signup and signin requests
    Response will have String of JWT token
 */

//Data for getters & setters, Builder for object building
//Noargs and allArgs constrctors for parameterized and non-parameterized constructor
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthResponse {
    private String token;
}
