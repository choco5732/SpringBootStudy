package com.basic.myspringboot.runner;

import com.basic.myspringboot.config.MyBootProperties;
import com.basic.myspringboot.config.vo.CustomerVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

// 스프링 빈
@Component
public class MyRunner implements ApplicationRunner {
    /**
     * 환경변수 값을 가져올 때
     * 1. @Value
     * 2. Envirionment ,,, getProperty() 사용 가능.
     */

    /**
     * 우선순위
     * 4. 커맨드 라인 argument
     * 15. application.properties
     */
    @Value("${myboot.name}") // ${myboot.name } 띄어쓰기나 대소문자 조심
    private String name;

    @Value("${myboot.age}")
    private int age;

    @Autowired
    private Environment environment;

    @Autowired
    private MyBootProperties properties;

    @Autowired
    private CustomerVO customerVO;

    private final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    public void run(ApplicationArguments args) throws Exception {
        logger.info("Logger 구현 클래스명 : " + logger.getClass().getName());

        logger.info("Profiles CustomerVO Mode = {}", customerVO.getMode());
        // MyBootProperties 에서 가져오기
        logger.info("MyBootProperties getFullName {}", properties.getFullName());
        logger.info("MyBootProperties getAge {}", properties.getAge());

        //  boolean containsOption(String name);
        logger.info("${myboot.name} 값은 : " + name);
        logger.info("${myboot.age} 값은 : " + age);
        logger.info("${myboot.fullName} 값은 : " + environment.getProperty("myboot.full-name"));

        logger.debug("Program Arguments foo : " + args.containsOption("foo"));
        logger.debug("VM Arguments bar : " + args.containsOption("bar"));

        //  Set<String> getOptionNames();
        //  리턴타입이 set이라 forEach() 사용 가능.
        args.getOptionNames() // Set<String>
                // forEach(Consumer) void accept(T t)
//                .forEach(name -> System.out.println(name));
//                .forEach(System.out::println);
                .forEach(name -> logger.info("Argument name : " + name));

        if (args.containsOption("spring.application.name")) {
            args.getOptionValues("spring.application.name")
                    .forEach(value -> System.out.println("Argument value : " + value));
        }

        System.out.println("Profiles customerVO Mode : " + customerVO.getMode());


        // --foo : Program Argument
        // -Dbar : VM Argument
    }
}