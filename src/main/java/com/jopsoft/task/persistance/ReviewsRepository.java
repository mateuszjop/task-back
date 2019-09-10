package com.jopsoft.task.persistance;

import com.jopsoft.task.web.model.Review;

import java.util.List;

public interface ReviewsRepository {

    void save(List<Review> reviews);

    List<Review> getAll();

    void add(Review review);
}
