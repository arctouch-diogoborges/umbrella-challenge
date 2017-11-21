package com.diogorborges.umbrella.presentation.main;

import com.diogorborges.umbrella.data.model.WeatherData;

import java.util.ArrayList;

public interface MainContract {

    interface View {

        void showCurrentWeatherContent(String currentTemperature, String weather, String fullName);

        void showError();

        void showSettings();

        void setCurrentWeatherColor(float currentTemp, int celciusTempLimit);

        void setForecastRecyclerView(WeatherData weatherData, ArrayList<Integer> dayList);

        void clearForecastRecyclerView();

        void showRecycler();

    }

    interface Presenter {

        void onViewResumed(View view);

        void onViewPaused(View view);

    }

}
