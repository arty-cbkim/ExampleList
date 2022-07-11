package com.example.examplelist.chart;

public class SensorData {
    private String temp;
    private String hum;
    private String cds;
    private String time;

    @Override
    public String toString() {
        return "SensorData{" +
                "temp='" + temp + '\'' +
                ", hum='" + hum + '\'' +
                ", cds='" + cds + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getHum() {
        return hum;
    }

    public void setHum(String hum) {
        this.hum = hum;
    }

    public String getCds() {
        return cds;
    }

    public void setCds(String cds) {
        this.cds = cds;
    }
}
