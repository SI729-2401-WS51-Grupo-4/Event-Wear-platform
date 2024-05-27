package com.event.wear.platform.rent.infrastructure.persistence.jpa.repositories;

import com.event.wear.platform.rent.domain.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}