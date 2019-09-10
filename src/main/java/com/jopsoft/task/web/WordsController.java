package com.jopsoft.task.web;

import com.jopsoft.task.logic.WordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/word")
public class WordsController {

    @Autowired
    private WordsService wordsService;

    @PostMapping
    public HttpStatus addReview(@Valid @RequestBody String word) {
        wordsService.add(word);

        return HttpStatus.OK;
    }

    @GetMapping
    public List<String> getAllReviews() {
        return wordsService.getAll();
    }

}
