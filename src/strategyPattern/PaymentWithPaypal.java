package strategyPattern;

public class PaymentWithPaypal implements PaymentStrategy{

    @Override
    public void collectPaymentDetails() {

    }

    @Override
    public void pay(double amount) {
        System.out.println("New Transaction");
        System.out.println(amount+"Payed Using Paypal .");
    }
}
