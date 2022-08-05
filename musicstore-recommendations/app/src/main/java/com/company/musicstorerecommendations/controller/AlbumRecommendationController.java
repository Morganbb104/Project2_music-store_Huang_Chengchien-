package com.company.musicstorerecommendations.controller;

import com.company.musicstorerecommendations.model.Album;
import com.company.musicstorerecommendations.repository.AlbumRecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AlbumRecommendationController {

    @Autowired
    private AlbumRecommendationRepository repo;
    @GetMapping("/album")
    @ResponseStatus(HttpStatus.OK)
    public List<Album> getAllAlbum(){return repo.findAll();}


    @GetMapping("/album/{id}")
    public Album getAlbumById(@PathVariable int id) {
        Optional<Album> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @PutMapping("/album/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAlbum(@RequestBody Album album) {
        repo.save(album);
    }

    @PostMapping(value="/album")
    @ResponseStatus(HttpStatus.CREATED)
    public Album createAlbum(@RequestBody Album album) {
        return repo.save(album);
    }

    @DeleteMapping("album/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAlbum(@PathVariable int id) {
        repo.deleteById(id);
    }

}
