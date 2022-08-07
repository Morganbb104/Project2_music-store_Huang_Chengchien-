package com.company.musicstorerecommendations.repository;

import com.company.musicstorerecommendations.model.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelRecommendationRepository extends JpaRepository<Label,Integer> {


}
