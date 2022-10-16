package com.example.ordersystem;


import com.example.ordersystem.product.Product;
import com.example.ordersystem.product.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;



@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ProductRepositoryTests {


    @Autowired
    private ProductRepository repo;

    @Test
    public void testAddProduct(){
        Product product=new Product();

        product.setProduct("product3");
        product.setSkuCode(333);
        product.setUnitPrice(3.5);

        Product savedProduct= repo.save(product);

        Assertions.assertThat(savedProduct).isNotNull();
        Assertions.assertThat(savedProduct.getId()).isGreaterThan(0);
    }


}
