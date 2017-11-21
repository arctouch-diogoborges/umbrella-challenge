package com.diogorborges.umbrella.presentation.settings;

import android.util.Log;

import com.diogorborges.umbrella.presentation.main.MainContract;

import javax.inject.Inject;

public class SettingsPresenter implements SettingsContract.Presenter {

    private static final String TAG = "SettingsPresenter";

    private SettingsContract.View view;

    @Inject
    public SettingsPresenter() {
    }


    @Override
    public void start() {

    }

    @Override
    public void onViewResumed(SettingsContract.View view) {
        attachedView(view);
    }

    private void attachedView(SettingsContract.View view) {
        this.view = view;
    }

    private boolean hasViewAttached() {
        return view != null;
    }

    @Override
    public void onViewPaused(SettingsContract.View view) {
        detachView();
    }

    @Override
    public void onUserUpdateUnits(String selectedUnit) {

    }

    @Override
    public void onUserUpdateZipCode(String selectedZipCode) {

    }

    private void detachView() {
        this.view = null;
    }

    private void defaultErrorHandling(Throwable e) {
        Log.e(TAG, Log.getStackTraceString(e));
    }


}
