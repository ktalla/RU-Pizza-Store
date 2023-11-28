package com.example.javafxproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Controller Class for the store orders
 * @author Ishani Mhatre
 * @author Keerthana Talla
 */
public class StoreOrdersController {

    private static final DecimalFormat df = new DecimalFormat( "#.00" );
    private static StoreOrders storeOrder;

    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private ListView listView;
    @FXML
    private TextField orderTotal;

    /**
     * Initialize store order scene by populating combo box
     */
    @FXML
    public void initialize() {
        orderTotal.setDisable(true);
        if (storeOrder == null || storeOrder.getOrders().size() == 0) {
            comboBox.setDisable(true);
            return;
        }
        ObservableList<String> obl = FXCollections.observableArrayList();
        for(Order o: storeOrder.getOrders()) {
            obl.add(String.valueOf(o.getOrderNumber()));
        }
        comboBox.setItems(obl);

        // now set default
        comboBox.getSelectionModel().selectFirst();
        showOrders();
    }

    /**
     * When a value from the combo box is chosen,
     * display the order onto the list view
     */
    @FXML
    public void showOrders() {
        if (comboBox.getValue() == null)
            return;
        int orderNum = Integer.parseInt(comboBox.getValue());
        Order orderToDisplay = this.getCorrectOrder(orderNum);
        if (orderToDisplay == null)
            return;

        ObservableList<String> obl = FXCollections.observableArrayList();
        for (Pizza p: orderToDisplay.getPizzas()) {
            String details = this.getPizzaType(p) + " " + p.getSize() + ", ";
            details += p.getSauce().toString() + ", Toppings: ";
            for (Topping tp: p.getToppings())
                details += tp.toString() + ", ";
            details += "$" + p.price();
            obl.add(details);
        }
        listView.setItems(obl);
        orderTotal.setText(df.format(orderToDisplay.getOrderTotal()));
    }

    /**
     * Cancels the order from the selected value from the combo box
     */
    @FXML
    public void cancelOrder() {
        if (comboBox.getValue() == null)
            return;
        int orderNum = Integer.parseInt(comboBox.getValue());
        Order orderToRemove = this.getCorrectOrder(orderNum);
        if (orderToRemove == null)
            return;
        if (!storeOrder.remove(orderToRemove))
            return;
        this.comboBox.getItems().remove(String.valueOf(orderNum));
        this.comboBox.getSelectionModel().selectFirst();
        this.listView.getItems().clear();
        this.orderTotal.clear();
        showOrders();

    }

    /**
     * Exports all orders onto a text file
     */
    @FXML
    public void exportOrders() {storeOrder.exportOrdersToFile();}

    /**
     * Sets the storeOrder
     * @param so the storeOrder that this store order will be set to.
     */
    public static void setStoreOrder(StoreOrders so) {
        storeOrder = so;
    }

    /**
     * Searches for an order with given order number
     * @param orderNum orderNum to search for
     * @return the order if it exists, null otherwise
     */
    private Order getCorrectOrder(int orderNum) {
        List<Order> allOrders = storeOrder.getOrders();
        for(int i = 0; i < allOrders.size(); i++) {
            if (allOrders.get(i).getOrderNumber() == orderNum) {
                return allOrders.get(i);
            }
        }
        return null;
    }

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