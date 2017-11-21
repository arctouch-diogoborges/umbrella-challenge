package com.diogorborges.umbrella.presentation.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.diogorborges.umbrella.data.local.SharedPreferencesManager.UmbrellaPreferences;

import javax.inject.Inject;
import javax.inject.Named;

import static com.diogorborges.umbrella.util.Constants.CELCIUS;

public class SettingsPresenter implements SettingsContract.Presenter {

    private static final String TAG = "SettingsPresenter";

    private SettingsContract.View view;

    private Context context;

    @Inject
    public SettingsPresenter(@Named("applicationContext") Context context) {
        this.context = context;
    }

    @Override
    public void start() {
        String zipCode = "";
        int unitSelection = 0;

        SharedPreferences settings = context.getSharedPreferences(UmbrellaPreferences.umbrellaPrefsFile, 0);

        zipCode = loadZipCode(zipCode, settings);
        unitSelection = loadUnits(settings);

        view.setSelectedZipCode(zipCode);
        view.setSelectedUnit(unitSelection);
    }

    private String loadZipCode(String zipCode, SharedPreferences settings) {
        if (settings.getString(UmbrellaPreferences.zipCode, "").isEmpty()) {
            Toast.makeText(context, "Please enter a Zip Code", Toast.LENGTH_SHORT).show();
        } else {
            zipCode = settings.getString(UmbrellaPreferences.zipCode, "");
        }
        return zipCode;
    }

    private int loadUnits(SharedPreferences settings) {
        int unitSelection;
        if (settings.getString(UmbrellaPreferences.units, "").equals(CELCIUS)) {
            unitSelection = 0;
        } else {
            unitSelection = 1;
        }
        return unitSelection;
    }

    @Override
    public void onViewResumed(SettingsContract.View view) {
        attachedView(view);
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
