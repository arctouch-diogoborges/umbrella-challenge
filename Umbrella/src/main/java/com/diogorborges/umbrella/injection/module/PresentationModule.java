package com.diogorborges.umbrella.injection.module;

import android.content.Context;

import com.diogorborges.umbrella.data.usecase.GetForecastByZipCode;
import com.diogorborges.umbrella.presentation.main.MainContract;
import com.diogorborges.umbrella.presentation.main.MainPresenter;
import com.diogorborges.umbrella.presentation.settings.SettingsContract;
import com.diogorborges.umbrella.presentation.settings.SettingsPresenter;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class PresentationModule {

    @Provides
    SettingsContract.Presenter providesDetailPresenter() {
        return new SettingsPresenter();
    }

    @Provides
    MainContract.Presenter providesMainPresenter(@Named("applicationContext") Context context, GetForecastByZipCode getForecastByZipCode) {
        return new MainPresenter(context, getForecastByZipCode);
    }

}