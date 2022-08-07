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
public class ArtistRecommendationRepositoryTest {

    @Autowired
    TrackRecommendationRepository trackRecommendationRepo;
    @Autowired
    AlbumRecommendationRepository albumRecommendationRepo;
    @Autowired
    ArtistRecommendationRepository artistRecommendationRepo;
    @Autowired
    LabelRecommendationRepository labelRecommendationRepo;

    @Before
    public void setUp() throws Exception{
        albumRecommendationRepo.deleteAll();
        trackRecommendationRepo.deleteAll();
        artistRecommendationRepo.deleteAll();
        labelRecommendationRepo.deleteAll();
    }

    @Test
    public void getALLArtistRecommendations() {
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
        artistRecommendationRepo.save(artistRecommendation1);
        artistRecommendationRepo.save(artistRecommendation2);
        List<Artist> aList = artistRecommendationRepo.findAll();
        assertEquals(aList.size(), 2);


    }

    @Test
    public void addGetDeleteArtist(){
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

        artistRecommendation1 = artistRecommendationRepo.save(artistRecommendation1);

        Optional<Artist> artist1 = artistRecommendationRepo.findById(artistRecommendation1.getId());

        Assert.assertEquals(artist1.get(), artistRecommendation1);

        artistRecommendationRepo.deleteById(artistRecommendation1.getId());

        artist1 = artistRecommendationRepo.findById(artistRecommendation1.getId());

        assertFalse(artist1.isPresent());
    }

    @Test
    public void updateAnAlbum(){
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

        artistRecommendation1 = artistRecommendationRepo.save(artistRecommendation1);
        Optional<Artist> artist1 = artistRecommendationRepo.findById(artistRecommendation1.getId());
        Assert.assertEquals(artist1.get(), artistRecommendation1);



    }


}