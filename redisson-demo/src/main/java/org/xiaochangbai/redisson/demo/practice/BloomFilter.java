package org.xiaochangbai.redisson.demo.practice;

import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.xiaochangbai.redisson.demo.RedissonClientConfig;

public class BloomFilter {


    public static void main(String[] args) {
        bloomFilter();
    }

    public static void bloomFilter() {
        RedissonClient cient = RedissonClientConfig.redisson();
        RBloomFilter<String> bloomFilter = cient.getBloomFilter("test5-bloom-filter");
        // 初始化布隆过滤器，数组长度 100W，误判率 1%
        bloomFilter.tryInit(1000000L, 0.01);
        // 添加数据
        bloomFilter.add("小马哥");
        bloomFilter.add("小马啊");
        // 判断是否存在
        System.out.println(bloomFilter.contains("小马"));
        System.out.println(bloomFilter.contains("小马哦"));
        System.out.println(bloomFilter.contains("小马哥"));
    }

}
