package com.example.kafka;

/**
 * @ClassName MyPartitioner
 * @Author Jumy
 * @Description //TODO
 * @Date 2019/7/9 9:51
 * @Version 1.0
 **/

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

public class MyPartitioner implements Partitioner {
    public int partition(String topic, Object key, byte[] bytes, Object value, byte[] bytes1, Cluster cluster) {
        //拿到主题下的分区个数
        //如果分区数不为3，那么可以进入到0号分区
        Integer count = cluster.partitionCountForTopic(topic);
        String keyString = key.toString();
        if (count == 3 && keyString != null) {
            if (keyString.startsWith("156")) {//以156开头的手机号属于联通运营商，放入分区0
                return 0;
            } else if (keyString.startsWith("139")) {//以139开头的手机号属于移动运营商，放入分区1
                return 1;
            } else if (keyString.startsWith("133")) {//以133开头的手机号属于电信运营商，放入分区2
                return 2;
            }
        }
        return 0;
    }

    public void close() {

    }

    public void configure(Map<String, ?> map) {

    }
}