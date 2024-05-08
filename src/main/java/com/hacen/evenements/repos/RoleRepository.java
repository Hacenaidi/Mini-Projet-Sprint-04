package com.hacen.evenements.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hacen.evenements.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
Role findByRole(String role);
}
