package org.xiaochangbai.redisson.demo.mq.broadcast;

import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.redisson.api.listener.MessageListener;
import org.xiaochangbai.redisson.demo.RedissonClientConfig;

/**
 * @author xiaochangbai
 * @since 2022/8/2 10:04
 */
public class Consumer3 {



    public static void main(String[] args) {
        RedissonClient redisson = RedissonClientConfig.redisson();
        RTopic topic = redisson.getTopic(Producer.TopicName);
        topic.addListener(String.class, new MessageListener<String>() {
            @Override
            public void onMessage(CharSequence channel, String msg) {
                System.out.println("收到消息："+msg);
            }
        });
    }

}
