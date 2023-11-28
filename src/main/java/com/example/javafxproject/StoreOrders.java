package com.example.javafxproject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for keeping track of store orders after order has been places
 * Updates whenever new order is placed
 * Displays order details and exports to txt file
 * @author Ishani Mhatre
 * @author Keerthana Talla
 */
public class StoreOrders {
    private static int nextOrderNumber = 1;
    private List<Order> orders;

    /**
     * Creating new array list for store order
     */
    public StoreOrders() {
        orders = new ArrayList<>();
    }

    /**
     * New method to add order to order list
     * @param order of Order object
     */

    public void placeOrder(Order order) {
        orders.add(order);
    }

    /**
     * Generates a very unique number for an order
     * @return a very unique integer
     */
    public static int generateOrderNum() {return nextOrderNumber++;}

    /**
     * Returns an arraylist of all the orders
     * @return arraylist of all the orders
     */
    public List<Order> getOrders() {
        return this.orders;
    }

    /**
     * Attempts to remove an object into the list of orders
     * @param order the object to be removed from the list of order
     * @return true if the remove operation was successful, false otherwise
     */
    public boolean remove(Order order) {
        return this.orders.remove(order);
    }

    /**
     * Method to cancel order from Store orders
     * @param order
     */
    public void cancelOrder(Order order) {
        orders.remove(order);
    }
    /**
     * Method to find total amount based on sales taxes
     * @param totalAmount
     * @return double
     */
    public double calculateSalesTax(double totalAmount) {
        // Calculate sales tax based on the tax rate (6.625% in New Jersey)
        double taxRate = 0.06625;
        return totalAmount * taxRate;
    }

    /**
     * method to display pizza details for every order
     * @param order
     */
    public void displayOrderDetails(Order order) {
        System.out.println("Order Number: " + order.getOrderNumber());
        System.out.println("Pizzas:");
        for (Pizza pizza : order.getPizzas()) {
            System.out.println("- " + pizza.getClass().getSimpleName() + ": $" + pizza.price());
            // Add logic to display pizza details (toppings, size, sauce, etc.)
        }
        double orderTotal = order.getOrderTotal();

        System.out.println("Total Amount: $" + String.format("%.2f", order.getSubtotal()));
        System.out.println("Sales Tax: $" + String.format("%.2f", order.getTax()));
        System.out.println("Order Total: $" + String.format("%.2f", orderTotal));
    }

    /**
     * Method to display order numbers
     */
    public void displayAllOrders() {
        System.out.println("All Store Orders:");
        for (Order order : orders) {
            System.out.println("Order Number: " + order.getOrderNumber());
            // Add logic to display more order details if needed
        }
    }

    /**
     * Method to export total orders to txt file
     */
    public void exportOrdersToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("store_orders.txt"))) {
            for (Order order : orders) {
                writer.println("Order Number: " + order.getOrderNumber());
                for (Pizza pizza : order.getPizzas()) {
                    writer.println("- " + pizza.getClass().getSimpleName() + ": $" + pizza.price());
                    // Add logic to write pizza details to the file
                }
                //double totalAmount = order.getSubtotal();

                writer.println("Total Amount: $" + String.format("%.2f", order.getSubtotal()));
                writer.println("Sales Tax: $" + String.format("%.2f", order.getTax()));
                writer.println("Order Total: $" + String.format("%.2f", order.getOrderTotal()));
                writer.println(); // Separate orders in the file
            }
            System.out.println("Orders exported to store_orders.txt");
        } catch (IOException e) {
            System.err.println("Error exporting orders to file: " + e.getMessage());
        }
    }
}