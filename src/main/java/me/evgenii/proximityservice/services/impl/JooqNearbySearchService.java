package me.evgenii.proximityservice.services.impl;

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
    public List<BusinessLocation> searchNearby() {
        return context.select(BUSINESS_LOCATION.asterisk())
                .from(BUSINESS_LOCATION)
                .fetchInto(BusinessLocation.class);
    }
}
