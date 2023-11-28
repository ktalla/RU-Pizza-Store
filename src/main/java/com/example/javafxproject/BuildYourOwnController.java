package com.example.javafxproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Backend controller for Build your own pizza option which handles user's inputs for size and toppings
 * @author Ishani Mhatre
 * @author Keerthana Talla
 */
public class BuildYourOwnController {

    private Pizza pizza;

    private static StoreOrders storeOrder; //new object of store orders

    private static Order currOrder;

    // private List<Topping> toppings = new ArrayList<>();

    final static int MIN_TOPPINGS = 3; //min toppings with no additional cost
    final static int MAX_TOPPINGS = 7; //max toppings with no additional cost
    final static double INITIAL_PRICE = 0.0; //initial price
    final static double SMALL_PRICE = 8.99; //small pizza price
    final static double MEDIUM_PRICE = 10.99; //medium pizza price
    final static double LARGE_PRICE = 12.99; //large pizza price
    final static double EXTRA_TOPPINGS_COST = 1.49; //extra cost for every topping more than 3


    @FXML
    private CheckBox sausageCheckBox; //sausage topping option

    @FXML
    private CheckBox pepperoniCheckBox; //pepperoni topping option

    @FXML
    private CheckBox greenPepperCheckBox; //green pepper topping option

    @FXML
    private CheckBox onionCheckBox; //onion topping option

    @FXML
    private CheckBox mushroomCheckBox; //mushroom topping option

    @FXML
    private CheckBox hamCheckBox; //ham topping option

    @FXML
    private CheckBox blackOliveCheckBox; //black olives option

    @FXML
    private CheckBox beefCheckBox; //beef topping option

    @FXML
    private CheckBox shrimpCheckBox; //shrimp topping option

    @FXML
    private CheckBox squidCheckBox; //squid topping option

    @FXML
    private CheckBox crabMeatCheckBox; //crab meat option

    @FXML
    private CheckBox jalapenosCheckBox; //jalapenos topping option

    @FXML
    private CheckBox baconCheckBox; //bacon option
    @FXML
    private RadioButton small;
    @FXML
    private RadioButton medium;
    @FXML
    private RadioButton large;
    @FXML
    private ToggleGroup size; //pizza size option

    @FXML
    private ToggleGroup sauce; //pizza sauce option

    @FXML
    private CheckBox extraCheeseCheckbox; //extra cheese option

    @FXML
    private CheckBox extraSauceCheckbox; //extra sauce option

    @FXML
    private TextField price; //display pizza price

    /**
     * Initializes new pizza by calling Pizza Maker class
     * Initializes size, sauce, and price
     */
    @FXML
    public void initialize() {
        // Initialize pizza with a default type (Deluxe in this case)
        pizza = PizzaMaker.createPizza("buildyourown");
        pizza.setSize(((RadioButton) this.size.getSelectedToggle()).getText());
        pizza.setSauce(((RadioButton) this.sauce.getSelectedToggle()).getText());
        price.setText(String.format("%.2f", pizza.price()));
    }

    /**
     * Handles the price changes based on when the user selects and unselects different toppings
     */
    @FXML
    private void handlePizzaSelection() {
        // Check each checkbox and add the corresponding topping to the list
        if (sausageCheckBox.isSelected() && !pizza.getToppings().contains(Topping.SAUSAGE)) {
            pizza.add(Topping.SAUSAGE);
            price.setText(String.format("%.2f", pizza.price()));
        }

        if (!sausageCheckBox.isSelected() && pizza.getToppings().contains(Topping.SAUSAGE)) {
            pizza.remove(Topping.SAUSAGE);
            price.setText(String.format("%.2f", pizza.price()));
        }

        if (pepperoniCheckBox.isSelected() && !pizza.getToppings().contains(Topping.PEPPERONI)) {
            pizza.add(Topping.PEPPERONI);
            price.setText(String.format("%.2f", pizza.price()));
        }

        if (!pepperoniCheckBox.isSelected() && pizza.getToppings().contains(Topping.PEPPERONI)) {
            pizza.remove(Topping.PEPPERONI);
            price.setText(String.format("%.2f", pizza.price()));
        }

        if (greenPepperCheckBox.isSelected() && !pizza.getToppings().contains(Topping.GREEN_PEPPER)) {
            pizza.add(Topping.GREEN_PEPPER);
            price.setText(String.format("%.2f", pizza.price()));
        }

        if (!greenPepperCheckBox.isSelected() && pizza.getToppings().contains(Topping.GREEN_PEPPER)) {
            pizza.remove(Topping.GREEN_PEPPER);
            price.setText(String.format("%.2f", pizza.price()));
        }

        if (onionCheckBox.isSelected() && !pizza.getToppings().contains(Topping.ONION)) {
            pizza.add(Topping.ONION);
            price.setText(String.format("%.2f", pizza.price()));
        }

        if (!onionCheckBox.isSelected() && pizza.getToppings().contains(Topping.ONION)) {
            pizza.remove(Topping.ONION);
            price.setText(String.format("%.2f", pizza.price()));
        }

        if (mushroomCheckBox.isSelected() && !pizza.getToppings().contains(Topping.MUSHROOM)) {
            pizza.add(Topping.MUSHROOM);
            price.setText(String.format("%.2f", pizza.price()));
        }

        if (!mushroomCheckBox.isSelected() && pizza.getToppings().contains(Topping.MUSHROOM)) {
            pizza.remove(Topping.MUSHROOM);
            price.setText(String.format("%.2f", pizza.price()));
        }

        if (hamCheckBox.isSelected() && !pizza.getToppings().contains(Topping.HAM)) {
            pizza.add(Topping.HAM);
            price.setText(String.format("%.2f", pizza.price()));
        }

        if (!hamCheckBox.isSelected() && pizza.getToppings().contains(Topping.HAM)) {
            pizza.remove(Topping.HAM);
            price.setText(String.format("%.2f", pizza.price()));
        }

        else if (blackOliveCheckBox.isSelected() && !pizza.getToppings().contains(Topping.BLACK_OLIVE)) {
            pizza.add(Topping.BLACK_OLIVE);
            price.setText(String.format("%.2f", pizza.price()));
        }

        else if (!blackOliveCheckBox.isSelected() && pizza.getToppings().contains(Topping.BLACK_OLIVE)) {
            pizza.remove(Topping.BLACK_OLIVE);
            price.setText(String.format("%.2f", pizza.price()));
        }

        else if (beefCheckBox.isSelected() && !pizza.getToppings().contains(Topping.BEEF)) {
            pizza.add(Topping.BEEF);
            price.setText(String.format("%.2f", pizza.price()));
        }

        else if (!beefCheckBox.isSelected() && pizza.getToppings().contains(Topping.BEEF)) {
            pizza.remove(Topping.BEEF);
            price.setText(String.format("%.2f", pizza.price()));
        }

        else if (shrimpCheckBox.isSelected() && !pizza.getToppings().contains(Topping.SHRIMP)) {
            pizza.add(Topping.SHRIMP);
            price.setText(String.format("%.2f", pizza.price()));
        }

        else if (!shrimpCheckBox.isSelected() && pizza.getToppings().contains(Topping.SHRIMP)) {
            pizza.remove(Topping.SHRIMP);
            price.setText(String.format("%.2f", pizza.price()));
        }

        else if (squidCheckBox.isSelected() && !pizza.getToppings().contains(Topping.SQUID)) {
            pizza.add(Topping.SQUID);
            price.setText(String.format("%.2f", pizza.price()));
        }

        else if (!squidCheckBox.isSelected() && pizza.getToppings().contains(Topping.SQUID)) {
            pizza.remove(Topping.SQUID);
            price.setText(String.format("%.2f", pizza.price()));
        }

        else if (crabMeatCheckBox.isSelected() && !pizza.getToppings().contains(Topping.CRAB_MEAT)) {
            pizza.add(Topping.CRAB_MEAT);
            price.setText(String.format("%.2f", pizza.price()));
        }

        else if (!crabMeatCheckBox.isSelected() && pizza.getToppings().contains(Topping.CRAB_MEAT)) {
            pizza.remove(Topping.CRAB_MEAT);
            price.setText(String.format("%.2f", pizza.price()));
        }

        else if (jalapenosCheckBox.isSelected() && !pizza.getToppings().contains(Topping.JALAPENOS)) {
            pizza.add(Topping.JALAPENOS);
            price.setText(String.format("%.2f", pizza.price()));
        }

        else if (!jalapenosCheckBox.isSelected() && pizza.getToppings().contains(Topping.JALAPENOS)) {
            pizza.remove(Topping.JALAPENOS);
            price.setText(String.format("%.2f", pizza.price()));
        }

        else if (baconCheckBox.isSelected() && !pizza.getToppings().contains(Topping.BACON)) {
            pizza.add(Topping.BACON);
            price.setText(String.format("%.2f", pizza.price()));
        }

        else if (!baconCheckBox.isSelected() && pizza.getToppings().contains(Topping.BACON)) {
            pizza.remove(Topping.BACON);
            price.setText(String.format("%.2f", pizza.price()));
        }
        price.setText(String.format("%.2f", pizza.price()));

    }



    /**
     * Builds the pizza and handles exceptions for too little or not enough toppings
     * @return true or false based on if valid pizza
     */
    @FXML
    public boolean isValidPizza() {
        System.out.println("hi");

        if (pizza.getToppings().size() > MAX_TOPPINGS) {
            createAlert("Toppings", "Too Many Toppings Selected", "Please select 3-7 toppings.");
            return false;
        }
        if (pizza.getToppings().size() < MIN_TOPPINGS) {
            createAlert("Toppings", "Too Less Toppings Selected", "Please select 3-7 toppings.");
            return false;
        }
        if (size.getSelectedToggle() == null || sauce.getSelectedToggle()==null){
            createAlert("Missing Information", "Additional Information Required", "Please ensure size and sauce are selected.");
            return false;
        }
        return true;
    }



    /**
     * create Alert function for error handling
     * @param title of type String for pizza
     * @param header of type String
     * @param content of type String
     */
    private void createAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    /**
     * Set size based on user input and update price display
     */
    @FXML
    public void setSize() {
        pizza.setSize(((RadioButton) this.size.getSelectedToggle()).getText());
        price.setText(String.format("%.2f", pizza.price()));
    }

    /**
     * Set sauce based on user input
     */
    @FXML
    public void setSauce() {
        pizza.setSauce(((RadioButton) this.sauce.getSelectedToggle()).getText());
        price.setText(String.format("%.2f", pizza.price()));
    }

    /**
     * Set extraCheese boolean as true or false based on user input and update price display
     */
    @FXML
    public void setExtraCheese() {
        pizza.setExtraCheese(extraCheeseCheckbox.isSelected());
        price.setText(String.format("%.2f", pizza.price()));
    }

    /**
     * Set extraSauce boolean as true or false based on user input and update price display
     */
    @FXML
    public void setExtraSauce() {
        pizza.setExtraSauce(extraSauceCheckbox.isSelected());
        price.setText(String.format("%.2f", pizza.price()));
    }

    /**
     * Add pizza to order list
     */
    @FXML
    public void addToOrder() {
        if(isValidPizza()){
            pizza.setSize(((RadioButton) this.size.getSelectedToggle()).getText());
            pizza.setSauce(((RadioButton) this.sauce.getSelectedToggle()).getText());
            pizza.setExtraSauce(extraSauceCheckbox.isSelected());
            pizza.setExtraCheese(extraCheeseCheckbox.isSelected());
            price.setText(String.format("%.2f", pizza.price()));
            currOrder.addPizza(pizza);
            createAlert("Pizza Added", "Order #" + currOrder.getOrderNumber(), "Pizza Added!");
        }

    }

    /**
     * Sets the storeOrder
     * @param so the storeOrder that this store order will be set to.
     */
    public static void setStoreOrder(StoreOrders so) {storeOrder = so;}

    /**
     * Sets the order
     * @param o the order that the current order will be set to.
     */
    public static void setCurrentOrder(Order o) {currOrder = o;}

}
