package me.evgenii.proximityservice.dto;

public class BusinessSearchResult {
    private int id;
    private String name;
    private double latitude;
    private double longitude;

    public BusinessSearchResult() {
    }

    public BusinessSearchResult(int id, String name, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "BusinessSearchResult{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
