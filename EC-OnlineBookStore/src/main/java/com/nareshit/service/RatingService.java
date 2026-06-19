package com.nareshit.service;

import java.util.List;

import com.nareshit.entity.Ratings;
import com.nareshit.model.RatingsDto;

public interface RatingService {


	public Ratings createRatingRivews(RatingsDto ratingsDto);

	public List<Ratings> getByAllReview();

}
