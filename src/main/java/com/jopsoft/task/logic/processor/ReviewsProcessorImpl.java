package com.jopsoft.task.logic.processor;

import com.jopsoft.task.persistance.ReviewsRepository;
import com.jopsoft.task.persistance.WordsRepository;
import com.jopsoft.task.web.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ReviewsProcessorImpl implements ReviewsProcessor, Observer {

    @Autowired
    private ReviewsRepository reviewsRepository;

    @Autowired
    private WordsRepository wordsRepository;

    @Override
    public void notifyObserver() {
        List<Review> reviews = reviewsRepository.getAll();
        List<Review> processedReveiws = process(reviews);
        reviewsRepository.save(processedReveiws);
    }

    private List<Review> process(List<Review> reviews) {
        Map<Integer, List<Review>> wordCounts = new TreeMap<>(Comparator.reverseOrder()); //TODO MJ use sorted map
        List<String> goodWords = wordsRepository.getAll();

        int goodWordsCounter = 0;

        for(Review review : reviews) {
            String[] reviewWords = review.getContent().split(" ");

            for(String reviewWord : reviewWords) {
                for(String goodWord : goodWords) {
                    if(reviewWord.contains(goodWord)) {
                        goodWordsCounter++;
                    }
                }
            }

            if(wordCounts.get(goodWordsCounter) == null) {
                wordCounts.put(goodWordsCounter, new LinkedList<>());
            }

            wordCounts.get(goodWordsCounter).add(review);

            goodWordsCounter = 0;
        }

        List<Review> result = new LinkedList<>();
        for(List<Review> value : wordCounts.values()) {
            result.addAll(value);
        }

        return result;
    }
}
