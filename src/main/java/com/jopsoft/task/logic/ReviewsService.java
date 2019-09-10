package com.jopsoft.task.logic;

import com.jopsoft.task.web.model.Review;

import java.util.List;

public interface ReviewsService {

    void add(Review review);

    List<Review> getAll();

}
