package ecommerce.application.models.product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class ShoppingCart implements Serializable {
    private BigDecimal value = BigDecimal.ZERO;
    private final List<SoldProduct> cart;

    public ShoppingCart() {
        value = new BigDecimal(0);
        cart = new LinkedList<>();
    }

    public ShoppingCart(Product product, int amount) {
        this.value = this.value.add(product.getPrice());

        cart = new LinkedList<>();
        cart.add(new SoldProduct(product.getInfo(), amount));
    }

    public void addProduct(SoldProduct product) {
        this.value = this.value.add(product.info().getPrice().multiply(new BigDecimal(product.amount())));
        cart.add(product);
    }

    @Override
    public String toString() {
        StringBuilder cartInfo = new StringBuilder();
        for (var product : cart) {
            cartInfo.append(product);
        }

        return cartInfo.toString();
    }

    public boolean isEmpty() { return cart.isEmpty(); }

    public BigDecimal getValue() { return value; }
}
