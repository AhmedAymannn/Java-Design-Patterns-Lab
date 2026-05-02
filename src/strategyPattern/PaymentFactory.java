package strategyPattern;

public class PaymentFactory {
    public static PaymentStrategy createStrategy (PaymentType type){
        return switch (type){
            case CASH -> new PaymentByCashOnDelivery();
            case CREDIT_CARD -> new PaymentBycreditCard();
            case PAYPAL -> new PaymentWithPaypal();
            default -> new PaymentByCashOnDelivery();
        };
    }
}
