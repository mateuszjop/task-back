package com.jopsoft.task.persistance;

import com.jopsoft.task.web.model.Review;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Repository
public class ReviewsRepositoryImpl implements ReviewsRepository {

    private List<Review> reviews = new LinkedList<>();

    @Override
    public void save(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public List<Review> getAll() {
       return Collections.unmodifiableList(reviews);
    }

    @Override
    public void add(Review review) {
        reviews.add(review);
    }

}
