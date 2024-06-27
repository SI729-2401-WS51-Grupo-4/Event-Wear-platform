package com.event.wear.platform.publication.domain.model.entities;

import com.event.wear.platform.publication.domain.model.aggregates.Publication;
import com.event.wear.platform.publication.domain.model.valueobjects.CommentManager;
import com.event.wear.platform.publication.domain.model.valueobjects.UserId;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "publication_id")
    private Publication publication;

    @Embedded
    private CommentManager commentManager;

    private String content;

    private Short rating;

    @Embedded
    private UserId userId;

    public Comment(){
        this.publication = new Publication();
        this.content = "";
        this.rating = 0;
        this.userId = new UserId();
    }
    public Comment(Publication publication, String content, Short rating) {
        this.publication = publication;
        this.content = content;
        this.rating = rating;
    }

}