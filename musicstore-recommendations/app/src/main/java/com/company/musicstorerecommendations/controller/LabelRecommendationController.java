package com.company.musicstorerecommendations.controller;

import com.company.musicstorerecommendations.model.Label;
import com.company.musicstorerecommendations.repository.LabelRecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LabelRecommendationController {
    @Autowired
    private LabelRecommendationRepository repo;
    @GetMapping("/label")
    @ResponseStatus(HttpStatus.OK)
    public List<Label> getAllLabel() {
        return repo.findAll();
    }

    @GetMapping("/label/{id}")
    public Label getLabelById(@PathVariable int id) {
        Optional<Label> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @PutMapping("/label/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateLabel(@RequestBody Label label) {
        repo.save(label);
    }

    @PostMapping(value="/label")
    @ResponseStatus(HttpStatus.CREATED)
    public Label createLabel(@RequestBody Label label) {
        return repo.save(label);
    }

    @DeleteMapping("label/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeLabel(@PathVariable int id) {
        repo.deleteById(id);
    }

}
