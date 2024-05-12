package me.evgenii.proximityservice.dto;

public class NearbySearchResponse {
    private int size;
    private boolean hasNext;

    private BusinessSearchResult[] items;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public BusinessSearchResult[] getItems() {
        return items;
    }

    public void setItems(BusinessSearchResult[] items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "NearbySearchResponse{" +
                "size=" + size +
                ", hasNext=" + hasNext +
                '}';
    }
}
