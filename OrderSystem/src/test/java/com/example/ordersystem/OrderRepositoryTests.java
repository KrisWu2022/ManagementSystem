package com.example.ordersystem;

import com.example.ordersystem.order.Order;
import com.example.ordersystem.order.OrderRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class OrderRepositoryTests {

    @Autowired private OrderRepository repo;

    @Test
    public void testAddOrder(){

        Order order=new Order();
        order.setOrder_name("order4");
        order.setCustomer("customer4");

        java.util.Date date = new java.util.Date();
        order.setDate(date);

        order.setOrderline(4);

        Order savedOrder= repo.save(order);

        Assertions.assertThat(savedOrder).isNotNull();
        Assertions.assertThat(savedOrder.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll(){
        Iterable<Order> orders=repo.findAll();

        Assertions.assertThat(orders).hasSizeGreaterThan(0);

        for(Order order:orders){
            System.out.println(order);
        }
    }

    @Test
    public void testUpdate(){
        String customer="customer4";
        Optional<Order> optionalOrder=repo.findById(3);
        Order order=optionalOrder.get();
        order.setCustomer(customer);
        repo.save(order);

        Order updatedOrder=repo.findById(3).get();
        Assertions.assertThat(updatedOrder.getCustomer()).isEqualTo("customer4");
    }

    @Test
    public void testUpdateDate() throws ParseException {

        Date date=new Date();
        String string="2022-12-12";
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        date=dateFormat.parse(string);

        Optional<Order> optionalOrder=repo.findById(3);
        Order order=optionalOrder.get();
        order.setDate(date);
        repo.save(order);

        Order updatedOrder=repo.findById(3).get();
        Assertions.assertThat(updatedOrder.getDate()).isEqualTo(date);
    }

    @Test
    public void testGet(){

        Optional<Order> optionalOrder=repo.findById(3);
        Assertions.assertThat(optionalOrder).isPresent();
        System.out.println(optionalOrder.get());

    }

    @Test
    public void testDelete(){
        Integer orderId=4;
        repo.deleteById(orderId);

        Optional<Order> optionalOrder=repo.findById(orderId);
        Assertions.assertThat(optionalOrder).isNotPresent();
    }

}
