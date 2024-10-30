public class CookiePizza extends Pizza {

    /**
     * Constructor that initializes a CookiePizza order with toppings.
     * @param orderLine a String in the format of "Cookie Pizza,topping,topping,etc"
     */
    public CookiePizza(String orderLine) {
        super(orderLine);
        this.basePrice = super.calculatePrice() - 2.49; // Ensures cookie pizza has the correct base price adjustment
    }

    /**
     * Overrides getReceipt to properly align receipt for CookiePizza.
     */
    @Override
    public String getReceipt() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("PIZZA          ").append(String.format("%.2f", basePrice)).append("\n");
        
        for (String topping : toppings) {
            receipt.append(String.format("%15s", topping)).append("\n"); // Align toppings with the same fixed-width formatting
        }

        return receipt.toString();
    }
}
