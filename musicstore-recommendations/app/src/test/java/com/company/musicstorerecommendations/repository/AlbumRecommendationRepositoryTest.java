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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlbumRecommendationRepositoryTest {

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
    public void getAllAlbumRecommendations() {
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
        List<Album> aList = albumRecommendationRepo.findAll();
        assertEquals(aList.size(), 2);


    }

    @Test
    public void addGetDeleteAlbum(){
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

        albumRecommendation1 = albumRecommendationRepo.save(albumRecommendation1);

        Optional<Album> album1 = albumRecommendationRepo.findById(albumRecommendation1.getId());

        Assert.assertEquals(album1.get(), albumRecommendation1);

        albumRecommendationRepo.deleteById(albumRecommendation1.getId());

        album1 = albumRecommendationRepo.findById(albumRecommendation1.getId());

        assertFalse(album1.isPresent());
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

        albumRecommendation1 = albumRecommendationRepo.save(albumRecommendation1);
        Optional<Album> album1 = albumRecommendationRepo.findById(albumRecommendation1.getId());
        Assert.assertEquals(album1.get(), albumRecommendation1);



    }

}