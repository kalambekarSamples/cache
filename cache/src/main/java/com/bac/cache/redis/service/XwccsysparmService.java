package com.bac.cache.redis.service;

import com.bac.cache.redis.domain.Xwccsysparm;
import com.bac.cache.redis.repository.XwccsysparmRepository;
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

    @Cacheable(value = "xwccsysparmRedisCache", keyGenerator = "itemKeyGenerator")
    public List<Xwccsysparm> getItems() {
        return (List<Xwccsysparm>) xwccsysparmRepository.findAll();
    }

    @CacheEvict(value = "xwccsysparmRedisCache", allEntries = true)
    public void evictCache() {
        System.out.println("Evicting Xwccsysparm Cache");
    }
}