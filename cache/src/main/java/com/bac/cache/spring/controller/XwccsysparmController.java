package com.bac.cache.spring.controller;

import com.bac.cache.spring.service.XwccsysparmService;
import com.bac.cache.spring.domain.Xwccsysparm;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class XwccsysparmController {

    private final XwccsysparmService xwccsysparmService;

    @GetMapping("/get-xwccsysparm-from-spring-cache")
    public List<Xwccsysparm> getXwccsysparmsFromSpringCache() {
        return xwccsysparmService.getSysparmFromSpring();
    }

    @GetMapping("/refresh-xwccsysparm-from-spring-cache")
    public List<Xwccsysparm> refreshCacheFromSpringCache() {
        xwccsysparmService.evictCacheFromSpring();
        return getXwccsysparmsFromSpringCache();
    }

}