package com.lorenchess.eventsmanagementapi.entities;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Objects;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Organizer extends AbstractEntity{
    private String name;

    @OneToMany(mappedBy = "organizer")
    private Set<Event> events;

    /**
     * Method use to expose the ID, but we use this only if we need it, by default is hidden
     * */
    public Long getResourceId() {
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(id, ((Organizer)obj).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
