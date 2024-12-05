import java.io.Serializable;
import java.util.LinkedList;

public class ShoppingCart implements Serializable {

    private double totalPrice;
    private LinkedList<BoughtProduct> cart;

    public ShoppingCart() {
        totalPrice = 0;
        cart = new LinkedList<BoughtProduct>();
    }

    public void addBoughtProduct(BoughtProduct boughtProduct) {
        totalPrice += boughtProduct.getPrice();
        cart.add(boughtProduct);
    }

    public void viewShoppingCart() {
        for (var product : cart) {
            product.display();
        }
    }

    public boolean isEmpty() {
        return cart.size() == 0;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
