package com.company.musicstore.repository;

import com.company.musicstore.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album,Integer> {
}
