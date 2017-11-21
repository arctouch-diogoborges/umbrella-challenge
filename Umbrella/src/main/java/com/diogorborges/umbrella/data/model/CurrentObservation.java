package com.diogorborges.umbrella.data.model;


/**
 * Represents the "current_observation" data returned from Weather Underground
 *
 * Does not include all available only data- only potentially useful fields are included
 */
public abstract class CurrentObservation {

  public abstract DisplayLocation getDisplayLocation();

  public abstract String getTempFahrenheit();

  public abstract String getTempCelsius();

  public abstract String getWeatherDescription();

}
