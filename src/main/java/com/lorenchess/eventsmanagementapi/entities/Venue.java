package com.lorenchess.eventsmanagementapi.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Venue extends AbstractEntity{
    @Size(min=3, max= 40)
    private String name;
    private String streetAddress;
    private String streetAddress2;
    private String city;
    private String state;
    private String country;
    private String postalCode;

    /**
     * Method use to expose the ID, but we use this only if we need it, by default is hidden
     * */
    public Long getResourceId() {
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(id, ((Venue)obj).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
