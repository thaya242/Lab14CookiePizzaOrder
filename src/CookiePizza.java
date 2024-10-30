import java.util.ArrayList;

public class CookiePizza extends Pizza {
    private String cookieCrust;

    public CookiePizza(String orderLine) {
        super(orderLine); // Calls the Pizza constructor
        String[] parts = orderLine.split(",");
        this.cookieCrust = parts[1];

        for (int i = 2; i < parts.length; i++) {
            super.addTopping(parts[i].trim()); // Call the method from Pizza
        }
    }

    public double calculatePrice() {
        return super.calculatePrice() - 2.49;
    }

    public String getReceipt() {
        StringBuilder receipt = new StringBuilder(super.getReceipt());
        receipt.append("       ").append(cookieCrust).append("\n");
        return receipt.toString();
    }
}
