package com.company.musicstorerecommendations.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "track_recommendation")
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "track_recommendation_id")
    private Integer id;
    @Column(name = "track_id")
    private int trackId;
    @Column(name = "user_id")
    private int userId;
    private boolean liked;

    public Track(Integer id, int trackId, int userId, boolean liked) {
        this.id = id;
        this.trackId = trackId;
        this.userId = userId;
        this.liked = liked;
    }

    public Track(int trackId, int userId, boolean liked) {
        this.trackId = trackId;
        this.userId = userId;
        this.liked = liked;
    }

    public Track() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
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
        Track track = (Track) o;
        return trackId == track.trackId && userId == track.userId && liked == track.liked && Objects.equals(id, track.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, trackId, userId, liked);
    }

    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", trackId=" + trackId +
                ", userId=" + userId +
                ", liked=" + liked +
                '}';
    }
}
