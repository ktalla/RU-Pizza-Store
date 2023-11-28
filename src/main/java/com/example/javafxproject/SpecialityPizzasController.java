package com.example.javafxproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * Controller page for selecting and customizing a Speciality Pizza
 * Links to SpecialityPizza.fxml
 * @author Ishani Mhatre
 * @author Keerthana Talla
 */
public class SpecialityPizzasController {

    private Pizza pizza;

    private static StoreOrders storeOrder;

    private static Order currOrder;

    @FXML
    private ComboBox<String> pizzaType;

    @FXML
    private TextField price;

    @FXML
    private TextField toppings;

    @FXML
    private ToggleGroup size;

    @FXML
    private ToggleGroup sauce;

    @FXML
    private CheckBox extraCheeseCheckbox;

    @FXML
    private CheckBox extraSauceCheckbox;

    /**
     * Initializes a default pizza of type Deluxe and small
     */
    @FXML
    public void initialize() {
        ObservableList<String> pizzaTypes = FXCollections.observableArrayList(
                "Deluxe", "Supreme", "Meatzza", "Seafood", "Pepperoni"
        );
        pizzaType.setItems(pizzaTypes);
        pizzaType.getSelectionModel().select(0); // Default to Deluxe pizza

        // Initialize pizza with a default type (Deluxe in this case)
        pizza = PizzaMaker.createPizza("Deluxe");
        pizza.setSize(((RadioButton) this.size.getSelectedToggle()).getText());
        pizza.setSauce(((RadioButton) this.sauce.getSelectedToggle()).getText());
        price.setText(String.format("%.2f", pizza.price()));
        toppings.setText("" + pizza.getToppings());
    }

    /**
     * Updates the pizza order of size, sauce, or extra options based on user input selection
     * @param event
     */
    @FXML
    public void selectPizza(ActionEvent event) {
        pizza = PizzaMaker.createPizza(pizzaType.getValue());
        pizza.setSize(((RadioButton) this.size.getSelectedToggle()).getText());
        pizza.setSauce(((RadioButton) this.size.getSelectedToggle()).getText());
        pizza.setExtraSauce(extraSauceCheckbox.isSelected());
        pizza.setExtraCheese(extraCheeseCheckbox.isSelected());
        price.setText(String.format("%.2f", pizza.price()));
        toppings.setText("" + pizza.getToppings());
    }

    /**
     * Set size based on user input and update/display price
     */
    @FXML
    public void setSize() {
        pizza.setSize(((RadioButton) this.size.getSelectedToggle()).getText());
        price.setText(String.format("%.2f", pizza.price()));
    }

    /**
     * Set option of adding extra cheese based on user input and update/display price
     */
    @FXML
    public void setExtraCheese() {
        pizza.setExtraCheese(extraCheeseCheckbox.isSelected());
        price.setText(String.format("%.2f", pizza.price()));
    }

    /**
     * Set option of adding extra sauce based on user input and update/display price
     */
    @FXML
    public void setExtraSauce() {
        pizza.setExtraSauce(extraSauceCheckbox.isSelected());
        price.setText(String.format("%.2f", pizza.price()));
    }

    /**
     * Set sauce based on user input and update/display price
     */
    @FXML
    public void setSauce() {
        pizza.setSauce(((RadioButton) this.sauce.getSelectedToggle()).getText());
        price.setText(String.format("%.2f", pizza.price()));
    }

    /**
     * Add pizza to current order object and create alert to notify user a new pizza has been added
     */
    @FXML
    public void addToOrder() {
        currOrder.addPizza(pizza);
        selectPizza(new ActionEvent());
        createAlert("Pizza Added", "Order #" + currOrder.getOrderNumber(), "Pizza Added!");
    }


    /**
     * Method to create alert after user completes required action
     * @param title of type string
     * @param header of type string
     * @param content of type string
     */
    private void createAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
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