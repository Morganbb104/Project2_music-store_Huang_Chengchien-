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
    @Column(name = "label_id")
    private int labelId;
    @Column(name = "user_id")
    private int userId;
    private boolean liked;

    public Label(Integer id, int labelId, int userId, boolean liked) {
        this.id = id;
        this.labelId = labelId;
        this.userId = userId;
        this.liked = liked;
    }

    public Label(int labelId, int userId, boolean liked) {
        this.labelId = labelId;
        this.userId = userId;
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

    public int getLabelId() {
        return labelId;
    }

    public void setLabelId(int labelId) {
        this.labelId = labelId;
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
        Label label = (Label) o;
        return labelId == label.labelId && userId == label.userId && liked == label.liked && Objects.equals(id, label.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, labelId, userId, liked);
    }

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", labelId=" + labelId +
                ", userId=" + userId +
                ", liked=" + liked +
                '}';
    }
}
