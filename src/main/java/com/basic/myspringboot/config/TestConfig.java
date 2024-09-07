package com.basic.myspringboot.config;

import com.basic.myspringboot.config.vo.CustomerVO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration // 설정 역할을 한다는 클래스임을 알려줌.
@Profile("test")
public class TestConfig {
    @Bean
    public CustomerVO customer() {
        return CustomerVO.builder()
                .id(200L)
                .mode("개발환경")
                .build();
    }
}


// Bean의 이름은 메서드 이름으로 결정된다.
// 만약 Bean의 이름이 같다면 에러가 발생한다.
// profile을 사용해 해결.