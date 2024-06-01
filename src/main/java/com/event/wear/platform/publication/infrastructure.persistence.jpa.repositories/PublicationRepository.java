package com.event.wear.platform.publication.infrastructure.persistence.jpa.repositories;

import com.event.wear.platform.publication.domain.model.aggregates.Publication;
import com.event.wear.platform.publication.domain.model.entities.Garment;
import com.event.wear.platform.publication.domain.model.valueobjects.LessorId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {
    Boolean existsByGarment(Garment garment);
    List<Publication> findByLessorId(Long lessorId);
}
