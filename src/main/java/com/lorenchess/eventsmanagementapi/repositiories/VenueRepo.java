package com.lorenchess.eventsmanagementapi.repositiories;

import com.lorenchess.eventsmanagementapi.entities.Venue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepo extends JpaRepository<Venue, Long> {
    Page<Venue>findByPostalCode(String postalCode, Pageable pageable);
}
