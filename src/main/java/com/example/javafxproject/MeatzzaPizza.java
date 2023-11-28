package com.example.javafxproject;

/**
 * Stores Information about a Meatzza Pizza
 * addAllToppings for this option
 * @author Ishani Mhatre
 * @author Keerthana Talla
 */
public class MeatzzaPizza extends Pizza {

    private static String pizzaType = "Meatzza"; //case of meatzza speciality pizza

    /**
     * Constructor for Deluxe Pizza Object
     */
    public MeatzzaPizza() {
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
        addTopping(Topping.BEEF);
        addTopping(Topping.HAM);
    }

    /**
     * Returns the price depending on the pizza size
     * @return 16.99 if Pizza is small, 18.99 if medium, 20.99 if large
     */
    @Override
    public double price() {
        return switch(getSize()) {
            case SMALL -> 16.99;
            case MEDIUM -> 18.99;
            case LARGE -> 20.99;
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
     * @param topping for topping selected based on array list
     * @return false
     */
    public boolean add(Topping topping){
        return false;
    }

    /**
     * boolean function for abstract method located in Pizza class
     * @param topping for topping selected based on array list
     * @return false
     */
    public boolean remove(Topping topping) {
        return false;
    }
}