package com.event.wear.platform.publication.domain.model.aggregates;

import com.event.wear.platform.publication.domain.model.entities.Comment;
import com.event.wear.platform.publication.domain.model.entities.Garment;
import com.event.wear.platform.publication.domain.model.valueobjects.CommentManager;
import com.event.wear.platform.publication.domain.model.valueobjects.LessorId;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.security.SecureRandom;


import java.util.Date;
import java.util.List;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Publication extends AbstractAggregateRoot<Publication> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cost;

    private Double rating;

    @Embedded
    private LessorId lessorId;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Date updatedAt;

    @OneToOne(mappedBy = "publication", cascade = CascadeType.ALL)
    private Garment garment;

    @OneToMany(mappedBy = "publication", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Comment> comments;

    @Embedded
    private CommentManager commentManager;

    private String image;

    public Publication() {
        this.cost = 0;
        this.lessorId = new LessorId();
        this.commentManager = new CommentManager();
        this.image = "";
    }

    public Publication(Integer cost, LessorId lessorId, Garment garment, String image) {
        this.id = new SecureRandom().nextLong();
        this.cost = cost;
        this.lessorId = lessorId;
        this.garment = garment;
        this.garment.setPublication(this);
        this.commentManager = new CommentManager();
        this.image = image;
        this.rating = 0.0;
    }

    public void updateCost(Integer cost) {
        this.cost = cost;
    }

    public void updateLessorId(LessorId lessorId) {
        this.lessorId = lessorId;
    }
    public void updateGarment(Garment garment) {
        this.garment = garment;
    }
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void calculateRating() {
        double calculatedRating = commentManager.calculateRating(comments);
        this.rating =calculatedRating;
    }

}