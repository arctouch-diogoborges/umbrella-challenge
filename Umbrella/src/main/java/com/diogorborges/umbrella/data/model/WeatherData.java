package com.diogorborges.umbrella.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Represents weather information returned from the Weather Underground API
 *
 * Does not include all available only data- only potentially useful fields are included
 */
public class WeatherData {

  @JsonProperty("current_observation")
  private CurrentObservation currentObservation;

  @JsonProperty("hourly_forecast")
  private List<ForecastCondition> forecast;

  @JsonProperty("response")
  private Response response;

  public Response getResponse() {
    return response;
  }

  public CurrentObservation getCurrentObservation() {
    return currentObservation;
  }

  public List<ForecastCondition> getForecast() {
    return forecast;
  }

}
