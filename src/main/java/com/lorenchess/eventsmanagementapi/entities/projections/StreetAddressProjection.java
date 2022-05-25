package com.lorenchess.eventsmanagementapi.entities.projections;

import com.lorenchess.eventsmanagementapi.entities.Venue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="virtual", types = {Venue.class})
public interface StreetAddressProjection {

    @Value("#{target.streetAddress} #{target.streetAddress2}")
    String getCompleteStreetAddress();

}
