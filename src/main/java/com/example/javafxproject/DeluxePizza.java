package com.example.javafxproject;

/**
 * Stores Information about Deluxe Pizza option
 * add all toppings for Deluxe pizza
 * @author Ishani Mhatre
 * @author Keerthana Talla
 */
public class DeluxePizza extends Pizza {

    private static String pizzaType = "Deluxe"; //case of deluxe speciality pizza

    /**
     * Constructor for Deluxe Pizza Object
     */
    public DeluxePizza() {
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
        addTopping(Topping.GREEN_PEPPER);
        addTopping(Topping.ONION);
        addTopping(Topping.MUSHROOM);
    }

    /**
     * Returns the price depending on the pizza size
     * @return 14.99 if Pizza is small, 16.99 if medium, 18.99 if large
     */
    @Override
    public double price() {
        return switch(getSize()) {
            case SMALL -> 14.99;
            case MEDIUM -> 16.99;
            case LARGE -> 18.99;
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