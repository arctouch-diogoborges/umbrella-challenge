package com.diogorborges.umbrella.injection.module;

import com.diogorborges.umbrella.presentation.main.MainContract;
import com.diogorborges.umbrella.presentation.main.MainPresenter;
import com.diogorborges.umbrella.presentation.settings.SettingsContract;
import com.diogorborges.umbrella.presentation.settings.SettingsPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class PresentationModule {

    @Provides
    SettingsContract.Presenter providesDetailPresenter() {
        return new SettingsPresenter();
    }

    @Provides
    MainContract.Presenter providesMainPresenter() {
        return new MainPresenter();
    }

}