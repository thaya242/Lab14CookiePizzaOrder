import java.util.ArrayList;

public class Pizza {
    protected ArrayList<String> toppings; // List of toppings
    private double basePrice; // Base price for the pizza

    /**
     * Constructor that initializes the pizza based on the order line.
     * @param orderLine a String in the format of "Pizza,topping,topping,etc"
     */
    public Pizza(String orderLine) {
        toppings = new ArrayList<>();
        String[] parts = orderLine.split(","); // Split the order line

        // Set base price (can be set according to pizza type)
        basePrice = 12.97; // Example base price; adjust as needed

        // Add toppings from the order line
        for (int i = 1; i < parts.length; i++) { // Start from 1 to skip the pizza type
            toppings.add(parts[i].trim().toUpperCase()); // Trim and add toppings in uppercase
        }
    }

    /**
     * Calculate the price of the pizza.
     * @return the total price of the pizza
     */
    public double calculatePrice() {
        // Assume each topping adds $1.00 to the price
        return basePrice + (toppings.size() * 1.00); // Example logic for toppings
    }

    /**
     * Generate the receipt for the pizza.
     * @return a String representing the pizza receipt
     */
    public String getReceipt() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("PIZZA          ").append(String.format("%.2f", calculatePrice())).append("\n"); // Format the price
        
        // Indent and format each topping
        for (String topping : toppings) {
            receipt.append("              ").append(topping).append("\n"); // Indent topping names
        }
        
        return receipt.toString();
    }
}
