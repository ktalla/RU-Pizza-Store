package com.example.javafxproject;

/**
 * Stores Information about a Supreme Pizza
 * addAllToppings for this option
 * @author Ishani Mhatre
 * @author Keerthana Talla
 */
public class SupremePizza extends Pizza {

    private static String pizzaType = "Supreme"; //case of supreme speciality pizza

    /**
     * Constructor for Deluxe Pizza Object
     */
    public SupremePizza() {
        super();
        this.addAllTopings();
        this.setSauce("tomato");
    }

    /**
     * Adds all the toppings to the pizza
     */
    private void addAllTopings() {
        addTopping(Topping.SAUSAGE);
        addTopping(Topping.PEPPERONI);
        addTopping(Topping.HAM);
        addTopping(Topping.GREEN_PEPPER);
        addTopping(Topping.ONION);
        addTopping(Topping.BLACK_OLIVE);
        addTopping(Topping.MUSHROOM);
    }

    /**
     * Returns the price depending on the pizza size
     * @return 15.99 if Pizza is small, 17.99 if medium, 19.99 if large
     */
    @Override
    public double price() {
        return switch(getSize()) {
            case SMALL -> 15.99;
            case MEDIUM -> 17.99;
            case LARGE -> 19.99;
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
     * @param topping
     * @return false
     */
    public boolean add(Topping topping){
        return false;
    }

    /**
     * boolean function for abstract method located in Pizza class
     * @param topping
     * @return false
     */
    public boolean remove(Topping topping) {
        return false;
    }
}