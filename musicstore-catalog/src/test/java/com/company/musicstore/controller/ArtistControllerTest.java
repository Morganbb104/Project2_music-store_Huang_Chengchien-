package com.company.musicstore.controller;


import com.company.musicstore.model.Album;
import com.company.musicstore.model.Artist;
import com.company.musicstore.repository.ArtistRepository;
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
@WebMvcTest(ArtistController.class)
@AutoConfigureMockMvc(addFilters = false)
public class ArtistControllerTest {
    @MockBean
    private ArtistRepository repo;

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
            Artist cheng = new Artist(1,"Mike","@Mike", "@Mike");
            Artist chengWithoutId = new Artist("Mike","@Mike", "@Mike");
            List<Artist> artists = Arrays.asList(cheng);

            doReturn(artists).when(repo).findAll();
            doReturn(cheng).when(repo).save(chengWithoutId);

}

    @Test
    public void getAllArtistShouldReturnAListAnd200() throws Exception {
        // Arrange
        Artist artist = new Artist(1,"Mike","@Mike", "@Mike");
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
        Artist artist = new Artist(1,"Mike","@Mike", "@Mike");
        List<Artist> artistList = Arrays.asList(artist);

        String expectedJsonValue = mapper.writeValueAsString(artistList);
        mockMvc.perform(get("/artist"))
                .andDo(print())
                .andExpect(status().isOk())                 // Assert
                .andExpect(content().json(expectedJsonValue));
    }


    @Test
    public void getArtistByIdShouldReturnStatus200() throws Exception {
        Artist outputArtist = new Artist(1,"Mike","@Mike", "@Mike");
        String outputArtistJson = mapper.writeValueAsString(outputArtist);
        doReturn(Optional.of(outputArtist)).when(repo).findById(1);
        mockMvc.perform(get("/Artist/1"))
                .andExpect(status().isOk())
                .andExpect((content().json(outputArtistJson)));
    }

    @Test
    public void updateArtistShouldReturnStatus200() throws Exception {
        Artist InputArtist = new Artist(1,"Mike","@Mike", "@Mike");
        String expectedArtistJson = mapper.writeValueAsString(InputArtist);
        mockMvc.perform(put("/artist/1")
                        .content(expectedArtistJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNoContent());
    }

    @Test
    public void DeleteArtistByIdShouldReturnStatus204() throws Exception {
        mockMvc.perform(delete("/artist/2"))
                .andDo(print())          // Assert
                .andExpect(status().isNoContent());  // Assert


    }


    }