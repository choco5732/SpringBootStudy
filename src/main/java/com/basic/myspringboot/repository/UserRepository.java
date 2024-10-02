package com.basic.myspringboot.repository;

import com.basic.myspringboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name); // name은  unique가 아니라 결과가 여러개 나올 수 있어서 Optional -> List
    Optional<User> findByEmail(String email);

}
