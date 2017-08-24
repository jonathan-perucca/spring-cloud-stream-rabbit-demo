package com.under.integration.metric;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway
public interface MetricGateway {

    @Gateway(requestChannel = MetricRouteProducer.CHANNEL)
	void generate(Message<MetricData> metricData);


}