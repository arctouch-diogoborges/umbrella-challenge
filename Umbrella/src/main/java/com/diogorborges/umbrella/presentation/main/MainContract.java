package com.diogorborges.umbrella.presentation.main;

public interface MainContract {

    interface View {

        void showContent();

        void showError();

    }

    interface Presenter {

        void start();

        void onViewResumed(View view);

        void onViewPaused(View view);

    }

}
