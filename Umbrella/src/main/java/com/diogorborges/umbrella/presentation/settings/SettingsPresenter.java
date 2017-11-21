package com.diogorborges.umbrella.presentation.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.diogorborges.umbrella.data.local.SharedPreferencesManager;
import com.diogorborges.umbrella.data.local.SharedPreferencesManager.UmbrellaPreferences;

import javax.inject.Inject;
import javax.inject.Named;

import static com.diogorborges.umbrella.util.Constants.CELCIUS;

public class SettingsPresenter implements SettingsContract.Presenter {

    private Context context;

    private SettingsContract.View view;

    @Inject
    public SettingsPresenter(@Named("applicationContext") Context context) {
        this.context = context;
    }

    private String loadZipCode(SharedPreferences settings) {
        String zipCode = "";
        if (hasZipCode(settings)) {
            Toast.makeText(context, "Please enter a Zip Code", Toast.LENGTH_SHORT).show();
        } else {
            zipCode = settings.getString(UmbrellaPreferences.zipCode, "");
        }
        return zipCode;
    }

    private boolean hasZipCode(SharedPreferences settings) {
        return settings.getString(UmbrellaPreferences.zipCode, "").isEmpty();
    }

    private int loadUnits(SharedPreferences settings) {
        int unitSelection;
        if (hasUnit(settings)) {
            unitSelection = 0;
        } else {
            unitSelection = 1;
        }
        return unitSelection;
    }

    private boolean hasUnit(SharedPreferences settings) {
        return settings.getString(UmbrellaPreferences.units, "").equals(CELCIUS);
    }

    @Override
    public void onViewResumed(SettingsContract.View view) {
        attachedView(view);
        loadSettings(view);
    }

    private void loadSettings(SettingsContract.View view) {
        SharedPreferences settings = context.getSharedPreferences(UmbrellaPreferences.umbrellaPrefsFile, 0);

        String zipCode = loadZipCode(settings);
        int unitSelection = loadUnits(settings);

        view.setSelectedZipCode(zipCode);
        view.setSelectedUnit(unitSelection);
    }

    private void attachedView(SettingsContract.View view) {
        this.view = view;
    }

    @Override
    public void onViewPaused(SettingsContract.View view) {
        detachView();
    }

    @Override
    public void onUserUpdateUnits(String selectedUnit) {
        applyOnSharedPreferences(UmbrellaPreferences.units, selectedUnit);
    }

    @Override
    public void onUserUpdateZipCode(String selectedZipCode) {
        Toast.makeText(context, "Zip Code Updated", Toast.LENGTH_SHORT).show();
        applyOnSharedPreferences(UmbrellaPreferences.zipCode, selectedZipCode);
    }

    private void applyOnSharedPreferences(String key, String value) {
        SharedPreferences settings = context.getSharedPreferences(UmbrellaPreferences.umbrellaPrefsFile, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        editor.apply();
    }

    private void detachView() {
        this.view = null;
    }

}
