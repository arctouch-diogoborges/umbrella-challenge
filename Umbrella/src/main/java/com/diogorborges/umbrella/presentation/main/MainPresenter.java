package com.diogorborges.umbrella.presentation.main;

import android.util.Log;

import javax.inject.Inject;

public class MainPresenter implements MainContract.Presenter {

    private static final String TAG = "MainPresenter";

    private MainContract.View view;

    @Inject
    public MainPresenter() {
    }


    @Override
    public void start() {

    }

    @Override
    public void onViewResumed(MainContract.View view) {
        attachedView(view);
    }

    private void attachedView(MainContract.View view) {
        this.view = view;
    }

    private boolean hasViewAttached() {
        return view != null;
    }

    @Override
    public void onViewPaused(MainContract.View view) {
        detachView();
    }

    private void detachView() {
        this.view = null;
    }

    private void defaultErrorHandling(Throwable e) {
        Log.e(TAG, Log.getStackTraceString(e));
    }


}
