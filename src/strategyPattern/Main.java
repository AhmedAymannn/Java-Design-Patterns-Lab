package strategyPattern;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();

        // --- Menu Display --
        System.out.println("============================");
        System.out.println("      APPLICATION MENU      ");
        System.out.println("============================");
        System.out.println("1. Pay Using Paypal");
        System.out.println("2. Pay Using Credit Card");
        System.out.println("3. Pay Using Cash");
        System.out.print("\nPlease enter your choice: ");


        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

       PaymentStrategy paymentStrategy = switch (input){
            case 1 -> PaymentFactory.createStrategy(PaymentType.PAYPAL);
            case 2 -> PaymentFactory.createStrategy(PaymentType.CREDIT_CARD);
            case 3 -> PaymentFactory.createStrategy(PaymentType.CASH);
           default -> null ;
       };
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        paymentService.checkOut(amount , paymentStrategy);
        scanner.close();
    }
}