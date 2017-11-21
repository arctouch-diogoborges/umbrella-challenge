package com.diogorborges.umbrella.data.model;

/**
 * Represents a "display_location" returned from Weather Underground
 *
 * Does not include all available only data- only potentially useful fields are included
 */
public abstract class DisplayLocation {

    /**
     * @return a String in the form of "City, StateAbbreviation". Ex. "Minneapolis, MN"
     */
    public abstract String getFullName(); abstract String getCity();

}
