package com.under.integration.metric;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableBinding(MetricRouteProducer.class)
public class MetricsProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetricsProducerApplication.class, args);
	}
}

