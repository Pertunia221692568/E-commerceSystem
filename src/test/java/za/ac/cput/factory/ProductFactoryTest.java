package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Product;
import static org.junit.jupiter.api.Assertions.*;

/**
 * ProductFactoryTest.java
 * TDD for Product Factory
 * Author: Sinentlantla Slayi (222133872)
 */
class ProductFactoryTest {

    @Test
    void testCreateProductSuccess() {
        Product product = ProductFactory.createProduct("MacBook Pro", 25000.00);
        assertNotNull(product);
        assertNotNull(product.getProductId());
        System.out.println("Success: " + product.toString());
    }

    @Test
    void testCreateProductFail() {
        // Testing with an invalid price (should return null)
        Product product = ProductFactory.createProduct("MacBook Pro", -10.00);
        assertNull(product);
        System.out.println("Correctly returned null for invalid input.");
    }
}
