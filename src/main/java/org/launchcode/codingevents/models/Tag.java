package org.launchcode.codingevents.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Tag extends  AbstractEntity{
    @Size(min = 1, max =25)
    @NotBlank
    private String name;

    public Tag(String name) {
        this.name = name;
    }

    public Tag() {
    }

    public @Size(min = 1, max = 25) @NotBlank String getName() {
        return name;
    }

    public String getDisplayName(){
        return "#" + name + " ";
    }
    public void setName(@Size(min = 1, max = 25) @NotBlank String name) {
        this.name = name;
    }
}
