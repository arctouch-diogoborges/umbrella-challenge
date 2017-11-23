package com.diogorborges.umbrella.presentation.settings;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.diogorborges.umbrella.R;
import com.diogorborges.umbrella.UmbrellaApp;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingsActivity extends AppCompatActivity implements SettingsContract.View {

    public static final int ZIPCODE_SIZE = 5;
    @BindView(R.id.spinner_units)
    Spinner spinnerDropDownUnit;

    @BindView(R.id.editText_zipCode)
    EditText editTextZipCode;

    @BindView(R.id.button_update_zipCode)
    Button buttonUpdateZipCode;

    String[] items = new String[]{"Celcius", "Fahrenheit"};

    @Inject
    SettingsContract.Presenter presenter;

    public SettingsActivity() {
        // Constructor for Dagger
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);

        ((UmbrellaApp) getApplication()).getAppComponent().inject(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinnerDropDownUnit.setAdapter(adapter);

        initListeners();
    }

    private void initListeners() {
        buttonUpdateZipCode.setOnClickListener(onButtonUpdated());
        spinnerDropDownUnit.setOnItemSelectedListener(onSpinnerUpdated());
    }

    @NonNull
    private AdapterView.OnItemSelectedListener onSpinnerUpdated() {
        return new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                presenter.onUserUpdateUnits(spinnerDropDownUnit.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        };
    }

    @NonNull
    private View.OnClickListener onButtonUpdated() {
        return view -> {
            String selectedZipCode = editTextZipCode.getText().toString();
            if (isZipCodeFormatSize(selectedZipCode)) {
                presenter.onUserUpdateZipCode(selectedZipCode);
                return;
            }
            Toast.makeText(this, R.string.zipcode_size_error, Toast.LENGTH_SHORT).show();
        };
    }

    private boolean isZipCodeFormatSize(String selectedZipCode) {
        return selectedZipCode.length() == ZIPCODE_SIZE;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onViewResumed(this);
    }

    @Override
    public void setSelectedZipCode(String zipCode) {
        editTextZipCode.setText(zipCode);
    }

    @Override
    public void setSelectedUnit(int unit) {
        spinnerDropDownUnit.setSelection(unit);
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onViewPaused(this);
    }
}
