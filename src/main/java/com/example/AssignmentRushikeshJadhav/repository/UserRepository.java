package com.example.AssignmentRushikeshJadhav.repository;

import com.example.AssignmentRushikeshJadhav.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Repository to annotate interface as Repository
//And JPARepository makes it a JPA repository mapping User objects to Integer Id
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    //Method to get user using username
    Optional<User> findByUsername(String username);
}
