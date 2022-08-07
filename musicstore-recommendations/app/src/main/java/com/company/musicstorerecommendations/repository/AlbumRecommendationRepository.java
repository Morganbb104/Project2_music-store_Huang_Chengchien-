package com.company.musicstorerecommendations.repository;

import com.company.musicstorerecommendations.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRecommendationRepository extends  JpaRepository<Album,Integer>{


}
