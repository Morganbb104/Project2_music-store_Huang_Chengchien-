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
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArtistRepositoryTest {

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
    public void addGetDeleteAlbum(){
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

        artist = artistRepo.save(artist);

        Optional<Artist> artist1 = artistRepo.findById(artist.getId());

        assertEquals(artist1.get(), artist);

        artistRepo.deleteById(artist.getId());

        artist1 = artistRepo.findById(artist.getId());

        assertFalse(artist1.isPresent());

    }

}