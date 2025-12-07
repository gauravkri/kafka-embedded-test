package com.grv.embedded_kafka_example;

import com.grv.embedded_kafka_example.application.Processor;
import com.grv.embedded_kafka_example.service.kafka.MessageConsumer;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;

import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;



public class KafkaEmbeddedTest extends BaseKafkatest{

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @MockitoSpyBean
    private Processor processor;



    @Test
    void should_send_and_consume_message() {
        String topic = "testone";
        String payload = "hello from test embeded";


        kafkaTemplate.send(topic, payload);


        verify(processor, timeout(5000)).handle(payload);
    }

}
