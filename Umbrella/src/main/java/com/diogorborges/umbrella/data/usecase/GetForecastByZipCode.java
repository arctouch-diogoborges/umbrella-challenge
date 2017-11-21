package com.diogorborges.umbrella.data.usecase;

import com.diogorborges.umbrella.data.model.WeatherData;
import com.diogorborges.umbrella.data.remote.ApiService;

import javax.inject.Inject;

import retrofit2.adapter.rxjava.Result;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class GetForecastByZipCode {

    ApiService apiService;

    @Inject
    GetForecastByZipCode(ApiService apiService) {
        this.apiService = apiService;
    }

    public Observable<Result<WeatherData>> execute(String zipCode) {
        return apiService.getForecastByZipCode(zipCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
