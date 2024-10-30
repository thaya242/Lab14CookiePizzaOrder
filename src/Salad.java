public class Salad implements MenuItem {
    private String size;
    private String dressing;

    /**
     * The constructor for salad will create a salad object and assign the salad object with
     * two String variables: a size and a dressing.
     * @param orderLine a string in the format of "salad,size,dressing"
     */
    public Salad(String orderLine) {
        String[] parts = orderLine.split(",");
        if (parts.length == 3) {
            this.size = parts[1].trim();
            this.dressing = parts[2].trim();
        }
    }

    /**
     * getReceipt creates a String that is ready to be printed to a receipt that is
     * 20 characters wide.
     * @return receipt a String displaying the price of the salad and a list of its size and dressing.
     */
    @Override
    public String getReceipt() {
        return String.format("SALAD%15.2f\n%20s\n%20s\n", calculatePrice(), size.toUpperCase(), dressing.toUpperCase());
    }

    /**
     * calculatePrice calculates the price of a salad.
     * @return price a double that holds the cost of the salad
     */
    @Override
    public double calculatePrice() {
        switch (size.toLowerCase()) {
            case "small":
                return 8.50;
            case "medium":
                return 10.50;
            case "large":
                return 12.50;
            default:
                return 0.0; // or handle invalid size
        }
    }
}
