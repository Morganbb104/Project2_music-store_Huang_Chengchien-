package com.company.musicstorerecommendations.controller;

import com.company.musicstorerecommendations.model.Artist;
import com.company.musicstorerecommendations.repository.ArtistRecommendationRepository;
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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

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
@WebMvcTest(ArtistRecommendationController.class)
@AutoConfigureMockMvc(addFilters = false)
public class ArtistRecommendationControllerTest {
    @MockBean
    private ArtistRecommendationRepository repo;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
        setupArtistRepoMock();
    }

    private void setupArtistRepoMock(){
//            // Arrange
        Artist artist = new Artist(3,1,3,true);
        Artist artistWithoutId = new Artist(1,3,true);
        List<Artist> artists = Arrays.asList(artist);

        doReturn(artists).when(repo).findAll();
        doReturn(artist).when(repo).save(artistWithoutId);

    }

    @Test
    public void getAllArtistShouldReturnAListAnd200() throws Exception {
        // Arrange
        Artist artist = new Artist(3,1,3,true);
        List<Artist> ArtistList = Arrays.asList(artist);

        String expectedJsonValue = mapper.writeValueAsString(ArtistList);
        // Act
        mockMvc.perform(get("/artist"))
                .andDo(print())
                .andExpect(status().isOk())                 // Assert
                .andExpect(content().json(expectedJsonValue));
    }

    @Test
    public void createAlbumShouldReturnNewAlbumAndStatus201() throws Exception {
        // Arrange
        Artist artist = new Artist(3,1,3,true);
        List<Artist> artistList = Arrays.asList(artist);

        String expectedJsonValue = mapper.writeValueAsString(artistList);
        mockMvc.perform(get("/artist"))
                .andDo(print())
                .andExpect(status().isOk())                 // Assert
                .andExpect(content().json(expectedJsonValue));
    }

    @Test
    public void getArtistByIdShouldReturnStatus200() throws Exception {
        Artist outputArtist = new Artist(3,1,3,true);
        String outputArtistJson = mapper.writeValueAsString(outputArtist);
        doReturn(Optional.of(outputArtist)).when(repo).findById(1);
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/artist/1"))
                .andExpect(status().isOk())
                .andExpect((content().json(outputArtistJson)));
    }

    @Test
    public void updateArtistShouldReturnStatus200() throws Exception {
        Artist InputArtist = new Artist(3,1,3,true);
        String expectedArtistJson = mapper.writeValueAsString(InputArtist);
        mockMvc.perform(put("/artist/1")
                        .content(expectedArtistJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNoContent());
    }

    @Test
    public void deleteArtistByIdShouldReturnStatus204() throws Exception {
        mockMvc.perform(delete("/artist/2"))
                .andDo(print())          // Assert
                .andExpect(status().isNoContent());  // Assert


    }

}