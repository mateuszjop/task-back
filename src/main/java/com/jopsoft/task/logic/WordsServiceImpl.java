package com.jopsoft.task.logic;

import com.jopsoft.task.logic.processor.Observer;
import com.jopsoft.task.persistance.WordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class WordsServiceImpl implements WordsService {

    @Autowired
    private WordsRepository wordsRepository;

    @Autowired
    private Observer reviewsProcessor;

    @Override
    public void add(@Valid String word) {
        wordsRepository.add(word);
        reviewsProcessor.notifyObserver();
    }

    @Override
    public List<String> getAll() {
        return wordsRepository.getAll();
    }
}
