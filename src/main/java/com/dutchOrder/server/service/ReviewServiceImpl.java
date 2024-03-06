package com.dutchOrder.server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dutchOrder.server.dao.ReviewDao;
import com.dutchOrder.server.model.Review;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
	
	private final ReviewDao rd;

	@Override
	public List<Review> listReview(Review review) {
		List<Review> reviewList = null;
		System.out.println("ReviewServiceImpl listReview Start...");
		reviewList = rd.listReview(review);
		System.out.println("ReviewServiceImpl listReview reviewList.size() -> " + reviewList.size());
		
		return reviewList;
	}

	@Override
	public Review commentReview(int rnum) {
		Review review = null;
		System.out.println("ReviewServiceImpl reviewComment Start...");
		System.out.println("ReviewServiceImpl reviewComment rnum -> " + rnum);
		review = rd.reviewComment(rnum);
		System.out.println("ReviewServiceImpl reviewComment review -> " + review);
		
		return review;
	}

	@Override
	public int writeComment(Review review) {
		int commentWrite = 0;
		System.out.println("ReviewServiceImpl writeComment Start...");
		commentWrite= rd.writeComment(review);
		
		return commentWrite;
	}

}
