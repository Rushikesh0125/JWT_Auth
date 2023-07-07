package com.example.AssignmentRushikeshJadhav.service;

import com.example.AssignmentRushikeshJadhav.dao.requestDto.SignIn;
import com.example.AssignmentRushikeshJadhav.dao.requestDto.SignUp;
import com.example.AssignmentRushikeshJadhav.dao.response.JwtAuthResponse;

public interface AuthService {
    JwtAuthResponse signup(SignUp request);

    JwtAuthResponse signin(SignIn request);
}
