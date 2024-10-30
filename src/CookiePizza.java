import java.util.ArrayList;

public class CookiePizza extends Pizza {
    private String cookieCrust;
    private ArrayList<String> toppings; // Manage toppings in CookiePizza

    /**
     * The constructor will need to do two things. Firstly, it will have to call super() to make
     * an ArrayList of toppings. Secondly, it will need to assign a new parameter, String cookieCrust.
     * @param orderLine a String in the format of "Cookie pizza,cookieCrust,topping,topping,etc"
     */
    public CookiePizza(String orderLine) {
        super(orderLine); // Calls the Pizza constructor
        String[] parts = orderLine.split(","); // Split the order line
        this.cookieCrust = parts[1]; // Assign cookie crust from the second part
        this.toppings = new ArrayList<>(); // Initialize toppings list

        // Add toppings from the order line
        for (int i = 2; i < parts.length; i++) {
            this.toppings.add(parts[i].trim()); // Add toppings directly to this class
        }
    }

    /**
     * calculatePrice will be $2.49 less than a normal pizza.
     * @return the price of a cookiePizza
     */
    public double calculatePrice() {
        return super.calculatePrice() - 2.49; // $2.49 less than normal pizza
    }

    /**
     * getReceipt will look exactly the same as pizza.getReceipt() but with the additional line
     * to write what cookieCrust the customer ordered.
     * @return a String to be used on the receipt
     */
    public String getReceipt() {
        StringBuilder receipt = new StringBuilder(super.getReceipt()); // Get the pizza receipt
        receipt.append("       ").append(cookieCrust).append("\n"); // Add the cookie crust

        // Append the toppings from the CookiePizza's own list
        for (String topping : toppings) {
            receipt.append("              ").append(topping).append("\n");
        }

        return receipt.toString();
    }
}
