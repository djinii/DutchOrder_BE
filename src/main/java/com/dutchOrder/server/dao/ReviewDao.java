package com.dutchOrder.server.dao;

import java.util.List;

import com.dutchOrder.server.model.OrderInfo;
import com.dutchOrder.server.model.Review;

public interface ReviewDao {

	List<Review> listReview(int mnum);

	Review reviewComment(int rnum);

	int writeComment(Review review);

	List<OrderInfo> clListReview(int mnum);

	Review reviewMy(int rnum);

	int writeReview(Review review);

	Review writeInfo(int onum);

}
