package za.ac.cput.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * ProductTest.java
 * Domain test for Product Builder Pattern
 * Author: Sinentlantla Slayi (222133872)
 * Date: 27 March 2026
 */
class ProductTest {

    @Test
    void testBuilder() {
        // Testing the Builder and build() method
        Product product = new Product.Builder()
                .setProductId("P123")
                .setProductName("Gaming Laptop")
                .setPrice(25000.00)
                .build();

        assertNotNull(product);
        assertEquals("P123", product.getProductId());
        assertEquals("Gaming Laptop", product.getProductName());
        assertEquals(25000.00, product.getPrice());
        System.out.println("Build Success: " + product.toString());
    }

    @Test
    void testCopy() {
        // Creating initial product
        Product product1 = new Product.Builder()
                .setProductId("P123")
                .setProductName("Gaming Laptop")
                .setPrice(25000.00)
                .build();

        // Testing the copy() method to create a modified version
        Product product2 = new Product.Builder()
                .copy(product1)
                .setPrice(22000.00) // Changing price in the copy
                .build();

        assertNotNull(product2);
        assertEquals(product1.getProductId(), product2.getProductId()); // ID remains same
        assertNotEquals(product1.getPrice(), product2.getPrice()); // Price is different
        System.out.println("Original: " + product1);
        System.out.println("Copied & Updated: " + product2);
    }
}
