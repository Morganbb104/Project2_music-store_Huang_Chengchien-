package com.company.musicstore.controller;

import com.company.musicstore.model.Album;
import com.company.musicstore.model.Label;
import com.company.musicstore.repository.AlbumRepository;
import com.company.musicstore.repository.LabelRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(LabelController.class)
@AutoConfigureMockMvc(addFilters = false)
public class LabelControllerTest {

    @MockBean
    private LabelRepository repo;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
        setupLabelRepoMock();
    }

    private void setupLabelRepoMock() {
        Label label = new Label(1,"Cheng", "www.cheng.com");
        Label labelWithoutId = new Label("Cheng", "www.cheng.com");
        List<Label> labelList = Arrays.asList(label);

        doReturn(labelList).when(repo).findAll();
        doReturn(label).when(repo).save(labelWithoutId);
//        when(service.getAllProduce()).thenReturn(produceList);
    }

    @Test
    public void getAllLabelShouldReturnAListAnd200() throws Exception {
        // Arrange
        Label label = new Label(1,"Cheng","www.cheng.com");
        List<Label> labelList = Arrays.asList(label);

        String expectedJsonValue = mapper.writeValueAsString(labelList);
        // Act
        mockMvc.perform(get("/label"))
                .andDo(print())
                .andExpect(status().isOk())                 // Assert
                .andExpect(content().json(expectedJsonValue));
    }

}