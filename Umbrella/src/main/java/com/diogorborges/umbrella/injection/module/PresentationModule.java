package com.diogorborges.umbrella.injection.module;

import android.content.Context;

import com.diogorborges.umbrella.data.usecase.GetForecastByZipCode;
import com.diogorborges.umbrella.presentation.main.MainContract;
import com.diogorborges.umbrella.presentation.main.MainPresenter;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class PresentationModule {

    @Provides
    MainContract.Presenter providesMainPresenter(@Named("applicationContext") Context context, GetForecastByZipCode getForecastByZipCode) {
        return new MainPresenter(context, getForecastByZipCode);
    }

}