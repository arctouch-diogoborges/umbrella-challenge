
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
        "conditions",
        "hourly"
})
public class Features {

    @JsonProperty("conditions")
    private Integer conditions;
    @JsonProperty("hourly")
    private Integer hourly;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("conditions")
    public Integer getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(Integer conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("hourly")
    public Integer getHourly() {
        return hourly;
    }

    @JsonProperty("hourly")
    public void setHourly(Integer hourly) {
        this.hourly = hourly;
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
