package org.xiaochangbai.redisson.demo;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.FstCodec;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;

/**
 * @author xiaochangbai
 * @since 2022/8/2 10:00
 */
public class RedissonClientConfig {


    private static String redissonUrl = "redis://127.0.0.1:6379";

    private static String password = null;

    public static RedissonClient redisson() {
        Config config = new Config();
        SingleServerConfig useSingleServer = config.useSingleServer();
        useSingleServer.setAddress(redissonUrl);
        useSingleServer.setPassword(password);
        return Redisson.create(config);
    }

}
