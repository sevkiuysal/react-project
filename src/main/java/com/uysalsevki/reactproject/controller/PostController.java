package com.uysalsevki.reactproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uysalsevki.reactproject.dto.CreatePostRequest;
import com.uysalsevki.reactproject.dto.PostResponse;
import com.uysalsevki.reactproject.dto.UpdatePostRequest;
import com.uysalsevki.reactproject.entities.Post;
import com.uysalsevki.reactproject.service.PostService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/posts")
public class PostController {

	private PostService  postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
	}


	@GetMapping
	public List<PostResponse> getAllPosts(@RequestParam Optional<Long> userId){
		return postService.getAllPosts(userId);
	}
	
	@GetMapping("/{postId}")
	public Post getPostById(@PathVariable Long postId) {
		return postService.getPostById(postId);
	}
	@PostMapping
	public Post createPost(@RequestBody CreatePostRequest post) {
		return postService.createPost(post);
	}
	@PutMapping("/{postId}")
	public Post updatePost(@PathVariable Long postId, @RequestBody UpdatePostRequest updatePostRequest) {
		return postService.updatePost(postId,updatePostRequest);
	}
	@DeleteMapping("/{postId}")
	public void deletePostById(@PathVariable Long postId) {
		postService.deletePostById(postId);
	}
}
