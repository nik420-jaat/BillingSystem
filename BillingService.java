
package service;

import java.io.*;
import model.Product;

public class BillingService {
    private final String FILE_PATH = "data/products.txt";

    public BillingService() {
        File file = new File(FILE_PATH);
        try {
            file.getParentFile().mkdirs(); // auto-create folder
            if (!file.exists()) file.createNewFile(); // auto-create file
        } catch (IOException e) {
            System.out.println("Error initializing data file.");
        }
    }

    public void addProduct(Product product) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            bw.write(product.toString());
            bw.newLine();
            System.out.println(" Product added successfully.");
        } catch (IOException e) {
            System.out.println(" Error writing to file.");
        }
    }

    public void listProducts() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            System.out.println("\n--- Product List ---");
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                System.out.printf("Product: %-10s| \n| Price: %.2f| \n| Qty: %d| \n| Tax%%: %.2f| \n| TaxAmt: %.2f| \n| Total: %.2f|\n",
                        data[0], Double.parseDouble(data[1]), Integer.parseInt(data[2]),
                        Double.parseDouble(data[3]), Double.parseDouble(data[4]), Double.parseDouble(data[5]));
            }
        } catch (IOException e) {
            System.out.println(" Error reading from file.");
        }
    }
}
