package com.dutchOrder.server.service;

import java.util.List;

import com.dutchOrder.server.model.OrderInfo;
import com.dutchOrder.server.model.Review;

public interface ReviewService {

	List<Review> listReview(Review review);

	Review commentReview(int rnum);

	int writeComment(Review review);

	List<OrderInfo> clListReview(OrderInfo orderInfo);

	Review reviewMy(int rnum);

	int writeReview(Review review);

	Review infoWrite(int onum);

}
