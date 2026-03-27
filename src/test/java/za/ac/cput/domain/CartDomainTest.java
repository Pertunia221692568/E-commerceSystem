package za.ac.cput.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.factory.CartFactory;

import static org.junit.jupiter.api.Assertions.*;

class CartDomainTest {

    private Cart cart;
    private  String TEST_CART_ID = "CRT-001";
    private  String TEST_USER_ID = "USER-ABC";

    @BeforeEach
    void setUp() {
        // Create a cart before each test
        cart = CartFactory.createCart(TEST_CART_ID, TEST_USER_ID);
    }

    @Test
    void testCartCreation() {
        assertNotNull(cart);
        assertEquals(TEST_CART_ID, cart.getCartId());
        assertEquals(TEST_USER_ID, cart.getUserId());
    }

    @Test
    void testCartBuilder() {
        // Test builder pattern directly
        Cart customCart = new Cart.Builder()
                .cartId("CRT-002")
                .userId("USER-XYZ")
                .build();

        assertNotNull(customCart);
        assertEquals("CRT-002", customCart.getCartId());
        assertEquals("USER-XYZ", customCart.getUserId());
    }

    @Test
    void testCartToString() {
        String expected = "Cart [cartId=" + TEST_CART_ID + ", userId=" + TEST_USER_ID + "]";
        assertEquals(expected, cart.toString());
    }

    @Test
    void testCartEquality() {
        Cart sameCart = CartFactory.createCart(TEST_CART_ID, TEST_USER_ID);
        Cart differentCart = CartFactory.createCart("CRT-002", "USER-XYZ");

        // Note: Since Cart doesn't override equals(), these will be different objects
        assertNotEquals(cart, sameCart);
        assertNotEquals(cart, differentCart);

        // But they should have same values when created with same parameters
        assertEquals(cart.getCartId(), sameCart.getCartId());
        assertEquals(cart.getUserId(), sameCart.getUserId());
    }

    @Test
    void testCartWithEmptyUserId() {
        // Testing that cart can be created with empty userId (but not null)
        Cart cartWithEmptyUserId = new Cart.Builder()
                .cartId("CRT-003")
                .userId("")
                .build();

        assertNotNull(cartWithEmptyUserId);
        assertEquals("CRT-003", cartWithEmptyUserId.getCartId());
        assertEquals("", cartWithEmptyUserId.getUserId());
    }

    @Test
    void testCartWithNullValuesViaBuilder() {
        // Testing that builder allows null values
        Cart cartWithNulls = new Cart.Builder()
                .cartId(null)
                .userId(null)
                .build();

        assertNotNull(cartWithNulls);
        assertNull(cartWithNulls.getCartId());
        assertNull(cartWithNulls.getUserId());
    }

    @Test
    void testCartGetters() {
        // Test getter methods
        assertNotNull(cart.getCartId());
        assertNotNull(cart.getUserId());
        assertEquals(TEST_CART_ID, cart.getCartId());
        assertEquals(TEST_USER_ID, cart.getUserId());
    }

    @Test
    void testCartBuilderChaining() {
        // Test that builder chaining works correctly
        Cart chainedCart = new Cart.Builder()
                .cartId("CHAIN-001")
                .userId("CHAIN-USER")
                .build();

        assertNotNull(chainedCart);
        assertEquals("CHAIN-001", chainedCart.getCartId());
        assertEquals("CHAIN-USER", chainedCart.getUserId());
    }

    @Test
    void testMultipleCartInstances() {
        // Test creating multiple cart instances
        Cart cart1 = CartFactory.createCart("MULTI-001", "USER-001");
        Cart cart2 = CartFactory.createCart("MULTI-002", "USER-002");
        Cart cart3 = CartFactory.createCart("MULTI-003", "USER-003");

        assertNotNull(cart1);
        assertNotNull(cart2);
        assertNotNull(cart3);

        assertNotEquals(cart1.getCartId(), cart2.getCartId());
        assertNotEquals(cart2.getCartId(), cart3.getCartId());
        assertNotEquals(cart1.getUserId(), cart2.getUserId());
    }

    @Test
    void testCartWithSpecialCharacters() {
        // Test cart with special characters in IDs
        Cart specialCart = CartFactory.createCart("CRT-@#$%", "USER-123!@#");

        assertNotNull(specialCart);
        assertEquals("CRT-@#$%", specialCart.getCartId());
        assertEquals("USER-123!@#", specialCart.getUserId());
    }

    @Test
    void testCartWithLongIds() {
        // Test with very long IDs
        String longCartId = "CRT-" + "A".repeat(100);
        String longUserId = "USER-" + "B".repeat(100);

        Cart longCart = CartFactory.createCart(longCartId, longUserId);

        assertNotNull(longCart);
        assertEquals(longCartId, longCart.getCartId());
        assertEquals(longUserId, longCart.getUserId());
    }
}