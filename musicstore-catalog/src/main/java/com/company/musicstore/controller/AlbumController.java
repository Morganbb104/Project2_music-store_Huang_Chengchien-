package com.company.musicstore.controller;

import com.company.musicstore.model.Album;
import com.company.musicstore.model.Label;
import com.company.musicstore.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AlbumController {

    @Autowired
    private AlbumRepository repo;
    @GetMapping("/album")
    @ResponseStatus(HttpStatus.OK)
    public List<Album> getAllAlbum() {
        return repo.findAll();
    }

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
