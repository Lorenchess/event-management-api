package com.lorenchess.eventsmanagementapi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Participant extends AbstractEntity{
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    private Boolean checkedIn;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id", nullable = false, updatable = false)
    private Event event;

    /**
     * Method use to expose the ID, but we use this only if we need it, by default is hidden
     * */
    public Long getResourceId() {
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(id, ((Participant)obj).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
