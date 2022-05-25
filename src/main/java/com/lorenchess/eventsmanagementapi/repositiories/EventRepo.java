package com.lorenchess.eventsmanagementapi.repositiories;

import com.lorenchess.eventsmanagementapi.entities.Event;
import com.lorenchess.eventsmanagementapi.entities.projections.PartialEventProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.ZoneId;

/**
 *We use the @RepositoryRestResource to apply a Projection to any Repository, and it is applied to any collection;
 * */
@RepositoryRestResource(excerptProjection = PartialEventProjection.class)
public interface EventRepo extends JpaRepository<Event, Long> {
    Page<Event> findByName(@Param("name") String eventName, Pageable pageable);

    Page<Event>findByNameAndZoneId(String name, ZoneId zoneId, Pageable pageable);

}
