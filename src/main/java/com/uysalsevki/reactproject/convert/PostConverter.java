package com.uysalsevki.reactproject.convert;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.uysalsevki.reactproject.dto.PostResponse;
import com.uysalsevki.reactproject.entities.Post;

@Component
public class PostConverter {
	public PostResponse ToPostResponse(Post post) {
		return new PostResponse.builder()
				.id(post.getId())
				.userId(post.getUser().getId())
				.username(post.getUser().getUsername())
				.title(post.getTitle())
				.text(post.getText())
				.build();
	}
	
	public List<PostResponse> ToPostResponseList(List<Post> posts){
		return posts.stream()
				.map(post -> ToPostResponse(post))
				.collect(Collectors.toList());
	}

}
