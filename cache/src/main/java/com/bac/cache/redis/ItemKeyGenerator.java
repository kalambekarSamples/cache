package com.bac.cache.redis;

import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;

/*
 * TODO : Can make use of this generator when we want to update individual cache
 */
public class ItemKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object target, Method method, Object... params) {
        StringBuilder key = new StringBuilder(target.getClass().getSimpleName() + "." + method.getName());
        for (Object param : params) {
            key.append(param.toString());
        }
        return key.toString();
    }
}
