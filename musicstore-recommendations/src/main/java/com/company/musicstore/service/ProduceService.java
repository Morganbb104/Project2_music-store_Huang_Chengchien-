package com.company.musicstore.service;

import com.company.musicstore.repository.ProduceRepository;
import com.company.musicstore.model.Produce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduceService {
    private ProduceRepository repo;

    @Autowired
    public ProduceService(ProduceRepository repo) {
        this.repo = repo;
    }

    public Produce addProduce(Produce produce) {
        if (produce.getQuantityInStock() <= 0) {
            return null;
        } else {
            return repo.save(produce);
        }
    }

    public List<Produce> getAllProduce() {
        return repo.findAll();
    }

}
