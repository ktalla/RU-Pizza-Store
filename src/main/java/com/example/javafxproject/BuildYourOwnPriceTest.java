package com.example.javafxproject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit testing for finding the price of building your own pizza
 * @author Ishani Mhatre
 */
class BuildYourOwnPriceTest {

    /**
     * Test Case #1
     */
    @Test
    public void SmallPizzaWithThreeToppings() {
        // Create an instance of BuildYourOwnPizza
        BuildYourOwnPizza pizza = new BuildYourOwnPizza();

        // Set the size
        pizza.setSize(Size.SMALL);

        // Set sauce of pizza
        pizza.setSauce(Sauce.TOMATO);

        // Add 3 toppings to the pizza
        pizza.add(Topping.PEPPERONI);
        pizza.add(Topping.GREEN_PEPPER);
        pizza.add(Topping.ONION);

        // Calculate expected price
        double expectedPrice = 8.99;

        // Compare expected with the actual price
        assertEquals(expectedPrice, pizza.price(), 0.01); // Using delta for double comparison
    }

    /**
     * Test Case #2
     */
    @Test
    public void MediumPizzaWithThreeToppings() {
        BuildYourOwnPizza pizza = new BuildYourOwnPizza();
        pizza.setSize(Size.MEDIUM);
        pizza.setSauce(Sauce.ALFREDO);
        pizza.add(Topping.BACON);
        pizza.add(Topping.CRAB_MEAT);
        pizza.add(Topping.BLACK_OLIVE);

        double expectedPrice = 10.99;
        assertEquals(expectedPrice, pizza.price(), 0.01);
    }

    /**
     * Test Case #3
     */
    @Test
    public void LargePizzaWithThreeToppings() {
        // Create an instance of BuildYourOwnPizza
        BuildYourOwnPizza pizza = new BuildYourOwnPizza();

        // Set the size
        pizza.setSize(Size.LARGE);

        // Set sauce of pizza
        pizza.setSauce(Sauce.TOMATO);

        // Add 3 toppings to the pizza
        pizza.add(Topping.PEPPERONI);
        pizza.add(Topping.GREEN_PEPPER);
        pizza.add(Topping.ONION);

        // Calculate expected price
        double expectedPrice = 12.99;

        // Compare expected with the actual price
        assertEquals(expectedPrice, pizza.price(), 0.01); // Using delta for double comparison
    }

    /**
     * Test Case #4
     */    @Test
    public void LargePizzaWithThreeToppingsExtraCheeseExtraSauce() {
        BuildYourOwnPizza pizza = new BuildYourOwnPizza();
        pizza.setSize(Size.LARGE);
        pizza.setSauce(Sauce.TOMATO);
        pizza.add(Topping.PEPPERONI);
        pizza.add(Topping.GREEN_PEPPER);
        pizza.add(Topping.ONION);
        pizza.setExtraCheese(true);
        pizza.setExtraSauce(true);

        double expectedPrice = 14.99; // 12.99 (base price) + 2 (extra cheese and extra sauce)
        assertEquals(expectedPrice, pizza.price(), 0.01);
    }

    /**
     * Test Case #5
     */

    @Test
    public void MediumPizzaWithSevenToppingsAndExtraCheeseSauce() {
        BuildYourOwnPizza pizza = new BuildYourOwnPizza();
        pizza.setSize(Size.MEDIUM);
        pizza.setSauce(Sauce.ALFREDO);
        pizza.add(Topping.ONION);
        pizza.add(Topping.MUSHROOM);
        pizza.add(Topping.HAM);
        pizza.add(Topping.BLACK_OLIVE);
        pizza.add(Topping.BEEF);
        pizza.add(Topping.SHRIMP);
        pizza.add(Topping.SQUID);
        pizza.add(Topping.CRAB_MEAT);
        pizza.setExtraCheese(true);
        pizza.setExtraSauce(false);

        double expectedPrice = 21.42;
        assertEquals(expectedPrice, pizza.price(), 0.01);
    }

    /**
     * Test Case #6
     */
    @Test
    public void MediumPizzaWithOverSevenToppings() {
        BuildYourOwnPizza pizza = new BuildYourOwnPizza();
        pizza.setSize(Size.MEDIUM);
        pizza.setSauce(Sauce.TOMATO);
        pizza.add(Topping.HAM);
        pizza.add(Topping.BEEF);
        pizza.add(Topping.SQUID);
        pizza.add(Topping.MUSHROOM);
        pizza.add(Topping.JALAPENOS);
        pizza.add(Topping.SHRIMP);
        pizza.add(Topping.BACON);
        pizza.add(Topping.SAUSAGE);
        pizza.add(Topping.BLACK_OLIVE);

        double expectedPrice = 19.93;
        assertEquals(expectedPrice, pizza.price(), 0.01);
    }

    /**
     * Test Case #7
     */
    @Test
    public void LargePizzaWithFourToppingsExtraCheeseSauce() {
        BuildYourOwnPizza pizza = new BuildYourOwnPizza();
        pizza.setSize(Size.LARGE);
        pizza.setSauce(Sauce.TOMATO);
        pizza.add(Topping.SAUSAGE);
        pizza.add(Topping.JALAPENOS);
        pizza.add(Topping.GREEN_PEPPER);
        pizza.add(Topping.ONION);
        pizza.setExtraCheese(true);
        pizza.setExtraSauce(true);

        double expectedPrice = 16.48;
        assertEquals(expectedPrice, pizza.price(), 0.01);
    }

}