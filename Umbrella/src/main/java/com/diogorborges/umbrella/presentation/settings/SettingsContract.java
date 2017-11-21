package com.diogorborges.umbrella.presentation.settings;

public interface SettingsContract {

    interface View {

        void setSelectedZipCode(String zipCode);

        void setSelectedUnit(int unit);

    }

    interface Presenter {

        void onViewResumed(SettingsContract.View view);

        void onViewPaused(SettingsContract.View view);

        void onUserUpdateUnits(String selectedUnit);

        void onUserUpdateZipCode(String selectedZipCode);

    }

}
