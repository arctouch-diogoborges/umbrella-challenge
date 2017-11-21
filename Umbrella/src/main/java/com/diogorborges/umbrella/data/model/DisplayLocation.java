package com.diogorborges.umbrella.data.model;

/**
 * Represents a "display_location" returned from Weather Underground
 *
 * Does not include all available only data- only potentially useful fields are included
 */
public class DisplayLocation {

    private String fullName;

    public String getFullName() {
        return fullName;
    }

}
