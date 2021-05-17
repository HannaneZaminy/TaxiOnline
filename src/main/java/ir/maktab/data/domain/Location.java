package ir.maktab.data.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Location {
    private int longitude;
    private int latitude;

    public Location(int longitude, int latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
    public Location() {

    }
    public int getLongitude() {
        return longitude;
    }

    public Location setLongitude(int longitude) {
        this.longitude = longitude;
        return this;
    }

    public int getLatitude() {
        return latitude;
    }

    public Location setLatitude(int latitude) {
        this.latitude = latitude;
        return this;
    }
}
