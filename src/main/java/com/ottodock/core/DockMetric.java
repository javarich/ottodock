package com.ottodock.core;

import java.sql.Timestamp;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DockMetric {
    private int dockId;
    private double north;
    private double east;
    private double down;
    private float temperature;
    private float windSpeed;
    private Timestamp metricTs = Timestamp.from(Instant.now());

    public int getDockId() {
        return dockId;
    }

    public void setDockId(int dockId) {
        this.dockId = dockId;
    }

    public double getNorth() {
        return north;
    }

    public void setNorth(double north) {
        this.north = north;
    }

    public double getEast() {
        return east;
    }

    public void setEast(double east) {
        this.east = east;
    }

    public double getDown() {
        return down;
    }

    public void setDown(double down) {
        this.down = down;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windspeed) {
        this.windSpeed = windspeed;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    public Timestamp getMetricTs() {
        return metricTs;
    }

    public void setMetricTs(Timestamp metricTs) {
        this.metricTs = metricTs;
    }

}
