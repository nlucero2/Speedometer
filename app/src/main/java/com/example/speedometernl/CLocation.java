package com.example.speedometernl;

import android.location.Location;
import android.location.LocationListener;

public class CLocation extends Location {

    private boolean useMetricUnits = false;


    public CLocation(Location location) {
        this(location, false);
    }//end constructor I


    public CLocation(Location location, boolean useMetricUnits) {
        super(location);
        this.useMetricUnits = useMetricUnits;
    }//end constructor II


    public boolean getUseMetricUnits() {
        return this.useMetricUnits;
    }//end getUseMetricUnits

    public void setUseMetricUnits(boolean useMetricUnits) {
        this.useMetricUnits = useMetricUnits;
    }//end getUseMetricUnits


    @Override
    public float distanceTo(Location dest) {
        float nDistance = super.distanceTo(dest);

        if (!this.getUseMetricUnits()) {
            nDistance = nDistance * 3.28083989501312f;        //meters to feet
        }//end if

        return nDistance;
    }//end distanceTo

    @Override
    public double getAltitude() {
        double nAltitude = super.getAltitude();

        if (!this.getUseMetricUnits()) {
            nAltitude = nAltitude * 3.28083989501312d;        //meters to feet
        }//end if

        return nAltitude;
    }//end getAltitude

    @Override
    public float getSpeed() {
        float nSpeed = super.getSpeed() * 3.6f;

        if (!this.getUseMetricUnits()) {
            nSpeed = super.getSpeed() * 2.23693629f;        //meters/sec to miles/hr
        }//end if

        return nSpeed;
    }//end getSpeed

    @Override
    public float getAccuracy() {
        float nAccuracy = super.getAccuracy();

        if (!this.getUseMetricUnits()) {
            nAccuracy = nAccuracy * 3.28083989501312f;        //meters to feet
        }//end if

        return nAccuracy;
    }//end getAccuracy



}//end CLocation Class
