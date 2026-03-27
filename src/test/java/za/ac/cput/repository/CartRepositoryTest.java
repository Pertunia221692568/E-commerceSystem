package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Cart;
import za.ac.cput.factory.CartFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class CartRepositoryTest {

        private static final CartRepository repository = CartRepository.getInstance();
        private static final Cart cart = CartFactory.createCart("CRT-999", "USER-TEST");

        @Test
        @Order(1)
        void create() {
            Cart created = repository.create(cart);
            assertNotNull(created);
            assertEquals(cart.getCartId(), created.getCartId());
        }

        @Test
        @Order(2)
        void read() {
            Cart read = repository.read(cart.getCartId());
            assertNotNull(read);
            assertEquals("USER-TEST", read.getUserId());
        }

        @Test
        @Order(3)
        void update() {
            // Updating the userId using the Builder pattern [cite: 20]
            Cart updated = new Cart.Builder()
                    .cartId(cart.getCartId())
                    .userId("USER-UPDATED")
                    .build();

            Cart result = repository.update(updated);
            assertNotNull(result);
            assertEquals("USER-UPDATED", result.getUserId());
        }

        @Test
        @Order(4)
        void getAll() {
            List<Cart> all = repository.getAll();
            assertFalse(all.isEmpty());
        }

        @Test
        @Order(5)
        void delete() {
            boolean deleted = repository.delete(cart.getCartId());
            assertTrue(deleted);
        }
    }

