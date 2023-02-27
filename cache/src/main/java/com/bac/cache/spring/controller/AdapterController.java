package com.bac.cache.spring.controller;

import com.bac.cache.spring.service.AdapterDetService;
import com.bac.cache.spring.domain.AdapterDet;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AdapterController {

    private final AdapterDetService adapterDetService;

    @GetMapping("/get-adapters-from-spring-cache")
    public List<AdapterDet> getAdaptersFromSpringCache() {
        return adapterDetService.getAdaptersFromSpringCache();
    }

    @GetMapping("/refresh-adapters-from-spring-cache")
    public List<AdapterDet> refreshAdaptersFromSpringCache() {
        adapterDetService.evictAdaperFromSpringCache();
        return getAdaptersFromSpringCache();
    }

}