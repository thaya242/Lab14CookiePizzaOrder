import java.util.ArrayList;

public class CookiePizza extends Pizza {
    private String cookieCrust;
    private ArrayList<String> toppings; // Manage toppings directly in this class

    public CookiePizza(String orderLine) {
        super(orderLine); // Call the parent constructor
        String[] parts = orderLine.split(","); // Split the order line
        this.cookieCrust = parts[1]; // Assign cookie crust from the second part
        this.toppings = new ArrayList<>(); // Initialize toppings list

        // Add toppings from the order line
        for (int i = 2; i < parts.length; i++) {
            String topping = parts[i].trim();
            if (!this.toppings.contains(topping)) { // Avoid duplicates
                this.toppings.add(topping);
            }
        }
    }

    public double calculatePrice() {
        return super.calculatePrice() - 2.49; // $2.49 less than a normal pizza
    }

    public String getReceipt() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("PIZZA          ").append(String.format("%.2f", calculatePrice())).append("\n"); // Format the price
        for (String topping : toppings) {
            receipt.append("              ").append(topping).append("\n"); // Properly indented toppings
        }
        receipt.append("       ").append(cookieCrust).append("\n"); // Add cookie crust at the bottom
        return receipt.toString();
    }
}
