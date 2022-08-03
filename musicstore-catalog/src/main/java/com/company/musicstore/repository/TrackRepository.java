package com.company.musicstore.repository;

import com.company.musicstore.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track,Integer> {
}
