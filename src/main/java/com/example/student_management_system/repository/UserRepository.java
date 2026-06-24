package com.example.student_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student_management_system.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

}
