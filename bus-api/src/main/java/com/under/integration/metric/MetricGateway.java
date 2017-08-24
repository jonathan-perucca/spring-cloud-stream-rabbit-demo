package com.under.integration.metric;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface MetricGateway {

    @Gateway(requestChannel = MetricRouteProducer.CHANNEL)
	void generate(MetricData metricData);

}