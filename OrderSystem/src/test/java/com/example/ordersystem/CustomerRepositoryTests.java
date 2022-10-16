package com.example.ordersystem;

import com.example.ordersystem.customer.Customer;
import com.example.ordersystem.customer.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CustomerRepositoryTests {

    @Autowired
    private CustomerRepository repo;

    @Test
    public void testAddCustomer(){
        Customer customer=new Customer();

        customer.setCustomer("customer3");
        customer.setEmail("email3@gmail.com");
        customer.setTelephone(32345678);
        customer.setRegistrationCode(323);

        Customer savedCustomer= repo.save(customer);

        Assertions.assertThat(savedCustomer).isNotNull();
        Assertions.assertThat(savedCustomer.getId()).isGreaterThan(0);
    }
}
