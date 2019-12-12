package com.Simon.restaurantList.service;

import com.Simon.restaurantList.model.ReviewModel;

public interface ReviewService {
	public ReviewModel createReview(String review, Double rating);

	public void editReviewMsg(String review, ReviewModel reviewModel);

	public void deleteReviewMsg(ReviewModel reviewModel);

	public void editRating(Double rating, ReviewModel reviewModel);

	public void deleteRating(ReviewModel reviewModel);
	
	//Implement get review/rating by restaurant id
}
