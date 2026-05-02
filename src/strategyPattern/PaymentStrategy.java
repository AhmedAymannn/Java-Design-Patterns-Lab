package strategyPattern;


public interface PaymentStrategy {
     void collectPaymentDetails();
     void pay (double amount);
}
