package com.jopsoft.task.persistance;

import javax.validation.Valid;
import java.util.List;

public interface WordsRepository {
    void add(@Valid String word);

    List<String> getAll();
}
