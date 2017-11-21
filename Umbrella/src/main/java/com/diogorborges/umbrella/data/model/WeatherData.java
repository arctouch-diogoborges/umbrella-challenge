package com.diogorborges.umbrella.data.model;

import java.util.List;

/**
 * Represents weather information returned from the Weather Underground API
 *
 * Does not include all available only data- only potentially useful fields are included
 */
public abstract class WeatherData {

  public abstract CurrentObservation getCurrentObservation();

  public abstract List<ForecastCondition> getForecast();

}
