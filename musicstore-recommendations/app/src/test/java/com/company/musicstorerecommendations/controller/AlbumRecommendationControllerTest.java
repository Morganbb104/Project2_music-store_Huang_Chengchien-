package com.company.musicstorerecommendations.controller;

import com.company.musicstorerecommendations.model.Album;
import com.company.musicstorerecommendations.repository.AlbumRecommendationRepository;
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

import java.math.BigDecimal;
import java.time.LocalDate;
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
@WebMvcTest(AlbumRecommendationController.class)
@AutoConfigureMockMvc(addFilters = false)
public class AlbumRecommendationControllerTest {

    @MockBean
    private AlbumRecommendationRepository repo;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
        setupAlbumRepoMock();
    }

    private void setupAlbumRepoMock() {
        Album album = new Album(1,1,1,true);
        Album albumWithoutId = new Album(1,1,true);
        List<Album> albumList = Arrays.asList(album );

        doReturn(albumList).when(repo).findAll();
        doReturn(album ).when(repo).save(albumWithoutId);
//        when(service.getAllProduce()).thenReturn(produceList);
    }

    @Test
    public void getAllAlbumShouldReturnAListAnd200() throws Exception {
        // Arrange
        Album album = new Album(1,1,1,true);
        List<Album> albumList = Arrays.asList(album);

        String expectedJsonValue = mapper.writeValueAsString(albumList);
        // Act
        mockMvc.perform(get("/album"))
                .andDo(print())
                .andExpect(status().isOk())                 // Assert
                .andExpect(content().json(expectedJsonValue));
    }

    @Test
    public void createAlbumShouldReturnNewAlbumAndStatus201() throws Exception {
        // Arrange
        Album outputAlbum = new Album(1,1,1,true);
        Album inputAlbum = new Album(1,1,true);

        String outputAlbumJson = mapper.writeValueAsString(outputAlbum);
        String inputAlbumJson = mapper.writeValueAsString(inputAlbum);

        // Act
        mockMvc.perform(post("/album")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(inputAlbumJson))
                .andDo(print())
                .andExpect(status().isCreated())            // Assert
                .andExpect(content().json(outputAlbumJson));  // Assert
    }

    @Test
    public void getAlbumByIdShouldReturnStatus200() throws Exception {
        Album outputAlbum = new Album(1,1,1,true);
        String outputAlbumJson = mapper.writeValueAsString(outputAlbum);
        doReturn(Optional.of(outputAlbum)).when(repo).findById(1);
        mockMvc.perform(get("/album/1"))
                .andExpect(status().isOk())
                .andExpect((content().json(outputAlbumJson)));
    }

    @Test
    public void updateAlbumShouldReturnStatus200() throws Exception {
        Album InputAlbum = new Album(1,1,1,true);
        String expectedAlbumJson = mapper.writeValueAsString(InputAlbum);
        mockMvc.perform(put("/album/1")
                        .content(expectedAlbumJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNoContent());
    }

    @Test
    public void deleteAlbumByIdShouldReturnStatus204() throws Exception {
        mockMvc.perform(delete("/album/2"))
                .andDo(print())          // Assert
                .andExpect(status().isNoContent());  // Assert


    }
}