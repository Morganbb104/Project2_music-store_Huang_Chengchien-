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
public class TrackRepositoryTest {
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
    public void addGetDeleteTrack(){
        // Need to create a Label, Artist, and Album first
        Label label = new Label();
        label.setName("Stone");
        label.setWebsite("www.stone.com");
        label = labelRepo.save(label);

        Artist artist = new Artist();
        artist.setName("Namees");
        artist.setInstagram("@Namees");
        artist.setTwitter("@Namees");
        artist = artistRepo.save(artist);

        Album album = new Album();
        album.setTitle("Tasmania");
        album.setArtistId(artist.getId());
        album.setLabelId(label.getId());
        album.setReleaseDate(LocalDate.of(2022,1,15));
        album.setListPrice(new BigDecimal("19.99"));

        album = albumRepo.save(album);

        Track track = new Track();
        track.setTitle("Beyond the horizon");
        track.setRuntime(100);
        track.setAlbumId(album.getId());
        track = trackRepo.save(track);

        Optional<Track> track1 = trackRepo.findById(track.getId());

        assertEquals(track1.get(), track);

        trackRepo.deleteById(track.getId());

        track1 = trackRepo.findById(track.getId());

        assertFalse(track1.isPresent());

    }

    @Test
    public void getAllTracks(){

        // Need to create a Label, Artist, and Album first
        Label label = new Label();
        label.setName("Stone");
        label.setWebsite("www.stone.com");
        label = labelRepo.save(label);

        Artist artist = new Artist();
        artist.setName("Namees");
        artist.setInstagram("@Namees");
        artist.setTwitter("@Namees");
        artist = artistRepo.save(artist);

        Album album = new Album();
        album.setTitle("Tasmania");
        album.setArtistId(artist.getId());
        album.setLabelId(label.getId());
        album.setReleaseDate(LocalDate.of(2022,1,15));
        album.setListPrice(new BigDecimal("19.99"));

        album = albumRepo.save(album);

        Album album1 = new Album();
        album1.setTitle("Naevest");
        album1.setArtistId(artist.getId());
        album1.setLabelId(label.getId());
        album1.setReleaseDate(LocalDate.of(2012,6,25));
        album1.setListPrice(new BigDecimal("9.95"));

        album1 = albumRepo.save(album1);

        Track track = new Track();
        track.setTitle("Beyond the horizon");
        track.setRuntime(100);
        track.setAlbumId(album.getId());
        trackRepo.save(track);


        Track track1 = new Track();
        track1.setTitle("Inside the horizon");
        track1.setRuntime(150);
        track1.setAlbumId(album1.getId());
        trackRepo.save(track1);


        List<Track> aList = trackRepo.findAll();
        assertEquals(aList.size(), 2);

    }


    @Test
    public void updateTrack(){

        // Need to create a Label, Artist, and Album first
        Label label = new Label();
        label.setName("Stone");
        label.setWebsite("www.stone.com");
        label = labelRepo.save(label);

        Artist artist = new Artist();
        artist.setName("Namees");
        artist.setInstagram("@Namees");
        artist.setTwitter("@Namees");
        artist = artistRepo.save(artist);

        Album album = new Album();
        album.setTitle("Tasmania");
        album.setArtistId(artist.getId());
        album.setLabelId(label.getId());
        album.setReleaseDate(LocalDate.of(2022,1,15));
        album.setListPrice(new BigDecimal("19.99"));

        album = albumRepo.save(album);

        Track track = new Track();
        track.setTitle("Beyond the horizon");
        track.setRuntime(100);
        track.setAlbumId(album.getId());
        track = trackRepo.save(track);


        track.setTitle("Thomas's home");
        trackRepo.save(track);
        Optional<Track> track1 = trackRepo.findById(track.getId());

        assertEquals(track1.get(), track);





    }
}