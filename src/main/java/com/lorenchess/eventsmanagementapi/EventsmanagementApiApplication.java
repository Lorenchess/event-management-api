package com.lorenchess.eventsmanagementapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.convert.Jsr310Converters;

@SpringBootApplication
@EntityScan(basePackageClasses = {EventsmanagementApiApplication.class, Jsr310Converters.class})
public class EventsmanagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventsmanagementApiApplication.class, args);
	}

}
