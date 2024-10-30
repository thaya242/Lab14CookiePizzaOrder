public class CookiePizza extends Pizza {
    private String cookieCrust;

    /**
     * Constructor initializes the cookie crust type and adds toppings.
     * @param orderLine a String in the format "Cookie pizza,cookieCrust,topping,topping,..."
     */
    public CookiePizza(String orderLine) {
        // Split orderLine by commas
        String[] parts = orderLine.split(",");
        
        // The second part is the cookie crust type
        cookieCrust = parts[1].trim();
        
        // Add toppings from index 2 onward
        for (int i = 2; i < parts.length; i++) {
            super.addTopping(parts[i].trim());
        }
    }

    /**
     * Calculates price, $2.49 less than a normal pizza.
     * @return the price of the cookie pizza
     */
    @Override
    public double calculatePrice() {
        return super.calculatePrice() - 2.49;
    }

    /**
     * Generates the receipt with cookie crust type and toppings.
     * @return a formatted string for the receipt
     */
    @Override
    public String getReceipt() {
        StringBuilder receipt = new StringBuilder(super.getReceipt());
        receipt.insert(0, String.format("%20s\n", cookieCrust.toUpperCase()));
        return receipt.toString();
    }
}
