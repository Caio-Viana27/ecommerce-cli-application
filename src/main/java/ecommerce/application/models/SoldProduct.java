package ecommerce.application.models;

public record SoldProduct(ProductInfo info, String id, int quantitySold) {

    public double getPrice() {
        return info.getPrice();
    }
}
