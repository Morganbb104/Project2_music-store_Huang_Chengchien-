package com.company.musicstorerecommendations.repository;

import com.company.musicstorerecommendations.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRecommendationRepository extends JpaRepository<Artist,Integer>{
}
