package com.lorenchess.eventsmanagementapi.repositiories;

import com.lorenchess.eventsmanagementapi.entities.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizerRepo extends JpaRepository<Organizer, Long> {
}
