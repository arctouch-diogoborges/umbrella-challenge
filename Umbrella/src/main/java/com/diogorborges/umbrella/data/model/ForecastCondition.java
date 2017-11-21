package com.diogorborges.umbrella.data.model;

/**
 * Represents a forecast weather condition returned from Weather Underground
 *
 * Does not include all available only data- only potentially useful fields are included
 */
public abstract class ForecastCondition {

  /**
   * The human-readable name of the condition
   */
  public abstract String getCondition();

  /**
   * The temperature that is forecast (in degrees Fahrenheit)
   */
  public abstract String getTempFahrenheit();

  /**
   * The temperature that is forecast (in degrees Celsius)
   */
  public abstract String getTempCelsius();

}
