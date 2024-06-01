package me.evgenii.proximityservice.services.impl;

import ch.hsr.geohash.GeoHash;
import me.evgenii.proximityservice.data.BusinessRegisterCommand;
import me.evgenii.proximityservice.database.tables.pojos.BusinessLocation;
import me.evgenii.proximityservice.services.BusinessRegistrationService;
import org.jooq.DSLContext;
import org.springframework.stereotype.Component;

import static me.evgenii.proximityservice.database.Tables.BUSINESS_LOCATION;

@Component
public class JooqBusinessRegistrationService implements BusinessRegistrationService {
    private final DSLContext context;

    public JooqBusinessRegistrationService(DSLContext context) {
        this.context = context;
    }

    @Override
    public BusinessLocation register(BusinessRegisterCommand command) {
        var record = context.newRecord(BUSINESS_LOCATION);
        record.setName(command.getName());
        record.setLatitude(command.getLatitude());
        record.setLongitude(command.getLongitude());
        record.setGeoHash(getGeoHash(command.getLatitude(), command.getLongitude()));
        record.insert();

        return record.into(BusinessLocation.class);
    }

    private String getGeoHash(double latitude, double longitude) {
        return GeoHash.geoHashStringWithCharacterPrecision(latitude, longitude, 8);
    }
}
