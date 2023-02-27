package com.bac.cache.spring.service;

import com.bac.cache.spring.domain.AdapterDet;
import com.bac.cache.spring.repository.AdapterDetRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdapterDetService {

    private final AdapterDetRepository adapterDetRepository;

    @Cacheable(value = "adapterSpringCache")
    public List<AdapterDet> getAdaptersFromSpringCache() {
        return (List<AdapterDet>) adapterDetRepository.findAll();
    }

    @CacheEvict(value = "adapterSpringCache", allEntries = true)
    public void evictAdaperFromSpringCache() {
        System.out.println("Evicting Adapter Cache");
    }
}