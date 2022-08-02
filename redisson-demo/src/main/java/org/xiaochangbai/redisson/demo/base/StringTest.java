package org.xiaochangbai.redisson.demo.base;

import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.xiaochangbai.redisson.demo.RedissonClientConfig;

/**
 * @author xiaochangbai
 * @since 2022/8/2 11:38
 */
public class StringTest {


    public static void main(String[] args) {
        RedissonClient redisson = RedissonClientConfig.redisson();

        RBucket<Object> rBucket = redisson.getBucket("hello");
        rBucket.set("啊啥啊");
        System.out.println("成功");
    }

}
