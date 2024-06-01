package me.evgenii.proximityservice.controllers;

import me.evgenii.proximityservice.data.BusinessRegisterCommand;
import me.evgenii.proximityservice.dto.BusinessRegisterRequest;
import me.evgenii.proximityservice.dto.BusinessSearchResult;
import me.evgenii.proximityservice.services.BusinessRegistrationService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/business")
public class BusinessRegistrationController {
    private final BusinessRegistrationService businessRegistrationService;
    private final ModelMapper modelMapper;

    public BusinessRegistrationController(BusinessRegistrationService businessRegistrationService, ModelMapper modelMapper) {
        this.businessRegistrationService = businessRegistrationService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public BusinessSearchResult register(@RequestBody BusinessRegisterRequest request) {
        var record = businessRegistrationService.register(
                modelMapper.map(request, BusinessRegisterCommand.class)
        );

        return modelMapper.map(record, BusinessSearchResult.class);
    }
}
