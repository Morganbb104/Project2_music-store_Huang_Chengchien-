package com.company.musicstorerecommendations.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "album_recommendation")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_recommendation_id")
    private Integer id;
    @Column(name ="album_id")
    private int albumId;
    @Column(name ="user_id")
    private int userId;
    private boolean liked;

    public Album(Integer id, int albumId, int userId, boolean liked) {
        this.id = id;
        this.albumId = albumId;
        this.userId = userId;
        this.liked = liked;
    }

    public Album(int albumId, int userId, boolean liked) {
        this.albumId = albumId;
        this.userId = userId;
        this.liked = liked;
    }

    public Album() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
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
        Album album = (Album) o;
        return albumId == album.albumId && userId == album.userId && liked == album.liked && Objects.equals(id, album.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, albumId, userId, liked);
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", albumId=" + albumId +
                ", userId=" + userId +
                ", liked=" + liked +
                '}';
    }
}
