import java.util.ArrayList;

public class Pizza {
    protected ArrayList<String> toppings; // List of toppings
    private double basePrice; // Base price for the pizza

    /**
     * Constructor that initializes the pizza based on the order line.
     * @param orderLine a String in the format of "Pizza,topping,topping,etc"
     */
    public void addTopping(String topping) {
    toppings.add(topping);
    }

    public Pizza(String orderLine) {
        toppings = new ArrayList<>();
        String[] parts = orderLine.split(","); // Split the order line

        // Dynamically set base price according to pizza type
        basePrice = determineBasePrice(parts[0].trim().toLowerCase()); // Determine base price based on pizza type

        // Add toppings from the order line
        for (int i = 1; i < parts.length; i++) { // Start from 1 to skip the pizza type
            toppings.add(parts[i].trim().toUpperCase()); // Trim and add toppings in uppercase
        }
    }

    /**
     * Determine base price based on pizza type or size.
     * @param type the type or descriptor of the pizza
     * @return base price for the pizza
     */
    private double determineBasePrice(String type) {
        switch (type) {
            case "cookie pizza":
                return 10.48; // Adjusted price for cookie pizza
            case "pizza":
            default:
                return 12.97; // Standard price for regular pizza
        }
    }

    /**
     * Calculate the price of the pizza.
     * @return the total price of the pizza
     */
    public double calculatePrice() {
        // Assume each topping adds $1.00 to the price, but adjust as needed
        return basePrice + (toppings.size() * 1.00);
    }

    /**
     * Generate the receipt for the pizza.
     * @return a String representing the pizza receipt
     */
    public String getReceipt() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("PIZZA          ").append(String.format("%.2f", calculatePrice())).append("\n");

        // Format each topping with alignment
        for (String topping : toppings) {
            receipt.append(String.format("%15s", topping)).append("\n"); // Align toppings in a fixed-width field
        }

        return receipt.toString();
    }
}
