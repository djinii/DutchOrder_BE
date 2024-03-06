package com.dutchOrder.server.service;

import java.util.List;

import com.dutchOrder.server.model.Review;

public interface ReviewService {

	List<Review> listReview(Review review);

	Review commentReview(int rnum);

	int writeComment(Review review);

}
