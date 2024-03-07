package com.dutchOrder.server.dao;

import java.util.List;

import com.dutchOrder.server.model.OrderInfo;
import com.dutchOrder.server.model.Review;

public interface ReviewDao {

	List<Review> listReview(Review review);

	Review reviewComment(int rnum);

	int writeComment(Review review);

	List<OrderInfo> clListReview(OrderInfo orderInfo);

	Review reviewMy(int rnum);

	int writeReview(Review review);

	Review writeInfo(int onum);

}
