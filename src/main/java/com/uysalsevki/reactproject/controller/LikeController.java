package com.uysalsevki.reactproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uysalsevki.reactproject.dto.CreateLikeRequest;
import com.uysalsevki.reactproject.entities.Like;
import com.uysalsevki.reactproject.service.LikeService;

@RestController
public class LikeController {
	
	private LikeService likeService;

	public LikeController(LikeService likeService) {
		this.likeService = likeService;
	}
	
	@GetMapping
	public List<Like> getAllLikes(@RequestParam Optional<Long> userId,
			@RequestParam Optional<Long> postId){
		return likeService.getAllLikes(userId,postId);
	}
	@GetMapping("/{likeId}")
	public Like getLikeById(@PathVariable Long likeId) {
		return likeService.getLikeById(likeId);
	}
	@PostMapping
	public Like createlike(@RequestBody CreateLikeRequest request) {
		return likeService.createLike(request);
	}
	@DeleteMapping("/{likeId}")
	public void deleteLikeById(@PathVariable Long likeId) {
		likeService.deleteLikeById(likeId);
	}

}
