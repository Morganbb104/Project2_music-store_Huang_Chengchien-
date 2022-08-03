package com.company.musicstore.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.company.musicstore.model.Produce;
import com.company.musicstore.service.ProduceService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProduceController.class)
public class ProduceControllerTest {

    @MockBean
    private ProduceService service;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
        setupProduceServiceMock();
    }

    private void setupProduceServiceMock() {
        Produce orange = new Produce(121L, "orange", new BigDecimal("1.19"), 250);
        Produce orangeWithoutId = new Produce("orange", new BigDecimal("1.19"), 250);
        List<Produce> produceList = Arrays.asList(orange);

        doReturn(produceList).when(service).getAllProduce();
        doReturn(orange).when(service).addProduce(orangeWithoutId);
//        when(service.getAllProduce()).thenReturn(produceList);
    }

    @Test
    public void getAllProduceShouldReturnAListAnd200() throws Exception {
        // Arrange
        Produce orange = new Produce(121L, "orange", new BigDecimal("1.19"), 250);
        List<Produce> produceList = Arrays.asList(orange);

        String expectedJsonValue = mapper.writeValueAsString(produceList);
        // Act
        mockMvc.perform(get("/produce"))
                .andDo(print())
                .andExpect(status().isOk())                 // Assert
                .andExpect(content().json(expectedJsonValue));
    }

    @Test
    public void createProduceShouldReturnNewProduceAndStatus201() throws Exception {
        // Arrange
        Produce outputProduce = new Produce(121L, "orange", new BigDecimal("1.19"), 250);
        Produce inputProduce = new Produce("orange", new BigDecimal("1.19"), 250);

        String outputProduceJson = mapper.writeValueAsString(outputProduce);
        String inputProduceJson = mapper.writeValueAsString(inputProduce);

        // Act
        mockMvc.perform(post("/produce")
                .contentType(MediaType.APPLICATION_JSON)
                .content(inputProduceJson))
                .andDo(print())
                .andExpect(status().isCreated())            // Assert
                .andExpect(content().json(outputProduceJson));  // Assert
    }


}
