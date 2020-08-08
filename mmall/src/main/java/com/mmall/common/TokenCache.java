package com.mmall.common;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author arbonkeep
 * @date 2020/4/20 - 15:41
 */
public class TokenCache {
    //声明日志
    private static Logger logger = LoggerFactory.getLogger(TokenCache.class);

    //声明token前缀
    public static final String TOKEN_PREFIX = "TOKEN_";

    //声明缓存
    // 创建一个初始化容量为1000，最大容量为10000，超过最大容量后会使用LRU算法(最小使用算法)
    private static LoadingCache<String, String> localCache = CacheBuilder.newBuilder().
            //设置缓存的初始化容量   缓存的最大容量       设置有效期为12小时
            initialCapacity(1000).maximumSize(10000).expireAfterAccess(12, TimeUnit.HOURS)

            .build(new CacheLoader<String, String>() {
                //默认的数据加载实现，当调用get取值时，如果key没有对应的值，就调用这个方法（load）进行加载
                @Override
                public String load(String key) throws Exception {
                    return "null";//这里处理为字符串（处理后面调用方法的空指针）
                }
            });

    public static void setKey(String key, String value) {
        localCache.put(key, value);
    }

    public static String getKey(String key) {
        String value = null;
        try {
            value = localCache.get(key);
            if ("null".equals(value)) {
                return null;
            }
            return value;
        } catch (Exception e) {
            logger.error("localCache get error");
        }
        return null;
    }
}