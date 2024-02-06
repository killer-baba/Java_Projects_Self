package org.anshuman.kafka.springboot.consumer;

// KafkaMessageConsumer.java
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageConsumer {

    @KafkaListener(topics = "${kafka.topic-name}")
    public void consume(String message) {
        // Handle the received message
        System.out.println("Received message: " + message);
    }
}
