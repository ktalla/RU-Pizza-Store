package com.example.javafxproject;

/**
 * Stores Information about a Seafood Pizza
 * addAllToppings for this option
 * @author Ishani Mhatre
 * @author Keerthana Talla
 */
public class SeafoodPizza extends Pizza {

    private static String pizzaType = "Seafood"; //case of seafod speciality pizza

    /**
     * Constructor for Deluxe Pizza Object
     */
    public SeafoodPizza() {
        super();
        this.addAllTopings();
        this.setSauce("alfredo");
    }

    /**
     * Adds all the toppings to the pizza
     */
    private void addAllTopings() {
        addTopping(Topping.SHRIMP);
        addTopping(Topping.SQUID);
        addTopping(Topping.CRAB_MEAT);
    }

    /**
     * Returns the price depending on the pizza size
     * @return 17.99 if Pizza is small, 19.99 if medium, 21.99 if large
     */
    @Override
    public double price() {
        return switch(getSize()) {
            case SMALL -> 17.99;
            case MEDIUM -> 19.99;
            case LARGE -> 21.99;
        } + hasExtraCheeseSauce();
    }

    /**
     * Gets pizza type of this object
     * @return pizza type as a string
     */
    public String getPizzaType() {
        return pizzaType;
    }

    /**
     * boolean function for abstract method located in Pizza class
     * @param topping from Topping array
     * @return false for abstract
     */
    public boolean add(Topping topping){
        return false;
    }

    /**
     * boolean function for abstract method located in Pizza class
     * @param topping from Topping array
     * @return false for abstract
     */
    public boolean remove(Topping topping) {
        return false;
    }
}