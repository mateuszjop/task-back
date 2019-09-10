package com.jopsoft.task.logic;

import com.jopsoft.task.web.model.Review;

import javax.validation.Valid;
import java.util.List;

public interface WordsService {
    void add(@Valid String word);

    List<String> getAll();
}
