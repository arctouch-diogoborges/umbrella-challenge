package com.diogorborges.umbrella;

import android.app.Application;

import com.diogorborges.umbrella.injection.component.AppComponent;
import com.diogorborges.umbrella.injection.component.DaggerAppComponent;
import com.diogorborges.umbrella.injection.module.AppModule;
import com.diogorborges.umbrella.injection.module.NetModule;
import com.diogorborges.umbrella.injection.module.PresentationModule;
import com.jakewharton.threetenabp.AndroidThreeTen;

public class UmbrellaApp extends Application {

  private AppComponent appComponent;

  @Override
  public void onCreate() {
    super.onCreate();

    AndroidThreeTen.init(this);

    appComponent = initDaggerComponent();
  }

  private AppComponent initDaggerComponent() {
    return DaggerAppComponent.builder()
            .appModule(new AppModule(this))
            .netModule(new NetModule())
            .presentationModule(new PresentationModule())
            .build();
  }

  public AppComponent getAppComponent() {
    return appComponent;
  }

}
