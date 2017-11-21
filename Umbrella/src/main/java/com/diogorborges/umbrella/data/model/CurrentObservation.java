package com.diogorborges.umbrella.data.model;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the "current_observation" data returned from Weather Underground
 *
 * Does not include all available only data- only potentially useful fields are included
 */
public class CurrentObservation {

  @JsonProperty("display_location")
  private DisplayLocation displayLocation;

  @JsonProperty("temp_f")
  private float tempFahrenheit;

  @JsonProperty("temp_c")
  private float tempCelsius;

  private String weather;

  public DisplayLocation getDisplayLocation() {
    return displayLocation;
  }

  public float getTempFahrenheit() {
    return tempFahrenheit;
  }

  public float getTempCelsius() {
    return tempCelsius;
  }

  public String getWeather() {
    return weather;
  }

}
