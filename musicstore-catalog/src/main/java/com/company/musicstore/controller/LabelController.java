package com.company.musicstore.controller;


import com.company.musicstore.model.Label;
import com.company.musicstore.model.Produce;
import com.company.musicstore.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LabelController {
    @Autowired
    private LabelRepository repo;
    @GetMapping("/label")
    @ResponseStatus(HttpStatus.OK)
    public List<Label> getAllLabel() {
        return repo.findAll();
    }

}
