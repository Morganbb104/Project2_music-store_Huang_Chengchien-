package com.company.musicstorerecommendations.controller;

import com.company.musicstorerecommendations.model.Artist;
import com.company.musicstorerecommendations.repository.ArtistRecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ArtistRecommendationController {
    @Autowired
    private ArtistRecommendationRepository repo;
    @GetMapping("/artist")
    @ResponseStatus(HttpStatus.OK)
    public List<Artist> getAllLabel() {
        return repo.findAll();
    }

    @GetMapping("/artist/{id}")
    public Artist getArtistById(@PathVariable int id) {
        Optional<Artist> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @PutMapping("/artist/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateArtist(@RequestBody Artist artist) {
        repo.save(artist);
    }

    @PostMapping(value="/artist")
    @ResponseStatus(HttpStatus.CREATED)
    public Artist createArtist(@RequestBody Artist artist) {
        return repo.save(artist);
    }

    @DeleteMapping("artist/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeArtist(@PathVariable int id) {
        repo.deleteById(id);
    }

}
