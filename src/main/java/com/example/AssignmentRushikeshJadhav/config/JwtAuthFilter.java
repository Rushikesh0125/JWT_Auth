package com.example.AssignmentRushikeshJadhav.config;

import com.example.AssignmentRushikeshJadhav.service.JwtService;
import com.example.AssignmentRushikeshJadhav.service.UserService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/*
This class is a filter for JWT authentication -
    intercepts incoming HTTP requests
    checks for the presence of a JWT token in the "Authorization" header.
    If a valid token is found
        then it is used to authenticate the user by setting the authentication token in the SecurityContext
 */
@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserService userService;
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response, @NonNull FilterChain filterChain)
            throws ServletException, IOException {

        //Getting Authorization Header from request
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String username;

        //Passing the request along the filter chain if Authorization Header is not null and is not starting with Bearer
        if (authHeader != null && !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        //Check If we have received Authorization Header but security context does not have Authorization Header
        if (authHeader != null
                && SecurityContextHolder.getContext().getAuthentication() == null) {

            //eliminating Bearer Prefix from Authorization Header
            jwt = authHeader.substring(7);
            //Getting username from token
            username = jwtService.extractUserName(jwt);
            //Loading the user details from using username from user service
            UserDetails userDetails = userService.userDetailsService()
                    .loadUserByUsername(username);
            //Creating new authentication token if JWT is valid for the user
            //ans updating security context holder with authentication token
            if (jwtService.isTokenValid(jwt, userDetails)) {
                SecurityContext context = SecurityContextHolder.createEmptyContext();
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                context.setAuthentication(authToken);
                SecurityContextHolder.setContext(context);
            }
        }
        //continue the filter chain after processing tokens
        filterChain.doFilter(request, response);
    }
}
