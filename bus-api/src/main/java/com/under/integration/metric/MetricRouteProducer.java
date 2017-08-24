package com.under.integration.metric;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MetricRouteProducer {

    String CHANNEL = "metrics";

    @Output(CHANNEL)
    MessageChannel messageChannel();
}
