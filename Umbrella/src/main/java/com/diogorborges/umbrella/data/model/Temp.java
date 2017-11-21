package com.diogorborges.umbrella.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by diogoborges on 20/11/17.
 */

public class Temp {

    @JsonProperty("english")
    private String english;

    @JsonProperty("metric")
    private String metric;

    public String getEnglish() {
        return english;
    }

    public String getMetric() {
        return metric;
    }

}
