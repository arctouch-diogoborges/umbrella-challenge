package com.diogorborges.umbrella.presentation.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.diogorborges.umbrella.R;
import com.diogorborges.umbrella.data.local.SharedPreferencesManager;
import com.diogorborges.umbrella.data.model.ForecastCondition;
import com.diogorborges.umbrella.data.model.WeatherData;
import com.diogorborges.umbrella.util.Constants;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import static android.util.TypedValue.COMPLEX_UNIT_DIP;
import static android.util.TypedValue.applyDimension;
import static com.diogorborges.umbrella.data.local.SharedPreferencesManager.*;
import static com.diogorborges.umbrella.util.Constants.*;
import static com.diogorborges.umbrella.util.Constants.TOMORROW;
import static com.diogorborges.umbrella.util.StringFormatter.getFormattedDay;


public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder> {

    private ArrayList dataSet;
    private Context context;
    private WeatherData weather;

    public ForecastAdapter(Context context, ArrayList dataSet, WeatherData weather) {
        this.context = context;
        this.weather = weather;
        this.dataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_forecast, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        ArrayList<String> hoursArray = new ArrayList<>();
        ArrayList<String> conditionArray = new ArrayList<>();
        ArrayList<Integer> tempArray = new ArrayList<>();

        String currentDate = null;

        SharedPreferences settings = context.getSharedPreferences(UmbrellaPreferences.umbrellaPrefsFile, 0);

        int hours = 0;

        List<ForecastCondition> weatherForecast = weather.getForecast();
        int size = weatherForecast.size();

        for (int i = 0; i < size; i++) {

            int actualPositionDayInt = Integer.parseInt(dataSet.get(position).toString());
            int actualDayInt = Integer.parseInt(weatherForecast.get(i).getFCTTIME().getYday()) + 1;

            if (actualPositionDayInt == actualDayInt) {

                hours++;

                hoursArray.add(weatherForecast.get(i).getFCTTIME().getCivil());

                createTemperatureArray(tempArray, settings, weatherForecast, i);

                conditionArray.add(weatherForecast.get(i).getCondition());

                Calendar calendar = Calendar.getInstance();
                int todayInt = calendar.get(Calendar.DAY_OF_YEAR);
                int tomorrowInt = todayInt + 1;

                String weekdayName = weatherForecast.get(i).getFCTTIME().getWeekdayName();
                String monthName = weatherForecast.get(i).getFCTTIME().getMonthName();
                String mDay = weatherForecast.get(i).getFCTTIME().getMday();

                currentDate = createActualDateTitle(actualPositionDayInt, todayInt, tomorrowInt, weekdayName, monthName, mDay);

            }
        }

        int min = Collections.min(tempArray);
        int max = Collections.max(tempArray);
        int minPosition = 0;
        int maxPosition = 0;

        for (int i = tempArray.size() - 1; i >= 0; i--) {
            if (tempArray.get(i).equals(min)) {
                minPosition = i;
            }
            if (tempArray.get(i).equals(max)) {
                maxPosition = i;
            }
        }

        holder.textViewDate.setText(currentDate);
        HourlyWeatherGridAdapter hourlyWeatherGridAdapter = new HourlyWeatherGridAdapter(context, hoursArray, tempArray, conditionArray, minPosition, maxPosition);
        holder.gridViewForecast.setAdapter(hourlyWeatherGridAdapter);
        createCardViewSize(holder, hours);
    }

    private void createCardViewSize(ViewHolder holder, int hours) {
        ViewGroup.LayoutParams layoutParams2 = holder.cardViewForecast.getLayoutParams();
        int rows = 0;// at least 1 row should be visible
        rows += (hours + 3) / 4;// add 1 row for each 4 elements also add 3 to the elements count as we always want to show at least 1 row
        int rowHeight = getRowHeight(rows);
        int dateHeight = 60;
        layoutParams2.height = convertDpToPixels((rows * rowHeight) + dateHeight); //this is in pixels
        holder.cardViewForecast.setLayoutParams(layoutParams2);
    }

    private int getRowHeight(int rows) {
        int rowHeight = 90;
        if (rows == 1) {
            rowHeight = 110;
        }
        if (rows == 2) {
            rowHeight = 100;
        }
        return rowHeight;
    }

    private void createTemperatureArray(ArrayList<Integer> tempArray, SharedPreferences settings, List<ForecastCondition> weatherForecast, int i) {
        int formattedTemp;
        if (isCelcius(settings)) {
            formattedTemp = Integer.parseInt(weatherForecast.get(i).getTemp().getMetric());
        } else {
            formattedTemp = Integer.parseInt(weatherForecast.get(i).getTemp().getEnglish());
        }
        tempArray.add(formattedTemp);
    }

    private boolean isCelcius(SharedPreferences settings) {
        return settings.getString(UmbrellaPreferences.units, "").equals("Celcius");
    }

    private String createActualDateTitle(int actualPositionDayInt, int todayInt, int tomorrowInt, String weekdayName, String monthName, String mDay) {
        String currentDate;
        if (actualPositionDayInt == todayInt) {
            currentDate = TODAY;
        } else if (actualPositionDayInt == tomorrowInt) {
            currentDate = TOMORROW;
        } else {
            currentDate = getFormattedDay(weekdayName, monthName, mDay);
        }
        return currentDate;
    }

    private int convertDpToPixels(float dp) {
        return (int) applyDimension(COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        GridView gridViewForecast;
        TextView textViewDate;
        CardView cardViewForecast;

        ViewHolder(View itemView) {
            super(itemView);
            textViewDate = (TextView) itemView.findViewById(R.id.textView_date);
            gridViewForecast = (GridView) itemView.findViewById(R.id.gridView_forecast);
            cardViewForecast = (CardView) itemView.findViewById(R.id.cardView_forecast);
        }
    }


    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
