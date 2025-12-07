package com.grv.embedded_kafka_example;

import com.grv.embedded_kafka_example.application.EmbeddedKafkaExampleApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = EmbeddedKafkaExampleApplication.class)
@ActiveProfiles("test")
class EmbeddedKafkaExampleApplicationTests {

	@Test
	void contextLoads() {
	}

}
