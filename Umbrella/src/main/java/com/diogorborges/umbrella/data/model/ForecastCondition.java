package com.diogorborges.umbrella.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a forecast weather condition returned from Weather Underground
 *
 * Does not include all available only data- only potentially useful fields are included
 */
public class ForecastCondition {

  @JsonProperty("FCTTIME")
  private FCTTIME fCTTIME;

  @JsonProperty("temp")
  private Temp temp;

  @JsonProperty("condition")
  private String condition;

  public FCTTIME getFCTTIME() {
    return fCTTIME;
  }

  public Temp getTemp() {
    return temp;
  }

  public String getCondition() {
    return condition;
  }

}
