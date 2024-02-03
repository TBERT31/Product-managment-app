package com.company.springbootrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import javax.servlet.Filter;

@SpringBootApplication
public class SpringbootrestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootrestapiApplication.class, args);
	}

	@Bean
	public Filter filter(){
		ShallowEtagHeaderFilter filter = new ShallowEtagHeaderFilter();
		return filter;
	}

}
