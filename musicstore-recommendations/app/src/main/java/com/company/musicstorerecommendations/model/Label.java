package com.company.musicstorerecommendations.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "label_recommendation")
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "label_recommendation_id")
    private Integer id;
    private int label_id;
    private int user_id;
    private boolean liked;

    public Label(Integer id, int label_id, int user_id, boolean liked) {
        this.id = id;
        this.label_id = label_id;
        this.user_id = user_id;
        this.liked = liked;
    }

    public Label(int label_id, int user_id, boolean liked) {
        this.label_id = label_id;
        this.user_id = user_id;
        this.liked = liked;
    }

    public Label() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getLabel_id() {
        return label_id;
    }

    public void setLabel_id(int label_id) {
        this.label_id = label_id;
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
        Label label = (Label) o;
        return label_id == label.label_id && user_id == label.user_id && liked == label.liked && Objects.equals(id, label.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, label_id, user_id, liked);
    }

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", label_id=" + label_id +
                ", user_id=" + user_id +
                ", liked=" + liked +
                '}';
    }
}
