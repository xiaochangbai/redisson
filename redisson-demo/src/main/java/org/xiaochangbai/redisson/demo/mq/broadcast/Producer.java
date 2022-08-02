package org.xiaochangbai.redisson.demo.mq.broadcast;

import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.xiaochangbai.redisson.demo.RedissonClientConfig;

/**
 * @author xiaochangbai
 * @since 2022/8/2 10:07
 */
public class Producer {

    public static final String TopicName = "Test_Topic";

    public static void main(String[] args) {
        RedissonClient redisson = RedissonClientConfig.redisson();
        RTopic topic = redisson.getTopic(Producer.TopicName);
        topic.publish("hello mq");
    }

}
