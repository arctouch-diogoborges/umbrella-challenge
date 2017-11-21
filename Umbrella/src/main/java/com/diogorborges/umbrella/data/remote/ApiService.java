package com.diogorborges.umbrella.data.remote;

import com.diogorborges.umbrella.BuildConfig;
import com.diogorborges.umbrella.data.model.WeatherData;

import retrofit2.Call;
import retrofit2.adapter.rxjava.Result;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Retrofit interface for fetching weather data
 */
public interface ApiService {

    /**
     * Get the forecast for a given zip code using {@link Observable}
     */
    @GET("/api/" + BuildConfig.API_KEY + "/conditions/hourly/q/{zip}.json")
    Observable<Result<WeatherData>> getForecastByZipCode(@Path("zip") String zipCode);

}
