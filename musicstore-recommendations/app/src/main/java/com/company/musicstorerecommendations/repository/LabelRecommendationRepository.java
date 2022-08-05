package com.company.musicstorerecommendations.repository;

import com.company.musicstorerecommendations.model.Label;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelRecommendationRepository extends JpaRepository<Label,Integer> {


}
