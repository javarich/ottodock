package com.ottodock.core;

import java.time.Instant;

public class DockMetric {
    private int dockId;
    private double north;
    private double east;
    private double down;
    private float temp;
    private float windspeed;
    private Instant metricTs;

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

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(float windspeed) {
        this.windspeed = windspeed;
    }

    public Instant getMetricTs() {
        return metricTs;
    }

    public void setMetricTs(Instant metricTs) {
        this.metricTs = metricTs;
    }

}
