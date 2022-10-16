package com.example.ordersystem;


import com.example.ordersystem.orderline.OrderLine;
import com.example.ordersystem.orderline.OrderLineRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class OrderLineRepositoryTests {

    @Autowired
    private OrderLineRepository repo;

    @Test
    public void testAddOrderLine(){

        OrderLine orderLine=new OrderLine();
        orderLine.setOrderline(4);
        orderLine.setProduct("product4");
        orderLine.setQuantity(4);

        OrderLine savedOrderLine= repo.save(orderLine);

        Assertions.assertThat(savedOrderLine).isNotNull();
        Assertions.assertThat(savedOrderLine.getOrderline()).isGreaterThan(0);
    }

    @Test
    public void testUpdate(){
        int quantity=10;
        Optional<OrderLine> optionalOrderLine=repo.findById(3);
        OrderLine orderLine=optionalOrderLine.get();
        orderLine.setQuantity(quantity);
        repo.save(orderLine);

        OrderLine updatedOrderLine=repo.findById(3).get();
        Assertions.assertThat(updatedOrderLine.getQuantity()).isEqualTo(10);
    }


}
