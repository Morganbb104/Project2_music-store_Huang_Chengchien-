package com.company.musicstore.repository;

import com.company.musicstore.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist,Integer> {
}
