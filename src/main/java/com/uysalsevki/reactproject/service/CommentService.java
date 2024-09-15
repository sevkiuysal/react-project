package com.uysalsevki.reactproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.uysalsevki.reactproject.dto.CreateCommentRequest;
import com.uysalsevki.reactproject.dto.UpdateCommentRequest;
import com.uysalsevki.reactproject.entities.Comment;
import com.uysalsevki.reactproject.entities.Post;
import com.uysalsevki.reactproject.entities.User;
import com.uysalsevki.reactproject.repository.CommentRepository;

@Service
public class CommentService {
	
	private CommentRepository commentRepository;
	private UserService userService;
	private PostService postService;

	public CommentService(CommentRepository commentRepository, UserService userService, PostService postService) {
		this.commentRepository = commentRepository;
		this.userService = userService;
		this.postService = postService;
	}

	public List<Comment> getAllComments(Optional<Long> userId, Optional<Long> postId) {
		if(userId.isPresent() && postId.isPresent()) 
			return commentRepository.findByUserIdAndPostId(userId.get(),postId.get());
		else if(userId.isPresent())
			return commentRepository.findByUserId(userId.get());
		else if(postId.isPresent())
			return commentRepository.findByPostId(postId.get());
		else
		return commentRepository.findAll();
	}

	public Comment getCommentById(Long commentId) {
		return commentRepository.findById(commentId).orElse(null);
	}

	public Comment createComment(CreateCommentRequest request) {
		User user=userService.getUserById(request.getUserId());
		Post post=postService.getPostById(request.getPostId());
		if(user !=null && post!=null) {
			Comment toSave=new Comment();
			toSave.setId(request.getId());
			toSave.setPost(post);
			toSave.setUser(user);
			toSave.setText(request.getText());
			return commentRepository.save(toSave);
		}else
			return null;
	}
	
	public Comment updateComment(Long commentId, UpdateCommentRequest newComment) {
		Optional<Comment> comment=commentRepository.findById(commentId);
		if(comment.isPresent()) {
			Comment toUpdate=comment.get();
			toUpdate.setText(newComment.getText());
			return commentRepository.save(toUpdate);
		}
		return null;
	}

	public void deleteCommentById(Long commentId) {
		commentRepository.deleteById(commentId);
		
	}

}
