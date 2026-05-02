package strategyPattern;

public class PaymentByCashOnDelivery implements PaymentStrategy{
    @Override
    public void collectPaymentDetails() {

    }

    @Override
    public void pay(double amount) {
        System.out.println("New Transaction");
        System.out.println(amount+"Payed Using Cash .");
    }
}
