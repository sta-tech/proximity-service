package me.evgenii.proximityservice.services;

import me.evgenii.proximityservice.data.BusinessRegisterCommand;
import me.evgenii.proximityservice.database.tables.pojos.BusinessLocation;

public interface BusinessRegistrationService {
    BusinessLocation register(BusinessRegisterCommand command);
}
