package com.categories.event_wear_platform.categories.infrastructure.persistence.jpa.repositories;

import com.categories.event_wear_platform.categories.domain.model.valueobjects.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {
}