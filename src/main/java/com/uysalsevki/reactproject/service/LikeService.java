package com.uysalsevki.reactproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.uysalsevki.reactproject.dto.CreateLikeRequest;
import com.uysalsevki.reactproject.entities.Like;
import com.uysalsevki.reactproject.entities.Post;
import com.uysalsevki.reactproject.entities.User;
import com.uysalsevki.reactproject.repository.LikeRepository;

@Service
public class LikeService {
	
	private LikeRepository likeRepository;
	private UserService userService;
	private PostService postService;

	public LikeService(LikeRepository likeRepository, UserService userService, PostService postService) {
		this.likeRepository = likeRepository;
		this.userService = userService;
		this.postService = postService;
	}

	public List<Like> getAllLikes(Optional<Long> userId, Optional<Long> postId) {
		return likeRepository.findAll();
	}

	public Like getLikeById(Long likeId) {
		return likeRepository.findById(likeId).orElse(null);
	}

	public Like createLike(CreateLikeRequest request) {
		User user=userService.getUserById(request.getUserId());
		Post post=postService.getPostById(request.getPostId());
		if(user!=null && post!=null) {
			Like toSave=new Like();
			toSave.setId(request.getId());
			toSave.setPost(post);
			toSave.setUser(user);
			return likeRepository.save(toSave);
		}
		return null;
	}

	public void deleteLikeById(Long likeId) {
		likeRepository.deleteById(likeId);
		
	}

}
