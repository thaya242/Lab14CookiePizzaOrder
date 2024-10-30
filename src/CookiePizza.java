import java.util.ArrayList;

public class CookiePizza extends Pizza {
    private String cookieCrust; // Specific property for cookie pizza

    public CookiePizza(String orderLine) {
        super(orderLine); // Call the parent constructor
        String[] parts = orderLine.split(","); // Split the order line
        this.cookieCrust = parts[1].trim().toUpperCase(); // Assign cookie crust from the second part in uppercase

        // Add toppings from the order line, starting from index 2
        toppings = new ArrayList<>(); // Initialize toppings list
        for (int i = 2; i < parts.length; i++) {
            String topping = parts[i].trim().toUpperCase(); // Ensure toppings are in uppercase
            if (!this.toppings.contains(topping)) { // Avoid duplicates
                this.toppings.add(topping);
            }
        }
    }

    @Override
    public double calculatePrice() {
        // Calculate price $2.49 less than normal pizza
        return super.calculatePrice() - 2.49; // Adjust price for cookie pizza
    }

    @Override
    public String getReceipt() {
        StringBuilder receipt = new StringBuilder(super.getReceipt()); // Get base receipt
        
        // Add cookie crust at the bottom with proper alignment
        receipt.append("       ").append(cookieCrust).append("\n"); // Ensure proper alignment for the cookie crust
        return receipt.toString();
    }
}
