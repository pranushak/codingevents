package org.launchcode.codingevents.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
public class Event extends AbstractEntity{

    @NotBlank(message="Name is required!")
    @Size(min=3, max= 50, message="Name must be 3 and 50 characters!")
    private String name;

    @NotBlank
    @Size(max=300, message="Description too long")
    private String description;

    @NotBlank(message="Email is required!")
    @Email(message="Invalid Email, Try again!")
    private String contactEmail;

    @ManyToOne
    @NotNull(message = "category is required")
    private EventCategory eventCategory;

    public Event(String name, String description, String contactEmail, EventCategory eventCategory) {
        this.name = name;
        this.description = description;
        this.contactEmail =contactEmail;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public @Email(message = "Invalid Email, Try again!") String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(@Email(message = "Invalid Email, Try again!") String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }

    @Override
    public String toString() {
        return name;
    }

}
