package com.company.musicstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "album")
public class Album {
    @Id
    @Column(name = "album_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    @Column(name = "artist_id")
    private int artistId;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "label_id")
    private int labelId;

    @Column(name = "list_price")
    private BigDecimal listPrice;

    public Album() {
    }

    public Album(String title, int artistId, LocalDate releaseDate, int labelId, BigDecimal listPrice) {
        this.title = title;
        this.artistId = artistId;
        this.releaseDate = releaseDate;
        this.labelId = labelId;
        this.listPrice = listPrice;
    }

    public Album(Integer id, String title, int artistId, LocalDate releaseDate, int labelId, BigDecimal listPrice) {
        this.id = id;
        this.title = title;
        this.artistId = artistId;
        this.releaseDate = releaseDate;
        this.labelId = labelId;
        this.listPrice = listPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getLabelId() {
        return labelId;
    }

    public void setLabelId(int labelId) {
        this.labelId = labelId;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return artistId == album.artistId && labelId == album.labelId && Objects.equals(id, album.id) && Objects.equals(title, album.title) && Objects.equals(releaseDate, album.releaseDate) && Objects.equals(listPrice, album.listPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, artistId, releaseDate, labelId, listPrice);
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artistId=" + artistId +
                ", releaseDate=" + releaseDate +
                ", labelId=" + labelId +
                ", listPrice=" + listPrice +
                '}';
    }
}
