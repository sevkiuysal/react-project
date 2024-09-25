package com.uysalsevki.reactproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.uysalsevki.reactproject.convert.PostConverter;
import com.uysalsevki.reactproject.dto.CreatePostRequest;
import com.uysalsevki.reactproject.dto.PostResponse;
import com.uysalsevki.reactproject.dto.UpdatePostRequest;
import com.uysalsevki.reactproject.entities.Post;
import com.uysalsevki.reactproject.entities.User;
import com.uysalsevki.reactproject.repository.PostRepository;

@Service
public class PostService {

	private PostRepository postRepository;
	
	private UserService userService;
	
	private PostConverter postConverter;

	public PostService(PostRepository postRepository, UserService userService, PostConverter postConverter) {
		this.postRepository = postRepository;
		this.userService = userService;
		this.postConverter = postConverter;
	}

	public List<PostResponse> getAllPosts(Optional<Long> userId) {
		
		if(userId.isPresent()) {
			return postConverter.ToPostResponseList(
					postRepository.findByUserId(userId.get())
					);
		}else
		return postConverter.ToPostResponseList(postRepository.findAll());
	}

	public Post getPostById(Long postId) {
		return postRepository.findById(postId).orElse(null);
	}

	public Post createPost(CreatePostRequest createPostRequest) {
		User user=userService.getUserById(createPostRequest.getUserId());
		if(user == null)
			return null;
		Post toSave=new Post();
		toSave.setId(createPostRequest.getId());
		toSave.setText(createPostRequest.getText());
		toSave.setTitle(createPostRequest.getTitle());
		toSave.setUser(user);
		return postRepository.save(toSave);
	}

	public Post updatePost(Long postId, UpdatePostRequest updatePostRequest) {
		Optional<Post> post=postRepository.findById(postId);
		if(post.isPresent()) {
			Post toUpdate=post.get();
			toUpdate.setText(updatePostRequest.getText());
			toUpdate.setTitle(updatePostRequest.getTitle());
			return postRepository.save(toUpdate);
		}return null;
	}

	public void deletePostById(Long postId) {
		postRepository.deleteById(postId);
	}
	
	
}
