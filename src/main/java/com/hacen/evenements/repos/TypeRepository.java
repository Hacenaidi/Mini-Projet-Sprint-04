package com.hacen.evenements.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hacen.evenements.model.Type;

public interface TypeRepository extends JpaRepository<Type, Long> {

}
