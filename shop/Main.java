import product.*;
import payment.*;
import order.Order;

public class Main {
    public static void main(String[] args) {
        Product sp1 = new ElectronicProduct("E01", "Điện thoại ", 8000000, "123456789", 24);
        Product sp2 = new FoodProduct("F01", "Bánh quy", 50000, "12/2025");
        Product sp3 = new ElectronicProduct("E02", "Laptop", 15000000, "987654321", 36);

        Order order1 = new Order("Nguyễn Văn A", new CashPayment());
        order1.addProduct(sp1);
        order1.addProduct(sp2);
        order1.checkout();

        System.out.println();

        Order order2 = new Order("Nguyễn Văn B", new CreditCardPayment());
        order2.addProduct(sp3);
        order2.checkout();

        System.out.println();

        Order order3 = new Order("Lê Thị C", new MomoPayment());
        order3.addProduct(sp2);
        order3.checkout();
    }
}
