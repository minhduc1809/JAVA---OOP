package order;

import java.util.ArrayList;
import java.util.List;

import product.Product;
import payment.PaymentMethod;

public class Order {
    private String customerName;
    private List<Product> products;
    private PaymentMethod paymentMethod;

    public Order(String customerName, PaymentMethod paymentMethod) {
        this.customerName = customerName;
        this.paymentMethod = paymentMethod;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double getTotalAmount() {
        double sum = 0;
        for (Product p : products) {
            sum += p.getPrice();
        }
        return sum;
    }

    public void checkout() {
        double total = getTotalAmount();
        paymentMethod.pay(total, customerName);
    }
}
