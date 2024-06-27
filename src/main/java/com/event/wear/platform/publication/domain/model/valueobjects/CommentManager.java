package com.event.wear.platform.publication.domain.model.valueobjects;

import com.event.wear.platform.publication.domain.model.entities.Comment;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Embeddable
public class CommentManager {
    public CommentManager() {
    }

    public double calculateRating(List<Comment> comments) {
        if (comments.isEmpty()) {
            return 0;
        }

        double sum = 0;
        for (Comment comment : comments) {
            sum += comment.getRating();
        }
        double calculatedRating = sum / comments.size();
        return Math.round(calculatedRating * 10.0) / 10.0;
    }
}