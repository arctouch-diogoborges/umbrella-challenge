package com.diogorborges.umbrella.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;

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
        "FCTTIME",
        "temp",
        "dewpoint",
        "condition",
        "icon",
        "icon_url",
        "fctcode",
        "sky",
        "wspd",
        "wdir",
        "wx",
        "uvi",
        "humidity",
        "windchill",
        "heatindex",
        "feelslike",
        "qpf",
        "snow",
        "pop",
        "mslp"
})
public class ForecastCondition {

  @JsonProperty("FCTTIME")
  private FCTTIME fCTTIME;
  @JsonProperty("temp")
  private Temp temp;
  @JsonProperty("condition")
  private String condition;
  @JsonProperty("icon")
  private String icon;
  @JsonProperty("icon_url")
  private String iconUrl;
  @JsonProperty("fctcode")
  private String fctcode;
  @JsonProperty("sky")
  private String sky;
  @JsonProperty("wx")
  private String wx;
  @JsonProperty("uvi")
  private String uvi;
  @JsonProperty("humidity")
  private String humidity;
  @JsonProperty("pop")
  private String pop;

  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("FCTTIME")
  public FCTTIME getFCTTIME() {
    return fCTTIME;
  }

  @JsonProperty("FCTTIME")
  public void setFCTTIME(FCTTIME fCTTIME) {
    this.fCTTIME = fCTTIME;
  }

  @JsonProperty("temp")
  public Temp getTemp() {
    return temp;
  }

  @JsonProperty("temp")
  public void setTemp(Temp temp) {
    this.temp = temp;
  }

  @JsonProperty("condition")
  public String getCondition() {
    return condition;
  }

  @JsonProperty("condition")
  public void setCondition(String condition) {
    this.condition = condition;
  }

  @JsonProperty("icon")
  public String getIcon() {
    return icon;
  }

  @JsonProperty("icon")
  public void setIcon(String icon) {
    this.icon = icon;
  }

  @JsonProperty("icon_url")
  public String getIconUrl() {
    return iconUrl;
  }

  @JsonProperty("icon_url")
  public void setIconUrl(String iconUrl) {
    this.iconUrl = iconUrl;
  }

  @JsonProperty("fctcode")
  public String getFctcode() {
    return fctcode;
  }

  @JsonProperty("fctcode")
  public void setFctcode(String fctcode) {
    this.fctcode = fctcode;
  }

  @JsonProperty("sky")
  public String getSky() {
    return sky;
  }

  @JsonProperty("sky")
  public void setSky(String sky) {
    this.sky = sky;
  }

  @JsonProperty("wx")
  public String getWx() {
    return wx;
  }

  @JsonProperty("wx")
  public void setWx(String wx) {
    this.wx = wx;
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