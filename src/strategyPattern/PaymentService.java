package strategyPattern;

public class PaymentService {
    public void checkOut (double amount , PaymentStrategy strategy){
        strategy.pay(amount);
    }
}
