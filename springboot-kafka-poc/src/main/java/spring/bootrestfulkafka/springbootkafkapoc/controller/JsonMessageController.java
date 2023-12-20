package spring.bootrestfulkafka.springbootkafkapoc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.bootrestfulkafka.springbootkafkapoc.kafka.JsonKafkaProducer;
import spring.bootrestfulkafka.springbootkafkapoc.payload.User;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {


    private JsonKafkaProducer kafkaProducer;

    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("JSon message sent to kafka topic");

    }
}
