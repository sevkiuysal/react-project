package com.uysalsevki.reactproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uysalsevki.reactproject.dto.CreateCommentRequest;
import com.uysalsevki.reactproject.dto.UpdateCommentRequest;
import com.uysalsevki.reactproject.entities.Comment;
import com.uysalsevki.reactproject.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {
	
	private CommentService commentService;

	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}
	
	@GetMapping
	public List<Comment> getAllComments(@RequestParam Optional<Long> userId,
			@RequestParam Optional<Long> postId){
		return commentService.getAllComments(userId,postId);
	}
	@GetMapping("/{commentId}")
	public Comment getCommentById(@PathVariable Long commentId) {
		return commentService.getCommentById(commentId);
	}
	@PostMapping
	public Comment createComment(@RequestBody CreateCommentRequest reqeust) {
		return commentService.createComment(reqeust);
	}
	@PutMapping("/{commentId}")
	public Comment updateComment(@PathVariable Long commentId,@RequestBody UpdateCommentRequest request) {
		return commentService.updateComment(commentId, request);
	}
	@DeleteMapping("/{commentId}")
	public void deleteCommentById(@PathVariable Long commentId) {
		commentService.deleteCommentById(commentId);
	}

}
