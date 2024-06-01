package me.evgenii.proximityservice.services.impl;

import ch.hsr.geohash.GeoHash;
import me.evgenii.proximityservice.data.NearbySearchCommand;
import me.evgenii.proximityservice.database.tables.pojos.BusinessLocation;
import me.evgenii.proximityservice.services.NearbySearchService;
import org.jooq.DSLContext;
import org.springframework.stereotype.Component;

import java.util.List;

import static me.evgenii.proximityservice.database.Tables.BUSINESS_LOCATION;

@Component
public class JooqNearbySearchService implements NearbySearchService {
    private final DSLContext context;

    public JooqNearbySearchService(DSLContext context) {
        this.context = context;
    }

    @Override
    public List<BusinessLocation> searchNearby(NearbySearchCommand command) {
        var hash = GeoHash.geoHashStringWithCharacterPrecision(
                command.getLatitude(),
                command.getLongitude(),
                5
        );

        return context.select(BUSINESS_LOCATION.asterisk())
                .from(BUSINESS_LOCATION)
                .where(BUSINESS_LOCATION.GEO_HASH.startsWith(hash))
                .fetchInto(BusinessLocation.class);
    }
}
