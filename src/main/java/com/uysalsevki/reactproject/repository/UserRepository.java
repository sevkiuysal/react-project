package com.uysalsevki.reactproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uysalsevki.reactproject.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
