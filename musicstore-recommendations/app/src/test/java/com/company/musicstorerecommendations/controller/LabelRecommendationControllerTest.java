package com.company.musicstorerecommendations.controller;

import com.company.musicstorerecommendations.model.Label;
import com.company.musicstorerecommendations.repository.LabelRecommendationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(LabelRecommendationController.class)
@AutoConfigureMockMvc(addFilters = false)
public class LabelRecommendationControllerTest {

    @MockBean
    private LabelRecommendationRepository repo;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper = new ObjectMapper();


    @Before
    public void setUp() throws Exception {
        setupLabelRepoMock();
    }

    private void setupLabelRepoMock() {
        Label label = new Label(1,1,1,true);
        Label labelWithoutId = new Label(1,1,true);
        List<Label> labelList = Arrays.asList(label);

        doReturn(labelList).when(repo).findAll();
        doReturn(label).when(repo).save(labelWithoutId);
//        when(service.getAllProduce()).thenReturn(produceList);
    }

    @Test
    public void getAllLabelShouldReturnAListAnd200() throws Exception {
        // Arrange
        Label label = new Label(1,1,1,true);
        List<Label> labelList = Arrays.asList(label);

        String expectedJsonValue = mapper.writeValueAsString(labelList);
        // Act
        mockMvc.perform(get("/label"))
                .andDo(print())
                .andExpect(status().isOk())                 // Assert
                .andExpect(content().json(expectedJsonValue));
    }

    @Test
    public void createLabelShouldReturnNewLabelAndStatus201() throws Exception {
        // Arrange
        Label outputLabel = new Label(1,1,1,true);
        Label inputLabel = new Label(1,1,true);

        String outputLabelJson = mapper.writeValueAsString(outputLabel);
        String inputLabelJson = mapper.writeValueAsString(inputLabel);

        // Act
        mockMvc.perform(post("/label")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(inputLabelJson))
                .andDo(print())
                .andExpect(status().isCreated())            // Assert
                .andExpect(content().json(outputLabelJson));  // Assert
    }

    @Test
    public void getLabelByIdShouldReturnStatus200() throws Exception {
        Label outputLabel = new Label(1,1,1,true);
        String outputLabelJson = mapper.writeValueAsString(outputLabel);
        doReturn(Optional.of(outputLabel)).when(repo).findById(1);
        mockMvc.perform(get("/label/1"))
                .andExpect(status().isOk())
                .andExpect((content().json(outputLabelJson)));
    }


    @Test
    public void updateLabelShouldReturnStatus200() throws Exception {
        Label InputLabel = new Label(1,1,1,true);
        String expectedLabelJson = mapper.writeValueAsString(InputLabel);
        mockMvc.perform(put("/label/1")
                        .content(expectedLabelJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNoContent());
    }


    @Test
    public void DeleteLabelByIdShouldReturnStatus204() throws Exception {
        mockMvc.perform(delete("/label/2"))
                .andDo(print())          // Assert
                .andExpect(status().isNoContent());  // Assert


    }
}