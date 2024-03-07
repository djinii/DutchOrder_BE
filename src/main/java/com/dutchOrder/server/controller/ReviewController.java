package com.dutchOrder.server.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dutchOrder.server.model.OrderInfo;
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
	
	/** 리뷰 리스트 -클라이언트- */
	@ResponseBody
	@PostMapping("/JY_C_ReviewList")
	public List<OrderInfo> clReviewList(@RequestBody OrderInfo orderInfo) {
		System.out.println("ReviewController Start clReviewList ... ");	
		System.out.println("ReviewController clReviewList orderInfo "+orderInfo);
		List<OrderInfo> clListReview = rs.clListReview(orderInfo);
		System.out.println("ReviewController List clListReview.size() -> " + clListReview.size());
		System.out.println("ReviewController clReviewList last check orderInfo "+orderInfo);
		
		return clListReview;
	}
	
	/** 나의 리뷰상세 페이지 -클라이언트- */
	@ResponseBody
	@PostMapping("/JY_C_MyReview")
	public Review clMyReview(@RequestBody Review review) {
		System.out.println("ReviewController Start clMyReview...");
		System.out.println("ReviewController clMyReview review " + review);
		Review reviewMy = rs.reviewMy(review.getRnum());
		System.out.println("ReviewController clMyReview reviewMy -> " + reviewMy);
		
		return reviewMy; 
	}
	
	/** 리뷰 작성 페이지 -클라이언트- */
	@ResponseBody
	@PostMapping("/JY_C_ReviewWrite")
	public int clReviewWrite(@RequestBody Review review) {
		System.out.println("ReviewController Start clReviewWrite...");
		System.out.println("ReviewController clReviewWrite review " + review);
		int writeReview = rs.writeReview(review);
		
		return writeReview;
	}
	
	/** 나의 리뷰정보 -클라이언트- */
	@ResponseBody
	@PostMapping("/JY_C_WriteInfo")
	public Review clWriteInfo(@RequestBody Review review) {
		System.out.println("ReviewController Start clWriteInfo...");
		System.out.println("ReviewController clWriteInfo review " + review);
		Review infoWrite = rs.infoWrite(review.getOnum());
		System.out.println("ReviewController clWriteInfo infoWrite -> " + infoWrite);
		
		return infoWrite; 
	}
	
}
