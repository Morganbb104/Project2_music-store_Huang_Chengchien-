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
    private int album_id;
    private int user_id;
    private boolean liked;

    public Album(Integer id, int album_id, int user_id, boolean liked) {
        this.id = id;
        this.album_id = album_id;
        this.user_id = user_id;
        this.liked = liked;
    }

    public Album(int album_id, int user_id, boolean liked) {
        this.album_id = album_id;
        this.user_id = user_id;
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

    public int getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
        return album_id == album.album_id && user_id == album.user_id && liked == album.liked && Objects.equals(id, album.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, album_id, user_id, liked);
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", album_id=" + album_id +
                ", user_id=" + user_id +
                ", liked=" + liked +
                '}';
    }
}
