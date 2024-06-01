package me.evgenii.proximityservice.data;

public class NearbySearchCommand {
    private double latitude;
    private double longitude;
    private int radiusMeters;

    public NearbySearchCommand() {
    }

    public NearbySearchCommand(double latitude, double longitude, int radiusMeters) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radiusMeters = radiusMeters;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getRadiusMeters() {
        return radiusMeters;
    }

    public void setRadiusMeters(int radiusMeters) {
        this.radiusMeters = radiusMeters;
    }

    @Override
    public String toString() {
        return "NearbySearchCommand{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", radiusMeters=" + radiusMeters +
                '}';
    }
}
