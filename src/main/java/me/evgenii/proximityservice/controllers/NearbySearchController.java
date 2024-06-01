package me.evgenii.proximityservice.controllers;

import me.evgenii.proximityservice.dto.BusinessSearchResult;
import me.evgenii.proximityservice.dto.NearbySearchRequest;
import me.evgenii.proximityservice.dto.NearbySearchResponse;
import me.evgenii.proximityservice.services.NearbySearchService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/search")
public class NearbySearchController {
    private final NearbySearchService nearbySearchService;
    private final ModelMapper mapper;

    public NearbySearchController(NearbySearchService nearbySearchService, ModelMapper mapper) {
        this.nearbySearchService = nearbySearchService;
        this.mapper = mapper;
    }

    @GetMapping(path = "/nearby")
    public NearbySearchResponse searchNearby(@RequestBody NearbySearchRequest request) {
        var response = new NearbySearchResponse();
        response.setSize(1);
        response.setHasNext(false);
        var result = nearbySearchService.searchNearby()
                .stream()
                .map(r -> mapper.map(r, BusinessSearchResult.class))
                .toArray(BusinessSearchResult[]::new);

        response.setItems(result);
        return response;
    }
}
