import java.util.Scanner;
import model.Product;
import service.BillingService;

public class Main {
    public static void main(String[] args) {
        BillingService service = new BillingService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Billing System ---");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    try {
                        System.out.print("Enter product name:\n");
                        String name = sc.nextLine();

                        System.out.print("Enter price:\n");
                        double price = Double.parseDouble(sc.nextLine());

                        System.out.print("Enter quantity:\n");
                        int quantity = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter tax percent:\n");
                        double taxPercent = Double.parseDouble(sc.nextLine());

                        Product p = new Product(name, price, quantity, taxPercent);
                        service.addProduct(p);
                    } catch (NumberFormatException e) {
                        System.out.println(" Invalid number input.");
                    }
                    break;

                case "2":
                    service.listProducts();
                    break;

                case "3":
                    System.out.println(" Exiting...");
                    return;

                default:
                    System.out.println(" Invalid option. Try again.");
            }
        }
    }
}
