package com.uysalsevki.reactproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uysalsevki.reactproject.entities.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {

}
