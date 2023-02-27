package com.bac.cache.redis;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.embedded.RedisServer;

import java.io.IOException;

@Component
public class LocalDevelopmentEmbeddedRedisInstance {

    @Value("${spring.redis.port}")
    private int redisPort;

    private RedisServer _redisServer;

    private static final Logger LOG = LoggerFactory.getLogger(LocalDevelopmentEmbeddedRedisInstance.class);

    @PostConstruct
    public void startRedis() throws IOException {
        LOG.info("Running embedded Redis on port {}", redisPort);
        _redisServer = new RedisServer(redisPort);

        _redisServer.start();
    }


    @PreDestroy
    public void stopRedis() {
        LOG.info("Stopping embedded Redis");
        _redisServer.stop();
    }
}
