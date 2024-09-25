package com.uysalsevki.reactproject.dto;

public class PostResponse {

	private Long id;
	private Long userId;
	private String username;
	private String title;
	private String text;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public static class builder {
		private Long id;
		private Long userId;
		private String username;
		private String title;
		private String text;

		public builder id(Long id) {
			this.id = id;
			return this;
		}

		public builder userId(Long userId) {
			this.userId = userId;
			return this;
		}

		public builder username(String username) {
			this.username = username;
			return this;
		}

		public builder title(String title) {
			this.title = title;
			return this;
		}

		public builder text(String text) {
			this.text = text;
			return this;
		}

		public PostResponse build() {
			return new PostResponse(this);
		}
	}

	public PostResponse(builder builder) {
		this.id = builder.id;
		this.userId = builder.userId;
		this.username = builder.username;
		this.title = builder.title;
		this.text = builder.text;
	}

}
