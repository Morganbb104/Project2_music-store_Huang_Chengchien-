package com.company.musicstore.repository;

import com.company.musicstore.model.Label;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelRepository extends JpaRepository<Label,Integer> {
}
