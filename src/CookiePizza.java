import java.util.ArrayList;

public class CookiePizza extends Pizza {
    private String cookieCrust;
    private ArrayList<String> toppings;

    public CookiePizza(String orderLine) {
        super(orderLine); // Call the parent constructor
        String[] parts = orderLine.split(","); // Split the order line
        this.cookieCrust = parts[1].trim(); // Get and trim the cookie crust
        this.toppings = new ArrayList<>(); // Initialize the toppings list

        // Add toppings from the order line
        for (int i = 2; i < parts.length; i++) {
            String topping = parts[i].trim();
            if (!this.toppings.contains(topping)) { // Avoid duplicates
                this.toppings.add(topping);
            }
        }
    }

    @Override
    public double calculatePrice() {
        // Assume the price for a base cookie pizza is $12.97 or as per your logic in Pizza class
        double basePrice = super.calculatePrice(); // Call the Pizza's price method
        return basePrice - 2.49; // Adjust the price for CookiePizza
    }

    @Override
    public String getReceipt() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("PIZZA          ").append(String.format("%.2f", calculatePrice())).append("\n"); // Correct price formatting
        for (String topping : toppings) {
            receipt.append("              ").append(topping.toUpperCase()).append("\n"); // Ensure toppings are upper case and properly indented
        }
        receipt.append("       ").append(cookieCrust.toUpperCase()).append("\n"); // Cookie crust at the bottom
        return receipt.toString();
    }
}
