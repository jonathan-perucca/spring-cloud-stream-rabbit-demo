package com.under.integration.metric;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MetricConsumer {

    @StreamListener(MetricRouteConsumer.CHANNEL)
    public void listenMetrics(MetricData metricData) {
        log.info("Received {}", metricData);
    }
}
