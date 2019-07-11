package com.example.kafka;

        import com.google.gson.Gson;
        import com.google.gson.GsonBuilder;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.kafka.core.KafkaTemplate;
        import org.springframework.stereotype.Component;

        import java.util.Date;
        import java.util.UUID;

/**
 * @ClassName KafkaSender
 * @Author Jumy
 * @Description //TODO
 * @Date 2019/6/18 9:00
 * @Version 1.0
 **/
@Component
public class KafkaSender {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    //发送消息方法
    public void send() {
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        log.info("+++++++++++++++++++++  message = {}", gson.toJson(message));
        kafkaTemplate.send("test-1","1330000", gson.toJson(message));
    }
}