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

import java.util.Date;
import java.util.List;

@Getter
@Entity
public class Publication extends AbstractAggregateRoot<Publication> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer cost;

    private Double rating;

    @Embedded
    private LessorId lessorId;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    @OneToOne(mappedBy = "publication")
    private Garment garment;

    @OneToMany(mappedBy = "publication", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @Embedded
    private CommentManager commentManager;

    public Publication() {
        this.cost = 0;
        this.lessorId = new LessorId();
        this.commentManager = new CommentManager();
    }

    public Publication(Integer cost, LessorId lessorId, Garment garment, List<Comment> comments) {
        this.cost = cost;
        this.lessorId = lessorId;
        this.garment = garment;
        this.comments = comments;
        this.commentManager = new CommentManager();
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