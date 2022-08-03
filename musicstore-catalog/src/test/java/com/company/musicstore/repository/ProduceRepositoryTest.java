package com.company.musicstore.repository;

import com.company.musicstore.model.Produce;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProduceRepositoryTest {

    @Autowired
    private ProduceRepository repo;

    @Before
    public void setUp() throws Exception {
        repo.deleteAll();
    }

    @Test
    public void shouldInteractWithProduceTableInDatabase() {
        // Arrange
        // make a fruit
        Produce produce = new Produce("apple", new BigDecimal("1.99"), 741);
        Produce expectedProduce = new Produce("apple", new BigDecimal("1.99"), 741);
        // Act
        repo.save(produce);
        expectedProduce.setId(produce.getId());

        // Assert
        assertEquals(expectedProduce, produce);

        // Act
        List<Produce> allTheProduce = repo.findAll();

        // Assert
        assertEquals(1, allTheProduce.size());

        // Act
        repo.deleteById(produce.getId());

        allTheProduce = repo.findAll();
        assertEquals(0, allTheProduce.size());
    }

}