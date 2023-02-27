package com.bac.cache.redis.controller;

import com.bac.cache.redis.domain.AdapterDet;
import com.bac.cache.redis.service.AdapterDetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AdapterController {

    private final AdapterDetService adapterDetService;

    @GetMapping("/get-adapters")
    public List<AdapterDet> getItems() {
        return adapterDetService.getItems();
    }

    @GetMapping("/refresh-adapters")
    public List<AdapterDet> refreshCache() {
        adapterDetService.evictCache();
        return getItems();
    }

}