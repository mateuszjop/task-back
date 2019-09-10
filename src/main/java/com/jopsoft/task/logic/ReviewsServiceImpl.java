package com.jopsoft.task.logic;

import com.jopsoft.task.logic.processor.Observer;
import com.jopsoft.task.persistance.ReviewsRepository;
import com.jopsoft.task.web.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsServiceImpl implements ReviewsService {

    @Autowired
    private Observer reviewsProcessor;

    @Autowired
    private ReviewsRepository reviewsRepository;

    @Override
    public void add(Review review) {
        reviewsRepository.add(review);
        reviewsProcessor.notifyObserver();
    }

    @Override
    public List<Review> getAll() {
       return reviewsRepository.getAll();
    }
}
