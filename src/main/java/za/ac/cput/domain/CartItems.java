package za.ac.cput.domain;

public class CartItems {

    private String cartItemId;
    private String cartId;
    private String productId;
    private int quantity;

    // Private constructor for the Builder
    private CartItems(Builder builder) {
        this.cartItemId = builder.cartItemId;
        this.cartId = builder.cartId;
        this.productId = builder.productId;
        this.quantity = builder.quantity;
    }

    // Getters
    public String getCartItemId() {
        return cartItemId;
    }

    public String getCartId() {
        return cartId;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }


    @Override
    public String toString() {
        return "CartItem{" +
                "cartItemId='" + cartItemId + '\'' +
                ", cartId='" + cartId + '\'' +
                ", productId='" + productId + '\'' +
                ", quantity=" + quantity +
                '}';
    }


    public static class Builder {
        private String cartItemId;
        private String cartId;
        private String productId;
        private int quantity;

        public Builder cartItemId(String cartItemId) {
            this.cartItemId = cartItemId;
            return this;
        }

        public Builder cartId(String cartId) {
            this.cartId = cartId;
            return this;
        }

        public Builder productId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public CartItems build() {
            return new CartItems(this);
        }
    }
}


