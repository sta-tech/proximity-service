package me.evgenii.proximityservice.services;

import me.evgenii.proximityservice.data.NearbySearchCommand;
import me.evgenii.proximityservice.database.tables.pojos.BusinessLocation;

import java.util.List;

public interface NearbySearchService {
    List<BusinessLocation> searchNearby(NearbySearchCommand command);
}
