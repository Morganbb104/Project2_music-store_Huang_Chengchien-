package com.company.musicstorerecommendations.repository;

import com.company.musicstorerecommendations.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRecommendationRepository extends JpaRepository<Artist,Integer>{


}
