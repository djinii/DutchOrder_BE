package com.dutchOrder.server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dutchOrder.server.dao.ReviewDao;
import com.dutchOrder.server.model.OrderInfo;
import com.dutchOrder.server.model.Review;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
	
	private final ReviewDao rd;

	@Override
	public List<Review> listReview(int mnum) {
		List<Review> reviewList = null;
		System.out.println("ReviewServiceImpl listReview Start...");
		reviewList = rd.listReview(mnum);
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

	@Override
	public List<OrderInfo> clListReview(int mnum) {
		List<OrderInfo> clReviewList = null;
		System.out.println("ReviewServiceImpl clListReview Start...");
		clReviewList = rd.clListReview(mnum);
		System.out.println("ReviewServiceImpl clListReview clReviewList.size() -> " + clReviewList.size());
		
		return clReviewList;
	}

	@Override
	public Review reviewMy(int rnum) {
		Review review = null;
		System.out.println("ReviewServiceImpl reviewMy Start...");
		System.out.println("ReviewServiceImpl reviewMy rnum -> " + rnum);
		review = rd.reviewMy(rnum);
		System.out.println("ReviewServiceImpl reviewMy review -> " + review);
		
		return review;
	}

	@Override
	public int writeReview(Review review) {
		int reviewWrite = 0;
		System.out.println("ReviewServiceImpl writeReview Start...");
		reviewWrite = rd.writeReview(review);
		
		return reviewWrite;
	}

	@Override
	public Review infoWrite(int onum) {
		Review review = null;
		System.out.println("ReviewServiceImpl infoWrite Start...");
		System.out.println("ReviewServiceImpl infoWrite onum -> " + onum);
		review = rd.writeInfo(onum);
		System.out.println("ReviewServiceImpl infoWrite review -> " + review);
		
		return review;
	}

}