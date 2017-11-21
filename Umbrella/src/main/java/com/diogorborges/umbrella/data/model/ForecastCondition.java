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
  @JsonProperty("dewpoint")
  private Dewpoint dewpoint;
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
  @JsonProperty("wspd")
  private Wspd wspd;
  @JsonProperty("wdir")
  private Wdir wdir;
  @JsonProperty("wx")
  private String wx;
  @JsonProperty("uvi")
  private String uvi;
  @JsonProperty("humidity")
  private String humidity;
  @JsonProperty("windchill")
  private Windchill windchill;
  @JsonProperty("heatindex")
  private Heatindex heatindex;
  @JsonProperty("feelslike")
  private Feelslike feelslike;
  @JsonProperty("qpf")
  private Qpf qpf;
  @JsonProperty("snow")
  private Snow snow;
  @JsonProperty("pop")
  private String pop;
  @JsonProperty("mslp")
  private Mslp mslp;
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

  @JsonProperty("dewpoint")
  public Dewpoint getDewpoint() {
    return dewpoint;
  }

  @JsonProperty("dewpoint")
  public void setDewpoint(Dewpoint dewpoint) {
    this.dewpoint = dewpoint;
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

  @JsonProperty("wspd")
  public Wspd getWspd() {
    return wspd;
  }

  @JsonProperty("wspd")
  public void setWspd(Wspd wspd) {
    this.wspd = wspd;
  }

  @JsonProperty("wdir")
  public Wdir getWdir() {
    return wdir;
  }

  @JsonProperty("wdir")
  public void setWdir(Wdir wdir) {
    this.wdir = wdir;
  }

  @JsonProperty("wx")
  public String getWx() {
    return wx;
  }

  @JsonProperty("wx")
  public void setWx(String wx) {
    this.wx = wx;
  }

  @JsonProperty("uvi")
  public String getUvi() {
    return uvi;
  }

  @JsonProperty("uvi")
  public void setUvi(String uvi) {
    this.uvi = uvi;
  }

  @JsonProperty("humidity")
  public String getHumidity() {
    return humidity;
  }

  @JsonProperty("humidity")
  public void setHumidity(String humidity) {
    this.humidity = humidity;
  }

  @JsonProperty("windchill")
  public Windchill getWindchill() {
    return windchill;
  }

  @JsonProperty("windchill")
  public void setWindchill(Windchill windchill) {
    this.windchill = windchill;
  }

  @JsonProperty("heatindex")
  public Heatindex getHeatindex() {
    return heatindex;
  }

  @JsonProperty("heatindex")
  public void setHeatindex(Heatindex heatindex) {
    this.heatindex = heatindex;
  }

  @JsonProperty("feelslike")
  public Feelslike getFeelslike() {
    return feelslike;
  }

  @JsonProperty("feelslike")
  public void setFeelslike(Feelslike feelslike) {
    this.feelslike = feelslike;
  }

  @JsonProperty("qpf")
  public Qpf getQpf() {
    return qpf;
  }

  @JsonProperty("qpf")
  public void setQpf(Qpf qpf) {
    this.qpf = qpf;
  }

  @JsonProperty("snow")
  public Snow getSnow() {
    return snow;
  }

  @JsonProperty("snow")
  public void setSnow(Snow snow) {
    this.snow = snow;
  }

  @JsonProperty("pop")
  public String getPop() {
    return pop;
  }

  @JsonProperty("pop")
  public void setPop(String pop) {
    this.pop = pop;
  }

  @JsonProperty("mslp")
  public Mslp getMslp() {
    return mslp;
  }

  @JsonProperty("mslp")
  public void setMslp(Mslp mslp) {
    this.mslp = mslp;
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