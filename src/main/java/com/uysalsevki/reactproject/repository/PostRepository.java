package com.uysalsevki.reactproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uysalsevki.reactproject.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

	List<Post> findByUserId(Long userId);

}
