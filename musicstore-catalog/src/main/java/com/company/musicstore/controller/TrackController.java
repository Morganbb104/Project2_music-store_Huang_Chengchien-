package com.company.musicstore.controller;



import com.company.musicstore.model.Album;
import com.company.musicstore.model.Track;
import com.company.musicstore.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TrackController {

    @Autowired
    private TrackRepository repo;

    @GetMapping("/track")
    @ResponseStatus(HttpStatus.OK)
    public List<Track> getAllTrack() {
        return repo.findAll();
    }

    @GetMapping("/track/{id}")
    public Track getTrackById(@PathVariable int id) {
        Optional<Track> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @PutMapping("/track/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTrack(@RequestBody Track track) {
        repo.save(track);
    }

    @PostMapping(value="/track")
    @ResponseStatus(HttpStatus.CREATED)
    public Track createTrack(@RequestBody Track track) {
        return repo.save(track);
    }

    @DeleteMapping("track/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeTrack(@PathVariable int id) {
        repo.deleteById(id);
    }




}
