package com.example.javafxproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;

/**
 * Controller Class for the current order
 * @author Ishani Mhatre
 * @author Keerthana Talla
 */
public class CurrentOrderController {

    private static final DecimalFormat df = new DecimalFormat( "#.00" ); //formating code

    private static StoreOrders storeOrder; //new object of store order

    private static Order currOrder; //new object of order

    @FXML
    private TextField orderNumber; //order number display

    @FXML
    private TextField subtotal; //total for individual pizza

    @FXML
    private TextField salesTax; //tax added

    @FXML
    private TextField orderTotal; //total for all pizzas

    @FXML
    private ListView listView; //list view variable for ui

    /**
     * initialize current order scene
     */
    @FXML
    public void initialize() {
        this.disableAll();
        if (currOrder == null || currOrder.getPizzas().size() == 0)
            return;
        this.updateDetails();
        this.showPizzas();
    }

    /**
     * Clears order by removing all pizzas
     * Updates scene to reflect this
     */
    @FXML
    public void clearOrder() {
        currOrder.clearOrder();
        this.updateDetails();
        this.listView.getItems().clear();
    }

    /**
     * Removes selected pizza from the order
     * Updates scene to reflect this
     */
    @FXML
    public void removePizza() {
        if (currOrder == null || currOrder.getPizzas().size() == 0)
            return;
        int index = listView.getSelectionModel().getSelectedIndex();
        if (index < 0)
            return;
        this.listView.getItems().remove(index);
        if (currOrder.getPizzas().size() <= index)
            return;
        Pizza toRemove = currOrder.getPizzas().get(index);
        currOrder.removePizza(toRemove);
        this.updateDetails();
    }

    /**
     * Used to update the details of the textfields/areas in this scene
     */
    private void updateDetails() {
        this.orderNumber.setText(String.valueOf(currOrder.getOrderNumber()));
        this.subtotal.setText(df.format(currOrder.getSubtotal()));
        this.salesTax.setText(df.format(currOrder.getTax()));
        this.orderTotal.setText(df.format(currOrder.getOrderTotal()));
    }

    /**
     * Displays all pizzas in list view
     */
    private void showPizzas() {
        if (currOrder == null || currOrder.getPizzas().size() == 0)
            return;
        ObservableList<String> obl = FXCollections.observableArrayList();
        for (Pizza p: currOrder.getPizzas()) {
            String details = this.getPizzaType(p) + " " + p.getSize() + ", ";
            details += p.getSauce().toString() + ", Toppings: ";
            for (Topping tp: p.getToppings())
                details += tp.toString() + ", ";
            details += "$" + p.price();
            obl.add(details);
        }
        listView.setItems(obl);

    }

    /**
     * Adds the current order into the store order
     * Clears out listview and text
     * Creates new current order and "syncs" it with ny and chicago controllers
     */
    @FXML
    public void placeOrder() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Status");
        if (currOrder == null || currOrder.getPizzas().size() == 0) {
            alert.setHeaderText("Error");
            alert.setContentText("No pizzas in order");
            alert.showAndWait();
            return;
        }
        int num = currOrder.getOrderNumber();
        storeOrder.placeOrder(currOrder);
        currOrder = new Order();

        //update current order in other views
        FXMLLoader loader = new FXMLLoader(MainPizzaApplication.class.getResource("SpecialityPizza.fxml"));
        loader = new FXMLLoader(MainPizzaApplication.class.getResource("SpecialityPizza.fxml"));
        SpecialityPizzasController spc = loader.getController();
        spc.setStoreOrder(storeOrder);
        spc.setCurrentOrder(currOrder);

        loader = new FXMLLoader(MainPizzaApplication.class.getResource("BuildYourOwn.fxml"));
        BuildYourOwnController bypoc = loader.getController();
        bypoc.setStoreOrder(storeOrder);
        bypoc.setCurrentOrder(currOrder);


        alert.setHeaderText("Order: " + num);
        alert.setContentText("Order Placed!");
        clearAll();
        alert.showAndWait();
    }

    /**
     * Clears all data from the current order view
     */
    private void clearAll() {
        orderNumber.clear();
        subtotal.clear();
        salesTax.clear();
        orderTotal.clear();
        listView.getItems().clear();
    }

    /**
     * Disables editing of the text fields
     */
    private void disableAll() {
        orderNumber.setDisable(true);
        subtotal.setDisable(true);
        salesTax.setDisable(true);
        orderTotal.setDisable(true);
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

    /**
     * Gets Type of Pizza given pizza object
     * @param p the pizza in question
     * @return the type of pizza it is
     */
    private String getPizzaType(Pizza p) {
        if (p instanceof DeluxePizza)
            return ((DeluxePizza) p).getPizzaType();
        if (p instanceof SupremePizza)
            return ((SupremePizza) p).getPizzaType();
        if (p instanceof PepperoniPizza)
            return ((PepperoniPizza) p).getPizzaType();
        if (p instanceof MeatzzaPizza)
            return ((MeatzzaPizza) p).getPizzaType();
        if (p instanceof SeafoodPizza)
            return ((SeafoodPizza) p).getPizzaType();
        if (p instanceof BuildYourOwnPizza)
            return ((BuildYourOwnPizza) p).getPizzaType();
        return "";
    }
}