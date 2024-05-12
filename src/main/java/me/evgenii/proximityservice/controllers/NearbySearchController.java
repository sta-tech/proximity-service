package me.evgenii.proximityservice.controllers;

import me.evgenii.proximityservice.dto.BusinessSearchResult;
import me.evgenii.proximityservice.dto.NearbySearchRequest;
import me.evgenii.proximityservice.dto.NearbySearchResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/search")
public class NearbySearchController {
    @GetMapping(path = "/nearby")
    public NearbySearchResponse searchNearby(NearbySearchRequest request) {
        var response = new NearbySearchResponse();
        response.setSize(1);
        response.setHasNext(false);
        response.setItems(
                new BusinessSearchResult[] {
                        new BusinessSearchResult(101, "McDonald's", 44.771203,20.454382)
                }
        );
        return response;
    }
}
