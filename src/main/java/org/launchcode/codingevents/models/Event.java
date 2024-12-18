package org.launchcode.codingevents.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class Event {
    private int id;
    private static int nextId = 1;

    @NotBlank(message="Name is required!")
    @Size(min=3, max= 50, message="Name must be 3 and 50 characters!")
    private String name;

    @NotBlank
    @Size(max=300, message="Description too long")
    private String description;

    @NotBlank(message="Email is required!")
    @Email(message="Invalid Email, Try again!")
    private String contactEmail;

    @NotBlank(message = "Location cannot be blank!")
    private String location;

    @Positive(message = "Number of attendees must be one or more.")
    private int numberOfAttendies;

    public Event(String name, String description, String contactEmail, String location, int numberOfAttendies) {
        this();
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
        this.numberOfAttendies = numberOfAttendies;
    }
    public Event(){
        this.id = nextId;
        nextId++;
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

    public int getId() {
        return id;
    }

    public @NotBlank(message = "Location cannot be blank!") String getLocation() {
        return location;
    }

    public void setLocation(@NotBlank(message = "Location cannot be blank!") String location) {
        this.location = location;
    }

    @Positive(message = "Number of attendees must be one or more.")
    public int getNumberOfAttendies() {
        return numberOfAttendies;
    }

    public void setNumberOfAttendies(@Positive(message = "Number of attendees must be one or more.") int numberOfAttendies) {
        this.numberOfAttendies = numberOfAttendies;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
