package com.lorenchess.eventsmanagementapi.repositiories;

import com.lorenchess.eventsmanagementapi.entities.Participant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepo extends JpaRepository<Participant, Long> {
    Page<Participant>findByEmail(String email, Pageable pageable);
}
