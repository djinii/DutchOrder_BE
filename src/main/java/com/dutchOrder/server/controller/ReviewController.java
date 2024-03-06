package com.dutchOrder.server.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dutchOrder.server.model.Review;
import com.dutchOrder.server.service.ReviewService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ReviewController {
	
	private final ReviewService rs;
	
	/** 리뷰목록 -사업자- */
	@ResponseBody
	@PostMapping("/JY_B_ReviewList")
	public List<Review> buReviewList(@RequestBody Review review) {
		System.out.println("ReviewController Start buReviewList ... ");	
		System.out.println("ReviewController buReviewList review "+review);
		List<Review> listReview = rs.listReview(review);
		System.out.println("ReviewController List listReview.size() -> " + listReview.size());
		System.out.println("ReviewController buReviewList last check review "+review);
		
		return listReview;
	}
	
	/** 리뷰답글페이지 -사업자- */
	@ResponseBody
	@PostMapping("/JY_B_ReviewComment")
	public Review buReviewComment(@RequestBody Review review) {
		System.out.println("ReviewController Start buReviewComment...");
		System.out.println("ReviewController buReviewComment review " + review);
		Review commentReview = rs.commentReview(review.getRnum());
		System.out.println("ReviewController buReviewComment commentReview -> " + commentReview);
		
		return commentReview; 
	}
	
	/** 리뷰 답글달기 -사업자 */
	@ResponseBody
	@PostMapping("/JY_B_CommentWrite")
	public int buCommentWrite(@RequestBody Review review) {
		System.out.println("ReviewController Start buCommentWrite");
		System.out.println("ReviewController buCommentWrite review " + review);
		int writeComment = rs.writeComment(review);
		System.out.println("ReviewController ns.writeComment writeComment -> " + writeComment);
		
		return writeComment;
	}

}
