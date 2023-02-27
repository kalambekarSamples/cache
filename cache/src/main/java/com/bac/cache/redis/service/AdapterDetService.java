package com.bac.cache.redis.service;

import com.bac.cache.redis.domain.AdapterDet;
import com.bac.cache.redis.repository.AdapterDetRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdapterDetService {

    private final AdapterDetRepository adapterDetRepository;


    @Cacheable(value = "adapterRedisCache", keyGenerator = "itemKeyGenerator")
    public List<AdapterDet> getItems() {
        return (List<AdapterDet>) adapterDetRepository.findAll();
    }

    @CacheEvict(value = "adapterRedisCache", allEntries = true)
    public void evictCache() {
        System.out.println("Evicting Adapter Cache");
    }
}