package com.uysalsevki.reactproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uysalsevki.reactproject.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findByUserIdAndPostId(Long userId, Long postId);

	List<Comment> findByUserId(Long id);

	List<Comment> findByPostId(Long id);

}
