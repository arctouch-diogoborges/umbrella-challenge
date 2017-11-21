package com.diogorborges.umbrella.data.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "dir",
        "degrees"
})
public class Wdir {

    @JsonProperty("dir")
    private String dir;
    @JsonProperty("degrees")
    private String degrees;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("dir")
    public String getDir() {
        return dir;
    }

    @JsonProperty("dir")
    public void setDir(String dir) {
        this.dir = dir;
    }

    @JsonProperty("degrees")
    public String getDegrees() {
        return degrees;
    }

    @JsonProperty("degrees")
    public void setDegrees(String degrees) {
        this.degrees = degrees;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
