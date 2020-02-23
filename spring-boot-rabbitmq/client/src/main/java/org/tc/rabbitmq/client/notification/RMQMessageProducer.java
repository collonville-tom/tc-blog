package org.tc.rabbitmq.client.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RMQMessageProducer {

    @Autowired
    private AmqpTemplate template;

    @Value("${notification.exchange.myExchangeA.name}")
    private String myExchangeA;

    @Value("${notification.exchange.myExchangeA.message.flux1}")
    private String flux1A;

    @Value("${notification.exchange.myExchangeA.message.flux2}")
    private String flux2A;

    @Value("${notification.exchange.myExchangeB.name}")
    private String myExchangeB;

    @Value("${notification.exchange.myExchangeB.message.flux1}")
    private String flux1B;

    @Value("${notification.exchange.myExchangeB.message.flux2}")
    private String flux2B;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void sendDirectToQueueA() {
        MessageDto message = MessageDto.builder().message("Hello World!").exchangeName(myExchangeA).routingKeyUsed(flux1A).build();
        this.template.convertAndSend(myExchangeA, flux1A, message);
        log.debug(" Envoie " + message);
    }

    @Scheduled(fixedDelay = 1250, initialDelay = 500)
    public void sendDirectToQueueB() {
        MessageDto message = MessageDto.builder().message("Hello World!").exchangeName(myExchangeA).routingKeyUsed(flux2A).build();
        this.template.convertAndSend(myExchangeA, flux2A, message);
        log.debug(" Envoie " + message  );
    }


    @Scheduled(fixedDelay = 500, initialDelay = 500)
    public void sendTopicToQueueA() {
        MessageDto message = MessageDto.builder().message("Hello World!").exchangeName(myExchangeB).routingKeyUsed(flux1B).build();
        this.template.convertAndSend(myExchangeB, flux1B, message);
        log.debug(" Envoie " + message);
    }

    @Scheduled(fixedDelay = 2000, initialDelay = 500)
    public void sendTopicToQueueB() {
        MessageDto message = MessageDto.builder().message("Hello World!").exchangeName(myExchangeB).routingKeyUsed(flux2B).build();
        this.template.convertAndSend(myExchangeB, flux2B, message);
        log.debug(" Envoie " + message  );
    }

    @Scheduled(fixedDelay = 5000, initialDelay = 500)
    public void sendTopicTo() {
        MessageDto message = MessageDto.builder().message("Hello World!").exchangeName(myExchangeB).routingKeyUsed("flux1.flux2").build();
        this.template.convertAndSend(myExchangeB, "flux1.flux2", message);
        log.debug(" Envoie " + message  );
    }

}
