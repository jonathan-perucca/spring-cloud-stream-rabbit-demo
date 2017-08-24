package com.under.integration.metric;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(MetricRouteConsumer.class)
public class MetricsConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetricsConsumerApplication.class, args);
	}
}
