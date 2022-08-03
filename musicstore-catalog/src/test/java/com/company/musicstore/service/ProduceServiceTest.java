package com.company.musicstore.service;

import com.company.musicstore.model.Produce;
import com.company.musicstore.repository.ProduceRepository;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ProduceServiceTest {

    private ProduceService service;
    private ProduceRepository repo;
    @Before
    public void setUp() {
        setUpProduceRepositoryMock();

        this.service = new ProduceService(repo);
    }

    private void setUpProduceRepositoryMock() {
        this.repo = mock(ProduceRepository.class);

        Produce produceIn = new Produce("banana", new BigDecimal("0.99"), 100);
        Produce produceOut = new Produce(65L, "banana", new BigDecimal("0.99"), 100);
        Produce produceWithZeroQuantity = new  Produce("kumquat", new BigDecimal("2.29"), 0);
        Produce produceWithZeroQuantityWithId = new  Produce(77L, "kumquat", new BigDecimal("2.29"), 0);
        Produce produceWithTenQuantity = new  Produce("kumquat", new BigDecimal("2.29"), 10);
        Produce produceWithTenQuantityWithId = new  Produce(77L, "kumquat", new BigDecimal("2.29"), 10);


        List<Produce> produceList = Arrays.asList(produceOut);

        Optional<Produce> findByIdResult = Optional.of(produceOut);

        doReturn(produceOut).when(repo).save(produceIn);
        doReturn(produceWithZeroQuantityWithId).when(repo).save(produceWithZeroQuantity);
        doReturn(produceWithTenQuantityWithId).when(repo).save(produceWithTenQuantity);
        doReturn(produceList).when(repo).findAll();
        doReturn(findByIdResult).when(repo).findById(65L);
    }

    @Test
    public void addProduceShouldReturnProduceWithIdWhenSaving() {
        // Arrange
        Produce produceToSave = new Produce("banana", new BigDecimal("0.99"), 100);
        Produce expectedResult = new Produce(65L, "banana", new BigDecimal("0.99"), 100);

        // Act
        Produce actualResult = service.addProduce(produceToSave);

        // Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void addProduceShouldReturnNullWhenSavingProduceWithQuantityZero() {
        // Arrange
        Produce produceToSave = new Produce("kumquat", new BigDecimal("2.29"), 0);
        Produce expectedResult = null;

        // Act
        Produce actualResult = service.addProduce(produceToSave);

        // Assert
//        assertNull(actualResult);
        assertEquals(null, actualResult);
    }

    @Test
    public void getAllProduceShouldReturnAListOfProduce() {
        // Arrange - nothing
        // Act
        List<Produce> actualResult = service.getAllProduce();

        // Assert - the mock result of findAll has one object in it
        assertEquals(1, actualResult.size());
    }
}