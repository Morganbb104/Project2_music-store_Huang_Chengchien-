package com.company.musicstore.controller;

import com.company.musicstore.model.Album;
import com.company.musicstore.model.Track;
import com.company.musicstore.repository.AlbumRepository;
import com.company.musicstore.repository.TrackRepository;
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
@WebMvcTest(TrackController.class)
@AutoConfigureMockMvc(addFilters = false)
public class TrackControllerTest {
    @MockBean
    private TrackRepository repo;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
        setupTrackRepoMock();
    }

    private void setupTrackRepoMock() {
        Track track = new Track(1,1,"Fairy Tale",120);
        Track trackWithoutId = new Track(1,"Fairy Tale",120);
        List<Track> trackList = Arrays.asList(track);

        doReturn(trackList).when(repo).findAll();
        doReturn(track).when(repo).save(trackWithoutId);
//        when(service.getAllProduce()).thenReturn(produceList);
    }

    @Test
    public void getAllTrackShouldReturnAListAnd200() throws Exception {
        // Arrange
        Track orange = new Track(1,1,"Fairy Tale",120);
        List<Track> trackList = Arrays.asList(orange);

        String expectedJsonValue = mapper.writeValueAsString(trackList);
        // Act
        mockMvc.perform(get("/track"))
                .andDo(print())
                .andExpect(status().isOk())                 // Assert
                .andExpect(content().json(expectedJsonValue));
    }

    @Test
    public void createTrackShouldReturnNewTrackAndStatus201() throws Exception {
        // Arrange
        Track outputTrack = new Track(1,1,"Fairy Tale",120);
        Track inputTrack = new Track(1,"Fairy Tale",120);

        String outputTrackJson = mapper.writeValueAsString(outputTrack);
        String inputTrackJson = mapper.writeValueAsString(inputTrack);

        // Act
        mockMvc.perform(post("/track")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(inputTrackJson))
                .andDo(print())
                .andExpect(status().isCreated())            // Assert
                .andExpect(content().json(outputTrackJson));  // Assert
    }

    @Test
    public void getTrackByIdShouldReturnStatus200() throws Exception {
        Track outputTrack = new Track(1,1,"Fairy Tale",120);
        String outputTrackJson = mapper.writeValueAsString(outputTrack);
        doReturn(Optional.of(outputTrack)).when(repo).findById(1);
        mockMvc.perform(get("/track/1"))
                .andExpect(status().isOk())
                .andExpect((content().json(outputTrackJson)));
    }
    @Test
    public void updateTrackShouldReturnStatus200() throws Exception {
        Track InputTrack = new Track(1,1,"Fairy Tale",120);
        String expectedTrackJson = mapper.writeValueAsString(InputTrack);
        mockMvc.perform(put("/track/1")
                        .content(expectedTrackJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNoContent());
    }

    @Test
    public void DeleteTrackByIdShouldReturnStatus204() throws Exception {
        mockMvc.perform(delete("/track/2"))
                .andDo(print())          // Assert
                .andExpect(status().isNoContent());  // Assert


    }


}