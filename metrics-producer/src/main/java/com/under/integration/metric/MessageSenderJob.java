package com.under.integration.metric;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageSenderJob {

    private final MessageChannel metricChannel;
    private int value = 0;

    @Autowired
    public MessageSenderJob(MetricRouteProducer metricRoute) {
        this.metricChannel = metricRoute.messageChannel();
    }

    @Scheduled(fixedDelay = 200)
    public void sendMessage() {
        MetricData<Integer> messageData = new MetricData();

        messageData.setName("metric.message.send");
        messageData.setValue( ++value );

        metricChannel.send( MessageBuilder.withPayload(messageData).build() );
        log.info("Published {}", messageData);
    }
}
