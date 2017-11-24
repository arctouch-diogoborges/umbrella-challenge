package com.diogorborges.umbrella.presentation.main;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.diogorborges.umbrella.R;
import com.diogorborges.umbrella.data.model.CurrentObservation;
import com.diogorborges.umbrella.data.model.ForecastCondition;
import com.diogorborges.umbrella.data.model.WeatherData;
import com.diogorborges.umbrella.data.usecase.GetForecastByZipCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.inject.Named;

import retrofit2.adapter.rxjava.Result;
import rx.Subscriber;

import static com.diogorborges.umbrella.util.Constants.CELCIUS;

public class MainPresenter implements MainContract.Presenter {

    private static final String TAG = "MainPresenter";

    private static final int FAHRENHEIT_TEMP_LIMIT = 60;
    private static final int CELCIUS_TEMP_LIMIT = 15;

    private ArrayList<Integer> dayList = new ArrayList<>();

    private Context context;

    private GetForecastByZipCode getForecastByZipCode;

    private MainContract.View view;

    @Inject
    public MainPresenter(@Named("applicationContext") Context context, GetForecastByZipCode getForecastByZipCode) {
        this.context = context;
        this.getForecastByZipCode = getForecastByZipCode;
    }

    private boolean hasZipCode(SharedPreferences settings) {
        return settings.getString(context.getString(R.string.pref_display_zipcode), "").isEmpty();

    }

    private void loadForecastByZipCode(String currentZipCode) {
        getForecastByZipCode.execute(currentZipCode).subscribe(new Subscriber<Result<WeatherData>>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted: loadForecastByZipCode");
            }

            @Override
            public void onError(Throwable e) {
                view.showError();
                defaultErrorHandling(e);
            }

            @Override
            public void onNext(Result<WeatherData> weatherDataResult) {
                if (hasAttachedView()) {
                    if (hasResponse(weatherDataResult)) {
                        view.showRecycler();
                        WeatherData weatherData = weatherDataResult.response().body();
                        view.clearForecastRecyclerView();
                        createForecastDay(weatherData);
                    } else {
                        view.showError();
                    }
                }
            }
        });
    }

    private boolean hasAttachedView() {
        return view != null;
    }

    private boolean hasResponse(Result<WeatherData> weatherDataResult) {
        return weatherDataResult.response() != null;
    }

    private void createForecastDay(WeatherData weatherData) {
        int currentDay = 0;
        int currentYear = 0;

        if (isAnExistentForecast(weatherData)) {
            List<ForecastCondition> weatherDataForecast = weatherData.getForecast();
            int size = weatherDataForecast.size();
            for (int i = 0; i < size; i++) {

                String yearDay = weatherDataForecast.get(i).getFCTTIME().getYday();
                String year = weatherDataForecast.get(i).getFCTTIME().getYear();

                // API is returning a day before, so add +1 to fix it
                int currentDayInt = Integer.parseInt(yearDay) + 1;
                int currentYearInt = Integer.parseInt(year);

                if (currentDay < currentDayInt || currentYear < currentYearInt) {
                    currentDay = currentDayInt;
                    currentYear = currentYearInt;
                    dayList.add(currentDay);
                }
            }

            displayCurrentWeather(weatherData);
            view.setForecastRecyclerView(weatherData, dayList);
        } else {
            view.showSettings();
            Toast.makeText(context, "Invalid Zip Code", Toast.LENGTH_SHORT).show();
        }

    }

    private boolean isAnExistentForecast(WeatherData weatherData) {
        return weatherData.getForecast() != null;
    }

    private void displayCurrentWeather(WeatherData weather) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        CurrentObservation currentObservation = weather.getCurrentObservation();

        float currentTemp;

        if (isCelcius(settings)) {
            currentTemp = currentObservation.getTempC();
            view.setCurrentWeatherColor(currentTemp, CELCIUS_TEMP_LIMIT);
        } else {
            currentTemp = currentObservation.getTempF();
            view.setCurrentWeatherColor(currentTemp, FAHRENHEIT_TEMP_LIMIT);
        }

        view.showCurrentWeatherContent(createCurrentTemperature(currentTemp),
                currentObservation.getWeather(),
                currentObservation.getDisplayLocation().getFull());
    }

    private boolean isCelcius(SharedPreferences settings) {
        return settings.getString(context.getString(R.string.pref_display_units), "1").equals(CELCIUS);
    }

    @NonNull
    private String createCurrentTemperature(float currentTemp) {
        return String.format(Locale.US, "%d", Math.round(currentTemp)) + "º";
    }

    @Override
    public void onViewResumed(MainContract.View view) {
        attachedView(view);
        loadZipCode();
    }

    private void loadZipCode() {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        if (hasZipCode(settings)) {
            view.showSettings();
        } else {
            String currentZipCode = settings.getString(context.getString(R.string.pref_display_zipcode), "");
            loadForecastByZipCode(currentZipCode);
        }
    }

    private void attachedView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void onViewPaused(MainContract.View view) {
        detachView();
    }

    private void detachView() {
        this.view = null;
    }

    private void defaultErrorHandling(Throwable e) {
        Log.e(TAG, Log.getStackTraceString(e));
    }


}
