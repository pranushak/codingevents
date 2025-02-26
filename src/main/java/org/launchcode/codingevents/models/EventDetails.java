package org.launchcode.codingevents.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class EventDetails extends AbstractEntity {

    @NotBlank
    @Size(max=300, message="Description too long")
    private String description;

    @NotBlank(message="Email is required!")
    @Email(message="Invalid Email, Try again!")
    private String contactEmail;

    public EventDetails(String description, String contactEmail) {
        this.contactEmail = contactEmail;
        this.description = description;
    }

    public EventDetails(){}

    public @NotBlank(message = "Email is required!") @Email(message = "Invalid Email, Try again!") String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(@NotBlank(message = "Email is required!") @Email(message = "Invalid Email, Try again!") String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public @NotBlank @Size(max = 300, message = "Description too long") String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank @Size(max = 300, message = "Description too long") String description) {
        this.description = description;
    }
}
