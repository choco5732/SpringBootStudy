package com.basic.myspringboot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component // 스프링 빈
@ConfigurationProperties("myboot") // 환경변수의 키
@Getter @Setter // 롬복의 getter, setter 활용
public class MyBootProperties {
    private String name;
    private int age;
    private String fullName;
}