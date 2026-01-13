package product;

public class FoodProduct extends Product {
    private String expiryDate;

    public FoodProduct(String productId, String name, double price, String expiryDate) {
        super(productId, name, price);
        this.expiryDate = expiryDate;
    }

    @Override
    public String getInfo() {
        return "[Thực phẩm] " + name + " (HSD: " + expiryDate + ")";
    }
}
