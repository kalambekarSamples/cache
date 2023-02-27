package com.bac.cache.spring.service;

import com.bac.cache.spring.domain.Xwccsysparm;
import com.bac.cache.spring.repository.XwccsysparmRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class XwccsysparmService {

    private final XwccsysparmRepository xwccsysparmRepository;

    @Autowired
    private CacheManager cacheManager;

    @Cacheable(value = "xwccsysparmSpringCache")
    public List<Xwccsysparm> getSysparmFromSpring() {
        return (List<Xwccsysparm>) xwccsysparmRepository.findAll();
    }

    @CacheEvict(value = "xwccsysparmSpringCache", allEntries = true)
    public void evictCacheFromSpring() {
        System.out.println("Evicting Xwccsysparm Cache");
    }
}