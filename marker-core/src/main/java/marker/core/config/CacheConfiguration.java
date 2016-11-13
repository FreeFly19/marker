package marker.core.config;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created by FreeFly on 05.11.2016.
 */
@Configuration
@EnableCaching
public class CacheConfiguration {

    @Bean
    public CacheManager hibernateCacheManager() {
        CacheManager hibernateCm = CacheManager.getCacheManager("__DEFAULT__");

        Cache cacheStudents = hibernateCm.getCache("marker.core.entity.Student");
        cacheStudents.getCacheConfiguration().setTimeToIdleSeconds(10);
        cacheStudents.getCacheConfiguration().setTimeToLiveSeconds(10);
        cacheStudents.getCacheConfiguration().setMaxEntriesLocalDisk(1000);

        return hibernateCm;
    }

    @Bean
    public EhCacheCacheManager springCacheManager() {
        net.sf.ehcache.config.Configuration springCmConfiguration = new net.sf.ehcache.config.Configuration();
        springCmConfiguration.setName("spring-cache");

        CacheManager cm = new CacheManager(springCmConfiguration);
        Cache studentsCache = new Cache("students", 1000, false, false, 10, 10);
        cm.addCache(studentsCache);

        EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager();
        ehCacheCacheManager.setCacheManager(cm);
        return ehCacheCacheManager;
    }
}
