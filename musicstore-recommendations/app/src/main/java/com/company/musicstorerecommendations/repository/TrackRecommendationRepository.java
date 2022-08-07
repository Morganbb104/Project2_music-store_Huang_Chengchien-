package com.company.musicstorerecommendations.repository;

import com.company.musicstorerecommendations.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRecommendationRepository extends JpaRepository<Track, Integer> {


}
