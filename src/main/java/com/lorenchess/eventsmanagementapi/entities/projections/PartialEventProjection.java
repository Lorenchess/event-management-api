package com.lorenchess.eventsmanagementapi.entities.projections;

import com.lorenchess.eventsmanagementapi.entities.Event;
import org.springframework.data.rest.core.config.Projection;

import java.time.ZonedDateTime;
/**
 * Use in case we want to retrieve in the HAL only a few fields not the entire collection...Even the hidden fileds
 * that we hide with JsonIgnore we can retrieve them with Instance getCreated()...
 * */
@Projection(name="partial", types = {Event.class})
public interface PartialEventProjection {
    String getName();
    ZonedDateTime getStartTime();
    ZonedDateTime getEndTime();
}
