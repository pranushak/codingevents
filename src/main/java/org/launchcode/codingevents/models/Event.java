package org.launchcode.codingevents.models;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.engine.internal.Cascade;

import java.util.Objects;

@Entity
public class Event extends AbstractEntity{

    @NotBlank(message="Name is required!")
    @Size(min=3, max= 50, message="Name must be 3 and 50 characters!")
    private String name;

    @ManyToOne
    @NotNull(message = "category is required")
    private EventCategory eventCategory;

    @OneToOne (cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private EventDetails eventDetails;

    public Event(String name, EventCategory eventCategory) {
        this.name = name;
        this.eventCategory = eventCategory;
    }
    public Event(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }

    public @Valid EventDetails getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(@Valid EventDetails eventDetails) {
        this.eventDetails = eventDetails;
    }

    @Override
    public String toString() {
        return name;
    }

}
