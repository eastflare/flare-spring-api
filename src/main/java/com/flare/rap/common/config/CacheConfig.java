package com.flare.rap.common.config;

import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.spi.CachingProvider;

import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.jsr107.Eh107Configuration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.flare.rap.message.model.MessageSimpleVO;

@Configuration
@EnableCaching
public class CacheConfig {
    @Bean
    public CacheManager EhcacheManager() {

        CacheConfiguration<String, MessageSimpleVO> cachecConfig =
                CacheConfigurationBuilder
                .newCacheConfigurationBuilder(String.class,
                        MessageSimpleVO.class,
                        ResourcePoolsBuilder.newResourcePoolsBuilder()
                                .heap(30, MemoryUnit.MB)
                                .offheap(40, MemoryUnit.MB)
                                .build())
                .withExpiry(ExpiryPolicyBuilder.noExpiration())
                .build();

        CachingProvider cachingProvider = Caching.getCachingProvider();
        CacheManager cacheManager = cachingProvider.getCacheManager();

        javax.cache.configuration.Configuration<String, MessageSimpleVO> configuration =
                Eh107Configuration.fromEhcacheCacheConfiguration(cachecConfig);
        cacheManager.createCache("i18nCache", configuration);

        return cacheManager;
    }
}