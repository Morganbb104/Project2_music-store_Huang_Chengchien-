package com.company.musicstore.controller;

import com.company.musicstore.model.Produce;
import com.company.musicstore.service.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProduceController {
    @Autowired
    private ProduceService service;

    @GetMapping(value="/produce")
    @ResponseStatus(HttpStatus.OK)
    public List<Produce> getAllProduce() {
        return service.getAllProduce();
    }

    @PostMapping(value="/produce")
    @ResponseStatus(HttpStatus.CREATED)
    public Produce createProduce(@RequestBody Produce produce) {
        return service.addProduce(produce);
    }
}
