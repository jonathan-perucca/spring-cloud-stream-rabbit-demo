package com.under.integration.metric;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageSenderJob {

    private final MetricGateway metricGateway
            ;
    private int value = 0;

    @Autowired
    public MessageSenderJob(MetricGateway metricGateway) {
        this.metricGateway = metricGateway;
    }

    @Scheduled(fixedDelay = 200)
    public void sendMessage() {
        MetricData messageData = new MetricData<>("metric.message.send", ++value);

        metricGateway.generate( MessageBuilder.withPayload(messageData).build() );
        log.info("Published {}", messageData);
    }
}
