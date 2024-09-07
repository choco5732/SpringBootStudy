package com.basic.myspringboot.config;

import com.basic.myspringboot.config.vo.CustomerVO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration // 설정 역할을 한다는 클래스임을 알려줌.
@Profile("prod")
public class ProdConfig {
    @Bean
    public CustomerVO customer() {
        return CustomerVO.builder()
                .id(200L)
                .mode("운영환경")
                .build();
    }
}

/**
 *
 *
 *
 * 공통점
 * 둘 다 스프링 Bean임
 *
 * Bean과 Component의 차이점
 * Bean : 메서드에 선언 ElementType.METHOD
 * Component : 클래스에 선언 ElementType.TYPE
 */