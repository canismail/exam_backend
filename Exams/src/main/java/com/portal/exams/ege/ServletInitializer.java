package com.portal.exams.ege;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ExamsPortalApplication.class);
	}

	public static void main(String[] args) {
        SpringApplication.run(ExamsPortalApplication.class, args);
	}
	
}
