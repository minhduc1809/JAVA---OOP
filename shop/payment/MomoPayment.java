package payment;

public class MomoPayment implements PaymentMethod {
    @Override
    public void pay(double amount, String customerName) {
        System.out.println("Khách hàng: " + customerName + ". Tổng tiền: " + String.format("%,.0f", amount)
            + " VND. Thanh toán qua ví Momo thành công.");
    }
}

