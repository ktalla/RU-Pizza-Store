package com.example.javafxproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main page for the Pizza order application
 * Allows users to navigate to the four main pages: Store Orders, Current Orders, Speciality Pizza, and Build your own pizza
 * @author Ishani Mhatre
 * @author Keerthana Talla
 */
public class MainMenuController {

    @FXML
    private AnchorPane anchorPane;

    private static StoreOrders storeOrder = new StoreOrders();

    private static Order currOrder = new Order();

    /**
     * initializes by sharing the store order and current order object with the all controllers
     */
    @FXML
    public void initialize() {
        FXMLLoader loader = new FXMLLoader(MainPizzaApplication.class.getResource("StoreOrder.fxml"));
        StoreOrdersController soc = loader.getController();
        soc.setStoreOrder(storeOrder);

        loader = new FXMLLoader(MainPizzaApplication.class.getResource("SpecialityPizza.fxml"));
        SpecialityPizzasController spc = loader.getController();
        spc.setStoreOrder(storeOrder);
        spc.setCurrentOrder(currOrder);

        loader = new FXMLLoader(MainPizzaApplication.class.getResource("BuildYourOwn.fxml"));
        BuildYourOwnController bypoc = loader.getController();
        bypoc.setStoreOrder(storeOrder);
        bypoc.setCurrentOrder(currOrder);

        loader = new FXMLLoader(MainPizzaApplication.class.getResource("CurrentOrder.fxml"));
        CurrentOrderController coc = loader.getController();
        coc.setStoreOrder(storeOrder);
        coc.setCurrentOrder(currOrder);
    }

    /**
     * Opens speciality style ordering pizza scene
     * @param event of user action
     * @throws IOException event handling
     */
    @FXML
    void specialityPizza(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(MainPizzaApplication.class.getResource("SpecialityPizza.fxml"));
        anchorPane = loader.load();
        Scene scene = new Scene(anchorPane, 530, 500);
        stage.setTitle("Speciality pizzas");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Opens build your own style ordering pizza scene
     * @param event of user action
     * @throws IOException event handling
     */
    @FXML
    void buildYourOwn(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(MainPizzaApplication.class.getResource("BuildYourOwn.fxml"));
        anchorPane = loader.load();
        Scene scene = new Scene(anchorPane, 530, 500);
        stage.setTitle("Build your own");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Opens store order tab or scene
     * @param event of user action
     * @throws IOException event handling
     */
    @FXML
    void storeOrders(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(MainPizzaApplication.class.getResource("StoreOrder.fxml"));
        anchorPane = loader.load();
        Scene scene = new Scene(anchorPane, 530, 400);
        stage.setTitle("Store Orders");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Opens current order scene
     * @param event of user action
     * @throws IOException event handling
     */
    @FXML
    void currentOrder(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(MainPizzaApplication.class.getResource("CurrentOrder.fxml"));
        anchorPane = loader.load();
        Scene scene = new Scene(anchorPane, 530, 400);
        stage.setTitle("Current Order");
        stage.setScene(scene);
        stage.show();
    }

}