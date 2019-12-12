package com.Simon.restaurantList.service.serviceImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.Simon.restaurantList.model.ReviewModel;
import com.Simon.restaurantList.service.ReviewService;

@Service("defaultReviewService")
public class DefaultReviewService implements ReviewService {

	@Override
	public ReviewModel createReview(String review, Double rating) {
		if (rating != null && rating < 0)
			throw new IllegalArgumentException("Rating cannot be negative!");

		rating = round(rating);
		return new ReviewModel(rating, review);
	}

	@Override
	public void editReviewMsg(String review, ReviewModel reviewModel) {
		reviewModel.setReview(review);
	}

	@Override
	public void deleteReviewMsg(ReviewModel reviewModel) {
		reviewModel.setReview("");
	}

	@Override
	public void editRating(Double rating, ReviewModel reviewModel) {
		if (rating != null && rating < 0)
			throw new IllegalArgumentException("Rating cannot be negative!");

		rating = round(rating);
		reviewModel.setRating(rating);
	}

	@Override
	public void deleteRating(ReviewModel reviewModel) {
		reviewModel.setRating(null);

	}

	public Double round(Double value) {
		BigDecimal bd = new BigDecimal(value).setScale(2, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

}
