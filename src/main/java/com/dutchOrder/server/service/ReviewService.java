package com.dutchOrder.server.service;

import java.util.List;

import com.dutchOrder.server.model.OrderInfo;
import com.dutchOrder.server.model.Review;

public interface ReviewService {

	List<Review> listReview(int mnum);

	Review commentReview(int rnum);

	int writeComment(Review review);

	List<OrderInfo> clListReview(int mnum);

	Review reviewMy(int rnum);

	int writeReview(Review review);

	Review infoWrite(int onum);

}
