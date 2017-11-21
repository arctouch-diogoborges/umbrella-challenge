package com.diogorborges.umbrella.injection.component;

import com.diogorborges.umbrella.data.remote.ApiService;
import com.diogorborges.umbrella.injection.module.AppModule;
import com.diogorborges.umbrella.injection.module.NetModule;
import com.diogorborges.umbrella.injection.module.PresentationModule;
import com.diogorborges.umbrella.presentation.main.MainActivity;
import com.diogorborges.umbrella.presentation.settings.SettingsActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetModule.class, PresentationModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);

    void inject(SettingsActivity settingsActivity);

    ApiService apiService();

}

