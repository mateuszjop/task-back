package com.jopsoft.task.web;

import com.jopsoft.task.logic.ReviewsService;
import com.jopsoft.task.web.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@CrossOrigin
@RestController
@RequestMapping("/review")
public class ReviewsController {

    @Autowired
    private ReviewsService reviewsService;

    private final AtomicLong counter = new AtomicLong();

    @PostMapping
    public HttpStatus addReview(@Valid @RequestBody Review review) {
        reviewsService.add(review);

        return HttpStatus.OK;
    }

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewsService.getAll();
    }


}
