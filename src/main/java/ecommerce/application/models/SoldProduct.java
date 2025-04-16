package ecommerce.application.models;

public record SoldProduct(ProductInfo info, int quantitySold) {

    public double getPrice() {
        return info.getPrice();
    }
}
