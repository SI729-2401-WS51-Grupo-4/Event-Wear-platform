package com.event.wear.platform.publication.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Value object representing the lessor id.
 */
@Embeddable
public record LessorId(Long lessorId) {
        public LessorId {
            if (lessorId < 0) {
                throw new IllegalArgumentException("Lessor lessorId cannot be negative");
            }
        }

        public LessorId() {
            this(0L);
        }
}
