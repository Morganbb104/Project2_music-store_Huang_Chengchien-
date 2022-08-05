package com.company.musicstorerecommendations.repository;

import com.company.musicstorerecommendations.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRecommendationRepository extends JpaRepository<Track,Integer> {


}
