package com.diogorborges.umbrella.presentation.settings;

import com.diogorborges.umbrella.presentation.main.MainContract;

public interface SettingsContract {

    interface View {

        void showContent();

        void showError();

    }

    interface Presenter {

        void start();

        void onViewResumed(SettingsContract.View view);

        void onViewPaused(SettingsContract.View view);

    }

}
