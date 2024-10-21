package com.basic.myspringboot.repository;

import com.basic.myspringboot.entity.Customer;
import com.basic.myspringboot.entity.User;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional // 롤백시키기 위함
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    @Disabled
    @Rollback(value = false)
    public void user_insert() throws Exception {
        User user = new User();
        user.setName("장명용");
        user.setEmail("choco5732@gmail.com");

        User savedUser = userRepository.save(user);
        assertThat(savedUser).isNotNull();
    }


    @Test
    @Rollback(value =false)
    @Disabled
    public void update_customer() throws Exception {
        Optional<Customer> optional = customerRepository.findByCustomerId("A001");
        if(optional.isPresent()){
            Customer customer = optional.get();
            customer.setCustomerName("장명용");
        }
    }

    @Test
    @Disabled // 테스트 일시정지
    @Rollback // 기본값은 true
//    @Rollback(value = false) // 이렇게 해주면 rollback을 하지 않는다.
    public void customer() throws Exception {
        Customer customer = new Customer();
        customer.setCustomerId("A001");
        customer.setCustomerName("스프링");

        Customer addCustomer = customerRepository.save(customer);

        System.out.println(addCustomer.getCustomerId() + " " + addCustomer.getCustomerName());

        assertThat(addCustomer).isNotNull();
        assertEquals("A001", addCustomer.getCustomerId()); // assertEquals는 JUnit에서 제공되는 함수, 좌우 파라메터 순서가 바뀌면 안됨
        assertThat(addCustomer.getCustomerName()).isEqualTo("스프링"); // 따라서 assertThat을 주로 많이 쓴다.

        Optional<Customer> existCustomer = customerRepository.findByCustomerId(addCustomer.getCustomerId());
        if(existCustomer.isPresent()) {
            Customer cust = existCustomer.get();
        }
        assertThat(existCustomer).isNotEmpty();

        Optional<Customer> notExistOptional = customerRepository.findByCustomerId("B001");
//        assertThat(notExistOptional).isEmpty();
        Customer cust1 = notExistOptional.orElseThrow(
                () -> new RuntimeException("Customer not found")
        );
        System.out.println(cust1.getCustomerId());
    }
}