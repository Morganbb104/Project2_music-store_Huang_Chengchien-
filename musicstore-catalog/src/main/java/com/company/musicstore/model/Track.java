package com.company.musicstore.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="track")
public class Track {
    @Id
    @Column(name = "track_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="album_id")
    private int albumId;

    private String name;

    @Column(name="run_time")
    private int runtime;

    public Track() {
    }

    public Track(int id, int albumId, String name, int runtime) {
        this.id = id;
        this.albumId = albumId;
        this.name = name;
        this.runtime = runtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return id == track.id && albumId == track.albumId && runtime == track.runtime && Objects.equals(name, track.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, albumId, name, runtime);
    }

    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", albumId=" + albumId +
                ", name='" + name + '\'' +
                ", runtime=" + runtime +
                '}';
    }
}
