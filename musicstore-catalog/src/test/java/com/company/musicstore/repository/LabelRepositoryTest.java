package com.company.musicstore.repository;

import com.company.musicstore.model.Album;
import com.company.musicstore.model.Artist;
import com.company.musicstore.model.Label;
import com.company.musicstore.model.Track;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LabelRepositoryTest {
    @Autowired
    TrackRepository trackRepo;
    @Autowired
    AlbumRepository albumRepo;
    @Autowired
    ArtistRepository artistRepo;
    @Autowired
    LabelRepository labelRepo;

    @Before
    public void setUp() throws Exception{
        trackRepo.deleteAll();
        albumRepo.deleteAll();
        artistRepo.deleteAll();
        labelRepo.deleteAll();
    }

    @Test
    public void addGetDeleteArtist(){
        // Requiring a Label and an Artist first
        Label label = new Label();
        label.setName("Stone");
        label.setWebsite("www.stone.com");
        label = labelRepo.save(label);

        Artist artist = new Artist();
        artist.setName("Namees");
        artist.setInstagram("@Namees");
        artist.setTwitter("@Namees");
        artist = artistRepo.save(artist);

        Track track = new Track();
        track.setId(track.getId());
        track.setAlbumId(track.getAlbumId());
        track.setTitle(track.getTitle());
        track.setRuntime(track.setRuntime(100));

        Album album = new Album();
        album.setTitle("Tasmania");
        album.setArtistId(artist.getId());
        album.setLabelId(label.getId());
        album.setReleaseDate(LocalDate.of(2022,1,15));
        album.setListPrice(new BigDecimal("19.99"));

        label = labelRepo.save((label));

        Optional<Label> label1 = labelRepo.findById(label.getId());

        assertEquals(label1.get(), label);

        labelRepo.deleteById(label.getId());

        label1 = labelRepo.findById(label.getId());

        assertFalse(label1.isPresent());

    }

    @Test
    public void getAllLabels(){
        Label label1 = new Label(1,"Cheng","www.cheng.com");
        Label label2 = new Label(2,"Andrew","www.andrew.com");
        labelRepo.save(label1);
        labelRepo.save(label2);
        List<Label> aList = labelRepo.findAll();
        assertEquals(aList.size(), 2);

    }

    @Test
    public void updateArtist(){
        Label label = labelRepo.save(new Label(1,"Stone","www.stone.com"));
        label.setName("Mike");
        labelRepo.save(label);
        Optional<Label> actual = labelRepo.findById(label.getId());

        assertEquals(actual.get(), label);

    }
}