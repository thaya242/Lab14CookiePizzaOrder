import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerOrder {
    private ArrayList<Pizza> pizzas = new ArrayList<>();
    private ArrayList<Salad> salads = new ArrayList<>();

    /**
     * Returns the list of pizzas.
     * @return pizzas
     */
    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    /**
     * Returns the list of salads.
     * @return salads
     */
    public ArrayList<Salad> getSalads() {
        return salads;
    }

    /**
     * Reads orders from a file and creates objects based on the first word in each line.
     * @param filename the name of a file
     */
    public void readOrder(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.toLowerCase().startsWith("pizza")) {
                    pizzas.add(new Pizza(line));
                } else if (line.toLowerCase().startsWith("cookie pizza")) {
                    pizzas.add(new CookiePizza(line));
                } else if (line.toLowerCase().startsWith("salad")) {
                    salads.add(new Salad(line));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    /**
     * Calls buildReceipt() for generating a receipt.
     * @return the generated receipt as a string
     */
    @Override
    public String toString() {
        return buildReceipt();
    }

    /**
     * Builds the receipt with all items in the order.
     * @return a formatted string for the entire order
     */
    public String buildReceipt() {
        StringBuilder receipt = new StringBuilder();
        for (Pizza pizza : pizzas) {
            receipt.append(pizza.getReceipt()).append("--------------------\n");
        }
        for (Salad salad : salads) {
            receipt.append(salad.getReceipt()).append("--------------------\n");
        }
        receipt.append(String.format("TOTAL:%15.2f\n", calculateTotal()))
               .append("--------------------\n");
        return receipt.toString();
    }

    /**
     * Calculates the total cost of the order.
     * @return the total price
     */
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
     * Prints the receipt to a specified file.
     * @param fileName the name of the file to print to
     */
    public void printReceipt(String fileName) {
        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            writer.print(buildReceipt());
            writer.println();
        } catch (FileNotFoundException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
