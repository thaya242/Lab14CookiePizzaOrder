import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerOrder {
    private ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
    private ArrayList<Salad> salads = new ArrayList<Salad>();

    /**
     * getPizzas returns the ArrayList of pizzas
     * @return pizzas
     */
   
    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    /**
     * getSalads returns the ArrayList of salads
     * @return salads
     */
    public ArrayList<Salad> getSalads() {
        return salads;
    }

    /**
     * readOrder takes in the name of a csv file and tries to create objects based on the first item in
     * each line. If the first word is "pizza" of "cookie pizza", then readOrder creates a Pizza object 
     * and saves it in the pizzas ArrayList. If the first word is "salad", then a Salad object is made 
     * and stored in  an ArrayList called "salads". You will have to make this new arrayList.
     * In the csv file, a pizza will look like "pizza,pepperoni,tomatoes,onions"
     * A salad will look like "salad,medium,ranch"
     * A cookie pizza will look like "cookie pizza,chocolate chip,strawberries,cinnamon".
     * Because a cookie pizza IS a Pizza (through inheritance), do we need to make a new ArrayList for
     * CookiePizza objects, or can we add them to the pizzas ArrayList?
     * @param filename the name of a file
     */
   //Copy your code from Lab 12 and implement the new requirements
     public void readOrder(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.toLowerCase().startsWith("pizza")) {
                    pizzas.add(new Pizza(line));
                } else if (line.toLowerCase().startsWith("cookie pizza")) {
                    pizzas.add(new CookiePizza(line)); // Create a CookiePizza object
                } else if (line.toLowerCase().startsWith("salad")) {
                    salads.add(new Salad(line));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
    /**
     * toString is the method that is called whenever an object is printed. If we were to write
     * System.out.println(customerOrder1), then the customerOrder1.toString() method would be
     * called. We will want this method to return the result of buildReceipt(). This way, we
     * don't have to write System.out.println(customerOrder1.buildReceipt()) anymore, just
     * System.out.println(customerOrder1).
     * @return the result of buildReceipt()
     */
    public String toString() {
        return buildReceipt(); // Directly return the receipt
    }

    /**
     * buildReceipt should require no changes if you correctly added your new CookiePizza objects
     * to the Pizza ArrayList!
     * @return a string containing all the receipt blocks from every item in the order.
     */
    public String buildReceipt() {
        StringBuilder receipt = new StringBuilder();
        for (Pizza pizza : pizzas) {
            receipt.append(pizza.getReceipt());
            receipt.append("--------------------\n");
        }
        for (Salad salad : salads) {
            receipt.append(salad.getReceipt());
            receipt.append("--------------------\n");
        }
        double total = calculateTotal();
        receipt.append(String.format("TOTAL:%15.2f\n", total));
        receipt.append("--------------------\n"); // Add separator before final newline
        return receipt.toString();
    }

    private double calculateTotal() {
        double total = 0.0;
        for (Pizza pizza : pizzas) {
            total += pizza.calculatePrice();
        }
        for (Salad salad : salads) {
            total += salad.calculatePrice();
        }
        return total;
    }
    /**
     * printReceipt should require no changes!
     * @param fileName the name of the file to print to.
     */
    public void printReceipt(String fileName) {
        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            writer.print(buildReceipt());
            writer.println(); // Ensure there's a newline at the end
        } catch (FileNotFoundException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
