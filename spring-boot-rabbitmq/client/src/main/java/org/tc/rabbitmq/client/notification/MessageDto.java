package org.tc.rabbitmq.client.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {
    private String message;
    private String exchangeName;
    private String routingKeyUsed;
}
