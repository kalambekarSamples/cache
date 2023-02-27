package com.bac.cache.redis.controller;

import com.bac.cache.redis.domain.Xwccsysparm;
import com.bac.cache.redis.service.XwccsysparmService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class XwccsysparmController {

    private final XwccsysparmService xwccsysparmService;

    @GetMapping("/get-xwccsysparm")
    public List<Xwccsysparm> getXwccsysparms() {
        return xwccsysparmService.getItems();
    }

    @GetMapping("/refresh-xwccsysparm")
    public List<Xwccsysparm> refreshCache() {
        xwccsysparmService.evictCache();
        return getXwccsysparms();
    }

}