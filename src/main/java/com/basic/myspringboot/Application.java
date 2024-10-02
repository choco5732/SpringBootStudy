package com.basic.myspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(Application.class);
		springApplication.setWebApplicationType(WebApplicationType.SERVLET);
		// Application 클래스가 시작 되자마자, Myrunner 클래스가 실핼됨
		springApplication.run(args); // Runner로 args가 넘어감
		// Runner를 여러개 만들 수 있고, 그 중 Order로 우선순위를 만들 수 있음( 숫자가 작을 수록 높음 )

	}
}


/**
 *
 * @RestController = @Controller + @ResponseBody
 * 직렬화 : Java -> Json
 * 역직렬화 : Json -> Java
 *
 * @ResponseBody : 변환된 데이터를 응답(response)body에 담아 주는 역할 (변환은 Jackson이 담당) Java -> Json
 * @RequestBody : 변환된 데이터를 요청(request)에 담아서 컨트롤러의 아규먼트로 매핑 해주는 역할 Json -> Java
 *
 * API (Application Programming Interface)
 * 기업과 데이터를 주고받을 때, 어떻게 요청하는지, 무엇을 받을 수 있는지에 대한 설명을 API라고 함.
 *
 * REST (REpresentational State Transfer)
 * 로이 필딩(HTTP 만든사람)이 웹의 HTTP의 설계 우수성을 잘 활용하지 못하는걸 보고 탄식하며, 만든 아키텍쳐가 REST
 * 따라서, HTTP프로토콜 의도에 맞게 사용하도록 유도하는 아키텍쳐가 REST이다.
 * 분산시스템 설계를 위한 아키텍처 스타일, 다양한 제약조건의 집합
 *
 * REST의 제약조건
 * 1. Client/Server 구조 : 둘이 독립적임 -> cors문제 발생 -> AJAX 통신할 때, 서로 도메인이 같아야하는데 Client와 Server가 독립적이어서 도메인이 달라 문제 발생
 * 2. Stateless : Clinet와 Server가 완전히 별개 즉, 독립적이기에 세션과 쿠키같은 걸 사용하지 않는다.
 * 3. Cache : 그러나 캐시 처리기능은 제공함.
 * 4. Layered System(계층화)
 *
 * RESTful
 * REST라는 아키텍처 스타일이 있고, REST에서 아키텍처 원칙을 모두 만족하는 API를 RESTful이라고 함.
 *
 * REST의 구성요소
 * 자원과 행위
 * 자원 : URI (명사)
 * 행위 : Method (동사) : GET, POST, PUT, DELETE
 */