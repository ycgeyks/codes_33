package org.crazyit.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableZuulProxy
@RestController
public class ZuulApp {

	@Autowired
	private Environment env;
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(ZuulApp.class).run(args);
	}

	@RequestMapping("/home")
	public String home() {
		return env.getProperty("test.user.name");
	}
}
