package com.diogorborges.umbrella.presentation.main;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.diogorborges.umbrella.R;
import com.diogorborges.umbrella.UmbrellaApp;
import com.diogorborges.umbrella.data.model.WeatherData;
import com.diogorborges.umbrella.presentation.adapter.ForecastAdapter;
import com.diogorborges.umbrella.presentation.settings.SettingsActivity;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private static final String TAG = "MainActivity";

    private RecyclerView.Adapter mAdapter;
    private ArrayList dayList;

    @BindView(R.id.myRecyclerView)
    RecyclerView mRecyclerView;

    @BindView(R.id.textView_hourly_temperature)
    TextView textViewTemperature;

    @BindView(R.id.textView_current_condition)
    TextView textViewCondition;

    @BindView(R.id.textView_current_location)
    TextView textViewLocation;

    @BindView(R.id.button_settings)
    Button buttonSettings;

    @BindView(R.id.background_current_weather)
    LinearLayout backgroundCurrentWeather;

    @BindView(R.id.error_layout)
    LinearLayout errorLayout;

    @Inject
    MainContract.Presenter presenter;

    public MainActivity() {
        // Constructor for Dagger
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ((UmbrellaApp) getApplication()).getAppComponent().inject(this);

        hideActionBar();

        initListener();
    }

    private void initListener() {
        buttonSettings.setOnClickListener(onSettingsClicked());
    }

    @NonNull
    private View.OnClickListener onSettingsClicked() {
        return view -> openSettingsActivity();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onViewResumed(this);
    }

    @Override
    public void showCurrentWeatherContent(String currentTemperature, String weather, String fullName) {
        textViewTemperature.setText(currentTemperature);
        textViewCondition.setText(weather);
        textViewLocation.setText(fullName);
    }

    @Override
    public void showError() {
        mRecyclerView.setVisibility(View.GONE);
        errorLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void showSettings() {
        openSettingsActivity();
    }

    private void openSettingsActivity() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onViewPaused(this);
    }

    @Override
    public void setCurrentWeatherColor(float currentTemperature, int temperatureLimit) {
        int backgroundColor;
        if (currentTemperature > temperatureLimit) {
            backgroundColor = getResources().getColor(R.color.weather_warm);
        } else {
            backgroundColor = getResources().getColor(R.color.weather_cool);
        }
        backgroundCurrentWeather.setBackgroundColor(backgroundColor);
    }

    @Override
    public void setForecastRecyclerView(WeatherData weatherData, ArrayList<Integer> dayList) {
        this.dayList = dayList;

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ForecastAdapter(this, this.dayList, weatherData);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void clearForecastRecyclerView() {
        if (mAdapter != null) {
            int size = dayList.size();
            dayList.clear();
            mAdapter.notifyItemRangeRemoved(0, size);
        }
    }

    @Override
    public void showRecycler() {
        mRecyclerView.setVisibility(View.VISIBLE);
        errorLayout.setVisibility(View.GONE);
    }

    private void hideActionBar() {
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

}
