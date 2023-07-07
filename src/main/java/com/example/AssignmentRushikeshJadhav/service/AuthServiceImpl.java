package com.example.AssignmentRushikeshJadhav.service;

import com.example.AssignmentRushikeshJadhav.dao.requestDto.SignIn;
import com.example.AssignmentRushikeshJadhav.dao.requestDto.SignUp;
import com.example.AssignmentRushikeshJadhav.dao.response.JwtAuthResponse;
import com.example.AssignmentRushikeshJadhav.entity.Role;
import com.example.AssignmentRushikeshJadhav.entity.User;
import com.example.AssignmentRushikeshJadhav.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/*
    Service implementation for Sign up
    And sign in authentication
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    /*
        Implementation of Sign up method
        Input - Sign up request dto as input param
        Returns - jwt token as output
     */
    @Override
    public JwtAuthResponse signup(SignUp request) {
        //creating user object with username, password and role
        var user = User.builder().username(request.getUsername()).password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER).build();
        //Saving the user in database
        userRepository.save(user);
        //Generating token for user
        var jwt = jwtService.generateToken(user);
        //Returning JWT token
        return JwtAuthResponse.builder().token(jwt).build();
    }

    /*
        Implementation of Sign up method
        Input - Sign up request dto as input param
        Returns - jwt token as output
     */
    @Override
    public JwtAuthResponse signin(SignIn request) {
        //Authentication using user information - username and password
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        //Getting user from database based on unique username if not found throwing exception
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Invalid username."));

        var jwt = jwtService.generateToken(user);
        return JwtAuthResponse.builder().token(jwt).build();
    }
}
