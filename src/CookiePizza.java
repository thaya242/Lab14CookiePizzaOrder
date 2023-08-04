public class CookiePizza extends Pizza{
    private String cookieCrust;

    /**
     * The constructor will need to do two things. Firstly, it will have to call super() to make
     * an ArrayList of toppings. Secondly, it will need to assign a new parameter, String cookieCrust.
     * Also note that the Pizza constructor usually expects a string of "Pizza,topping,topping,etc". Our
     * new orderLine string follows a different format.
     * @param orderLine a String in the format of "Cookie pizza,cookieCrust,topping,topping,etc"
     */
    public CookiePizza(String orderLine){
        //TODO Student
    }

    /**
     * calculatePrice will be $2.49 less than a normal pizza. It will be useful to call Pizza's
     * calculatePrice method.
     * @return the price of a cookiePizza
     */
    public double calculatePrice(){
        //TODO Student
    }

    /**
     * getReceipt will look exactly the same as pizza.getReceipt() but with the additional line
     * to write what cookieCrust the customer ordered. For a cookie pizza with strawberries as a topping
     * and a chocolate chip crust, the method will create the following:
     * PIZZA           8.99
     *         STRAWBERRIES
     *       CHOCOLATE CHIP
     * Super will also be useful here to prevent us from repeating our code.
     * @return a String to be used on the receipt
     */
    public String getReceipt(){
        //TODO Student
    }
}
