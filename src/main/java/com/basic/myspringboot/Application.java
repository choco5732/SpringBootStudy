package com.basic.myspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(Application.class);
		springApplication.setWebApplicationType(WebApplicationType.SERVLET);
		// Application 클래스가 시작되자마자, Myrunner 클래스가 실핼됨
		springApplication.run(args); // Runner로 args가 넘어감
		// Runner를 여러개 만들 수 있고, 그 중 Order로 우선순위를 만들 수 있음( 숫자가 작을 수록 높음 )
	}
}
