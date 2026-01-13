package product;

public class ElectronicProduct extends Product {
    private String imei;
    private int warrantyPeriod;

    public ElectronicProduct(String productId, String name, double price, String imei, int warrantyPeriod) {
        super(productId, name, price);
        this.imei = imei;
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public String getInfo() {
        return "[Điện tử] " + name + " (IMEI: " + imei + ", BH: " + warrantyPeriod + " tháng)";
    }
}

