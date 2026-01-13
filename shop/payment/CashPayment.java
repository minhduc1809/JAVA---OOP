package payment;

public class CashPayment implements PaymentMethod {
    @Override
    public void pay(double amount, String customerName) {
        System.out.println("Khách hàng: " + customerName + ". Tổng tiền: " + String.format("%,.0f", amount) 
            + " VND. Thanh toán tiền mặt thành công.");
    }
}
