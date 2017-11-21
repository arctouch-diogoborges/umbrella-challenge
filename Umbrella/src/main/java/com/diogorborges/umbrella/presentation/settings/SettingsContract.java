package com.diogorborges.umbrella.presentation.settings;

public interface SettingsContract {

    interface View {

        void showContent(String zipCode, int selectedUnit);

        void showError();

    }

    interface Presenter {

        void start();

        void onViewResumed(SettingsContract.View view);

        void onViewPaused(SettingsContract.View view);

        void onUserUpdateUnits(String selectedUnit);

        void onUserUpdateZipCode(String selectedZipCode);

    }

}
