package com.hacen.evenements.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hacen.evenements.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}