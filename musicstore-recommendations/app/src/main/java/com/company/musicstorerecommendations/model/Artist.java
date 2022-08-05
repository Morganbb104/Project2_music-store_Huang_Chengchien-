package com.company.musicstorerecommendations.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "artist_recommendation")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artist_recommendation_id")
    private Integer id;
    @Column(name = "artist_id")
    private int artistId;
    @Column(name = "user_id")
    private int userId;
    private boolean liked;

    public Artist(Integer id, int artistId, int userId, boolean liked) {
        this.id = id;
        this.artistId = artistId;
        this.userId = userId;
        this.liked = liked;
    }

    public Artist(int artistId, int userId, boolean liked) {
        this.artistId = artistId;
        this.userId = userId;
        this.liked = liked;
    }

    public Artist() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return artistId == artist.artistId && userId == artist.userId && liked == artist.liked && Objects.equals(id, artist.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, artistId, userId, liked);
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", artistId=" + artistId +
                ", userId=" + userId +
                ", liked=" + liked +
                '}';
    }
}
