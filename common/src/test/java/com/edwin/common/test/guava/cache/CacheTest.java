package com.edwin.common.test.guava.cache;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * 测试guava cache
 * 
 * @author jinming
 */
public class CacheTest {

    public static int INITIAL_CAPACITY  = 10;

    public static int MAX_CAPACITY      = 1000;

    public static int EXPIRE_DURATION   = 10;

    // similar to segments size in concurrentHashMap
    public static int CONCURRENCY_LEVEL = 16;

    public static <K, V> Cache<K, V> build() {

        return build(INITIAL_CAPACITY, MAX_CAPACITY, EXPIRE_DURATION, CONCURRENCY_LEVEL, TimeUnit.SECONDS);
    }

    public static <K, V> Cache<K, V> build(int init, int max, int expire, int level, TimeUnit unit) {

        Cache<K, V> cache = CacheBuilder.newBuilder().initialCapacity(init).maximumSize(max).expireAfterWrite(expire,
                                                                                                              unit).concurrencyLevel(level).build();

        return cache;
    }

}
