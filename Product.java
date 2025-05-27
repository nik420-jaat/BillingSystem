
package model;

public class Product {
    private String productName;
    private double price;
    private int quantity;
    private double taxPercent;

    public Product(String productName, double price, int quantity, double taxPercent) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.taxPercent = taxPercent;
    }

    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public double getTaxPercent() { return taxPercent; }

    public double getTaxAmount() {
        return (price * quantity) * (taxPercent / 100);
    }

    public double getTotal() {
        return (price * quantity) + getTaxAmount();
    }

    @Override
    public String toString() {
        return productName + "," + price + "," + quantity + "," + taxPercent + "," +
               getTaxAmount() + "," + getTotal();
    }
}
