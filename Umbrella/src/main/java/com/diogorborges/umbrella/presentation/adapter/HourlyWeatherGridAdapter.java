package com.diogorborges.umbrella.presentation.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.diogorborges.umbrella.R;

import java.util.ArrayList;

public class HourlyWeatherGridAdapter extends BaseAdapter {

    private Context context;

    private ArrayList hoursArray = new ArrayList<>();
    private ArrayList conditionArray = new ArrayList<>();
    private ArrayList tempArray = new ArrayList<>();

    private int minPosition = 0;
    private int maxPosition = 0;

    HourlyWeatherGridAdapter(Context context, ArrayList hoursArray, ArrayList temperatureArray,
                             ArrayList conditionArray, int minPosition, int maxPosition) {
        this.context = context;
        this.hoursArray = hoursArray;
        this.tempArray = temperatureArray;
        this.conditionArray = conditionArray;
        this.minPosition = minPosition;
        this.maxPosition = maxPosition;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView = inflater.inflate(R.layout.hourly_layout, null);

        TextView textViewHourlyHour = (TextView) gridView.findViewById(R.id.textView_hourly_hour);
        TextView textViewHourlyTemperature = (TextView) gridView.findViewById(R.id.textView_hourly_temperature);
        ImageView imageViewHourlyCondition = (ImageView) gridView.findViewById(R.id.imageView_hourly_condition);

        textViewHourlyHour.setText(hoursArray.get(position).toString());
        textViewHourlyTemperature.setText(String.format("%sº", String.valueOf(tempArray.get(position))));

        switch (conditionArray.get(position).toString()) {
            case "Rain":
                imageViewHourlyCondition.setImageResource(R.drawable.weather_rainy);
                break;
            case "Clear":
                imageViewHourlyCondition.setImageResource(R.drawable.weather_sunny);
                break;
            case "Partly Cloudy":
                imageViewHourlyCondition.setImageResource(R.drawable.weather_partlycloudy);
                break;
            case "Mostly Cloudy":
                imageViewHourlyCondition.setImageResource(R.drawable.weather_cloudy);
                break;
            default:
                imageViewHourlyCondition.setImageResource(R.drawable.weather_sunny);
                break;
        }

        Drawable drawable = DrawableCompat.wrap(imageViewHourlyCondition.getDrawable()).mutate();

        DrawableCompat.setTintList(drawable, context.getResources().getColorStateList(R.color.text_color_primary));
        textViewHourlyHour.setTextColor(context.getResources().getColorStateList(R.color.text_color_primary));
        textViewHourlyTemperature.setTextColor(context.getResources().getColorStateList(R.color.text_color_primary));

        if (position == minPosition && minPosition != maxPosition) {
            DrawableCompat.setTintList(drawable, context.getResources().getColorStateList(R.color.weather_cool));
            textViewHourlyHour.setTextColor(context.getResources().getColorStateList(R.color.weather_cool));
            textViewHourlyTemperature.setTextColor(context.getResources().getColorStateList(R.color.weather_cool));
        }
        if (position == maxPosition && minPosition != maxPosition) {
            DrawableCompat.setTintList(drawable, context.getResources().getColorStateList(R.color.weather_warm));
            textViewHourlyHour.setTextColor(context.getResources().getColorStateList(R.color.weather_warm));
            textViewHourlyTemperature.setTextColor(context.getResources().getColorStateList(R.color.weather_warm));
        }

        return gridView;
    }

    @Override
    public int getCount() {
        return hoursArray.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}
