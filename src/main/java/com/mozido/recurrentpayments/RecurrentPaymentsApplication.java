package com.mozido.recurrentpayments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Rafael Richards on 06/25.
 */

@SpringBootApplication
@EnableScheduling
public class RecurrentPaymentsApplication extends  SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RecurrentPaymentsApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(RecurrentPaymentsApplication.class, args);
	}

}
