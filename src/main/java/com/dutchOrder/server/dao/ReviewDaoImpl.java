package com.dutchOrder.server.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dutchOrder.server.model.Review;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ReviewDaoImpl implements ReviewDao {
	
	private final SqlSession session;

	@Override
	public List<Review> listReview(Review review) {
		List<Review> reviewList = null;
		System.out.println("ReviewDaoImpl listReview Start...");
		try {
			reviewList = session.selectList("mapReviewList", review);
			System.out.println("ReviewDaoImpl listReview reviewList.size() -> " + reviewList.size());
		} catch (Exception e) {
			System.out.println("ReviewDaoImpl reviewList Exception -> " + e.getMessage());
		}
		
		return reviewList;
	}

	@Override
	public Review reviewComment(int rnum) {
		System.out.println("ReviewDaoImpl reviewComment Start...");
		Review review = new Review();
		try {
			review = session.selectOne("mapReviewComment", rnum);
			System.out.println("ReviewDaoImpl reviewComment getRnum -> " + review.getRnum());
		} catch (Exception e) {
			System.out.println("ReviewDaoImpl reviewComment Exception -> " + e.getMessage());
		}
		
		return review;
	}

	@Override
	public int writeComment(Review review) {
		System.out.println("ReviewDaoImpl writeComment Start...");
		int commentWrite = 0;
		try {
			commentWrite = session.update("mapCommentWrite", review);
		} catch (Exception e) {
			System.out.println("NoticeDaoImpl modifyNotice Exception -> " + e.getMessage());
		}
		
		return commentWrite;
	}

}
