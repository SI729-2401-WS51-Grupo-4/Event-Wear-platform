package com.event.wear.platform.publication.domain.model.entities;

import com.event.wear.platform.publication.domain.model.aggregates.Publication;
import com.event.wear.platform.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Garment extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String size;

    public Garment() {
        this.title = "";
        this.description = "";
        this.size = "";
    }
    public Garment(String title, String description, String size, String rentalCount) {
        this.title = title;
        this.description = description;
        this.size = size;
    }

    @OneToOne
    @JoinColumn(name = "publication_id")
    private Publication publication;
}
