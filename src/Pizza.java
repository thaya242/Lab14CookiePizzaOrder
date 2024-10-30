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

        // Set a fixed base price for the pizza
        basePrice = 12.48; // Adjust as needed based on your requirements

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
        // Assuming the toppings add $1.00 each
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
        for (int i = 0; i < toppings.size(); i++) {
            String topping = toppings.get(i);
            String indentation = "              "; // Default indentation

            // Increase indentation for subsequent toppings
            if (i > 0) {
                indentation += " "; // Add additional space for each subsequent topping
            }

            receipt.append(indentation).append(topping).append("\n"); // Indent topping names
        }

        return receipt.toString();
    }
}
