package com.dutchOrder.server.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dutchOrder.server.model.OrderInfo;
import com.dutchOrder.server.model.Review;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ReviewDaoImpl implements ReviewDao {
	
	private final SqlSession session;

	@Override
	public List<Review> listReview(int mnum) {
		List<Review> reviewList = null;
		System.out.println("ReviewDaoImpl listReview Start...");
		try {
			reviewList = session.selectList("mapReviewList", mnum);
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

	@Override
	public List<OrderInfo> clListReview(int mnum) {
		List<OrderInfo> clReviewList = null;
		System.out.println("ReviewDaoImpl clListReview Start...");
		try {
			clReviewList = session.selectList("mapClReviewList", mnum);
			System.out.println("ReviewDaoImpl clListReview clReviewList.size() -> " + clReviewList.size());
		} catch (Exception e) {
			System.out.println("ReviewDaoImpl clReviewList Exception -> " + e.getMessage());
		}
		
		return clReviewList;
	}

	@Override
	public Review reviewMy(int rnum) {
		System.out.println("ReviewDaoImpl reviewMy Start...");
		Review review = new Review();
		try {
			review = session.selectOne("mapMyReview", rnum);
			System.out.println("ReviewDaoImpl reviewMy getRnum -> " + review.getRnum());
		} catch (Exception e) {
			System.out.println("ReviewDaoImpl reviewMy Exception -> " + e.getMessage());
		}
		
		return review;
	}

	@Override
	public int writeReview(Review review) {
		System.out.println("ReviewDaoImpl writeReview Start...");
		System.out.println("ReviewDaoImpl writeReview review->"+review);
		int reviewWrite = 0;
		try {
			reviewWrite = session.insert("mapReviewWrite", review);
		} catch (Exception e) {
			System.out.println("ReviewDaoImpl writeReview Exception -> " + e.getMessage());
		}
		
		return reviewWrite;
	}

	@Override
	public Review writeInfo(int onum) {
		System.out.println("ReviewDaoImpl writeInfo Start...");
		Review review = new Review();
		try {
			review = session.selectOne("mapWriteInfo", onum);
			System.out.println("ReviewDaoImpl writeInfo getOnum -> " + review.getOnum());
		} catch (Exception e) {
			System.out.println("ReviewDaoImpl writeInfo Exception -> " + e.getMessage());
		}
		
		return review;
	}

}
