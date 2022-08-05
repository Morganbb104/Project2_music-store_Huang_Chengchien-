package com.company.musicstorerecommendations.repository;

import com.company.musicstorerecommendations.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRecommendationRepository extends  JpaRepository<Album,Integer>{
}
