package com.company.musicstore.controller;



import com.company.musicstore.model.Track;
import com.company.musicstore.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrackController {

    @Autowired
    private TrackRepository repo;

    @GetMapping("/track")
    @ResponseStatus(HttpStatus.OK)
    public List<Track> getAllTrack() {
        return repo.findAll();
    }



}
