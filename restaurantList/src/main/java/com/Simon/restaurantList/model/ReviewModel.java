package com.Simon.restaurantList.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReviewModel {
	private Double rating;
	private String review;

	public ReviewModel(@JsonProperty("rating") Double rating, @JsonProperty("review") String review) {
		this.rating = rating;
		this.review = review;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
	
}
