package com.example.javafxproject;

/**
 * Stores Information about a Pepperoni Pizza
 * addAllToppings for this option
 * @author Ishani Mhatre
 * @author Keerthana Talla
 */
public class PepperoniPizza extends Pizza {

    private static String pizzaType = "Pepperoni"; //case of pepperoni speciality pizza

    /**
     * Constructor for Deluxe Pizza Object
     */
    public PepperoniPizza() {
        super();
        this.addAllTopings();
        this.setSauce("tomato");
    }

    /**
     * Adds all the toppings to the pizza
     */
    private void addAllTopings() {
        addTopping(Topping.PEPPERONI);
    }

    /**
     * Returns the price depending on the pizza size
     * @return 10.99 if Pizza is small, 12.99 if medium, 14.99 if large
     */
    @Override
    public double price() {
        return switch(getSize()) {
            case SMALL -> 10.99;
            case MEDIUM -> 12.99;
            case LARGE -> 14.99;
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
     * @param topping from topping array based on user input
     * @return false
     */
    public boolean add(Topping topping){
        return false;
    }

    /**
     * boolean function for abstract method located in Pizza class
     * @param topping from topping array based on user input
     * @return false
     */
    public boolean remove(Topping topping) {
        return false;
    }
}