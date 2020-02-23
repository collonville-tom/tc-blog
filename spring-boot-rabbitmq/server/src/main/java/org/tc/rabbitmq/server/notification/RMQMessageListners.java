package org.tc.rabbitmq.server.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RMQMessageListners {


    @RabbitListener(queues = "${notification.queue.myQueueA}")
    public void listenQueueA(MessageDto message) {
        log.debug("Message receive with myQueueA: "+message);
    }

    @RabbitListener(queues = "${notification.queue.myQueueB}")
    public void listenQueueB(MessageDto message) {
        log.debug("Message receive with myQueueB: "+message);
    }

}
