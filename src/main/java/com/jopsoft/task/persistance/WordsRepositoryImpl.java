package com.jopsoft.task.persistance;

import org.springframework.stereotype.Repository;

import javax.validation.Valid;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Repository
public class WordsRepositoryImpl implements WordsRepository {

    private List<String> words = new LinkedList<>();

    @Override
    public void add(@Valid String word) {
       words.add(word);
    }

    @Override
    public List<String> getAll() {
        return Collections.unmodifiableList(words);
    }
}
