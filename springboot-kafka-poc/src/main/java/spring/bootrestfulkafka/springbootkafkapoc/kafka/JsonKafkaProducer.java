package spring.bootrestfulkafka.springbootkafkapoc.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import spring.bootrestfulkafka.springbootkafkapoc.payload.User;

@Service
public class JsonKafkaProducer {


    private KafkaTemplate kafkaTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

   public  JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate){
       this.kafkaTemplate = kafkaTemplate;
   }

   public void sendMessage(User data){

       LOGGER.info(String.format("message received ->%s" , data.toString()));

       Message<User> message = MessageBuilder.withPayload(data).setHeader(KafkaHeaders.TOPIC, "guides").build();
kafkaTemplate.send(message);
   }

}
