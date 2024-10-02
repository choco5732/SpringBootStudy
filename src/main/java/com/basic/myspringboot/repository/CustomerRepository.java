package com.basic.myspringboot.repository;

import com.basic.myspringboot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // JpaRepository의 제너릭에 엔티티 명과, primary key타입을 적어준다.
    Optional<Customer> findByCustomerId(String custId); // Ctrl + Shift + T 를 눌러 테스트 파일을 만들 수 있다.
}
