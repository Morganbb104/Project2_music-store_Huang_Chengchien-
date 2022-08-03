package com.myshoppe.fruitstand.repository;

import com.myshoppe.fruitstand.model.Produce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduceRepository extends JpaRepository<Produce, Long> {
}
