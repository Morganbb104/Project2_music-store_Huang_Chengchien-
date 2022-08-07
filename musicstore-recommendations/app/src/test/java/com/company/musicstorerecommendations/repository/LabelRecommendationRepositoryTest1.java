package com.company.musicstorerecommendations.repository;

import com.company.musicstorerecommendations.model.Album;
import com.company.musicstorerecommendations.model.Artist;
import com.company.musicstorerecommendations.model.Label;
import com.company.musicstorerecommendations.model.Track;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LabelRecommendationRepositoryTest1 {
    @Autowired
    AlbumRecommendationRepository albumRecommendationRepo;

    @Autowired
    ArtistRecommendationRepository artistRecommendationRepo;
    @Autowired
    LabelRecommendationRepository labelRecommendationRepo;

    @Autowired
    TrackRecommendationRepository trackRecommendationRepo;

    @Before
    public void setUp() throws Exception {
        albumRecommendationRepo.deleteAll();
        trackRecommendationRepo.deleteAll();
        artistRecommendationRepo.deleteAll();
        labelRecommendationRepo.deleteAll();

    }
    @Test
    public void getAllLabelRecommendations() {
        albumRecommendationRepo.deleteAll();
        trackRecommendationRepo.deleteAll();
        artistRecommendationRepo.deleteAll();
        labelRecommendationRepo.deleteAll();
        Label labelRecommendation1 = labelRecommendationRepo.save(new Label(1,1,true));
        Label labelRecommendation2 = labelRecommendationRepo.save(new Label(1,2,true));
        labelRecommendationRepo.save(labelRecommendation1);
        labelRecommendationRepo.save(labelRecommendation2);
        Artist artistRecommendation1 = artistRecommendationRepo.save(new Artist(1,1,true));
        Artist artistRecommendation2 = artistRecommendationRepo.save(new Artist(1,2,true));
        artistRecommendationRepo.save(artistRecommendation1);
        artistRecommendationRepo.save(artistRecommendation2);
        Album albumRecommendation1 = albumRecommendationRepo.save(new Album(1, 1, 1, true));
        Album albumRecommendation2 = albumRecommendationRepo.save(new Album(2, 2, 2, true));
        albumRecommendationRepo.save(albumRecommendation1);
        albumRecommendationRepo.save(albumRecommendation2);
        List<Label> aList = labelRecommendationRepo.findAll();
        assertEquals(aList.size(), 2);
    }

    @Test
    public void addGetDeleteLabel(){
        Label labelRecommendation1 = labelRecommendationRepo.save(new Label(1,1,true));
        Label labelRecommendation2 = labelRecommendationRepo.save(new Label(1,2,true));
        labelRecommendationRepo.save(labelRecommendation1);
        labelRecommendationRepo.save(labelRecommendation2);
        Artist artistRecommendation1 = artistRecommendationRepo.save(new Artist(1,1,true));
        Artist artistRecommendation2 = artistRecommendationRepo.save(new Artist(1,2,true));
        artistRecommendationRepo.save(artistRecommendation1);
        artistRecommendationRepo.save(artistRecommendation2);
        Album albumRecommendation1 = albumRecommendationRepo.save(new Album(1, 1, 1, true));
        Album albumRecommendation2 = albumRecommendationRepo.save(new Album(2, 2, 2, true));
        albumRecommendationRepo.save(albumRecommendation1);
        albumRecommendationRepo.save(albumRecommendation2);
        Track trackRecommendation1 =trackRecommendationRepo.save(new Track(1,1,true));
        Track trackRecommendation2 =trackRecommendationRepo.save(new Track(1,2,true));

        labelRecommendation1 = labelRecommendationRepo.save(labelRecommendation1);

        Optional<Label> label1 = labelRecommendationRepo.findById(labelRecommendation1.getId());

        Assert.assertEquals(label1.get(), labelRecommendation1);

        labelRecommendationRepo.deleteById(labelRecommendation1.getId());

        label1 = labelRecommendationRepo.findById(labelRecommendation1.getId());

        assertFalse(label1.isPresent());
    }

    @Test
    public void updateAnLabel() {
        Label labelRecommendation1 = labelRecommendationRepo.save(new Label(1, 1, true));
        Label labelRecommendation2 = labelRecommendationRepo.save(new Label(1, 2, true));
        labelRecommendationRepo.save(labelRecommendation1);
        labelRecommendationRepo.save(labelRecommendation2);
        Artist artistRecommendation1 = artistRecommendationRepo.save(new Artist(1, 1, true));
        Artist artistRecommendation2 = artistRecommendationRepo.save(new Artist(1, 2, true));
        artistRecommendationRepo.save(artistRecommendation1);
        artistRecommendationRepo.save(artistRecommendation2);
        Album albumRecommendation1 = albumRecommendationRepo.save(new Album(1, 1, 1, true));
        Album albumRecommendation2 = albumRecommendationRepo.save(new Album(2, 2, 2, true));
        albumRecommendationRepo.save(albumRecommendation1);
        albumRecommendationRepo.save(albumRecommendation2);
        Track trackRecommendation1 = trackRecommendationRepo.save(new Track(1, 1, true));
        Track trackRecommendation2 = trackRecommendationRepo.save(new Track(1, 2, true));

        labelRecommendation1 = labelRecommendationRepo.save(labelRecommendation1);
        Optional<Label> label1 = labelRecommendationRepo.findById(labelRecommendation1.getId());
        Assert.assertEquals(label1.get(), labelRecommendation1);

    }

}