package com.example.kafka;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

/**
 * @ClassName KafkaConfigure
 * @Author Jumy
 * @Description //TODO
 * @Date 2019/6/18 9:07
 * @Version 1.0
 **/
@Configuration
public class KafkaConfigure {
    @Bean
    public KafkaTemplate<String, String> getKafkaTemplate(ProducerFactory producerFactory){
        KafkaTemplate<String, String> kafkaTemplate=new KafkaTemplate<String, String>(producerFactory);
        return kafkaTemplate;
    }
}
