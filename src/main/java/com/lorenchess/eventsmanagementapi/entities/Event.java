package com.lorenchess.eventsmanagementapi.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Set;

@JsonPropertyOrder("resourceId")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Event extends AbstractEntity{

    private String name;

    private String description;

    @JsonProperty("starting-time")
    private ZonedDateTime startTime;

    @JsonProperty("ending-time")
    private ZonedDateTime endTime;

    private ZoneId zoneId;

    private Boolean started;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "organizer_id",nullable = false)
    private Organizer organizer;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @RestResource(exported = false) //creating an association so when we create the event we also create the venue bec by default venue is exported as link
    private Venue venue;

    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Participant> participants;

    /**
     * Method use to expose the ID, but we use this only if we need it, by default is hidden
     * */
    public Long getResourceId() {
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(id, ((Event)obj).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
