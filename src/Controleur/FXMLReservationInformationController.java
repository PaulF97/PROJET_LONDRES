/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.io.IOException;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.mail.*;

/**
* This class will manege and display
* all the booking information of the customer
* author : Paul Fisher
*/
public class FXMLReservationInformationController {

    @FXML
    private Label m_firstLabel;

    @FXML
    private Label m_lastLabel;

    @FXML
    private Label m_carNameLabel;

    @FXML
    private Label m_RentalLastLabel;

    @FXML
    private Button m_test;

    @FXML
    private Label m_RentalFirstLabel;

    @FXML
    private Label m_totalPrice;

    @FXML
    private Button m_bookingConfirm;

    @FXML
    private Label m_purposeLabel;
    
    @FXML
    private Label m_usernameUsed;
    
    // static variables
    protected static int numberOfOrders = 0;
    protected static double moneyGenerated = 0;
    protected static String username;
    protected static String purposeRecap;

    // constructor
    public FXMLReservationInformationController() {}
    
    // getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        FXMLReservationInformationController.username = username;
    }
    
    
    public double getMoneyGenerated() {
        return moneyGenerated;
    }

    public void setMoneyGenerated(double moneyGenerated) {
        FXMLReservationInformationController.moneyGenerated = moneyGenerated;
    }

    public String getPurposeRecap() {
        return purposeRecap;
    }

    public void setPurposeRecap(String purposeRecap) {
        FXMLReservationInformationController.purposeRecap = purposeRecap;
    }
    
    public int getNumberOfOrders() {
        return numberOfOrders;
    }

    public void setNumberOfOrders(int numberOfOrders) {
        FXMLReservationInformationController.numberOfOrders = numberOfOrders;
    }
    
    // class instances
    FXMLDateEntranceController getRentalDates = new FXMLDateEntranceController();
    FXML_ListOfCarsCustomerController getCustomerInfo = new FXML_ListOfCarsCustomerController();
    DBGetter getCarName = new DBGetter();
    CustomerDBQuery dataUpdate = new CustomerDBQuery(); 

    /*
    * Source for email : 
    * https://www.youtube.com/watch?v=A7HAB5whD6I&t=361s
    */
    
    
    
    @FXML
    void onActionRecap(ActionEvent event) throws InterruptedException, MessagingException, IOException {
        
        // gets the rental dates
        LocalDate first = getRentalDates.getFirst();
        LocalDate last = getRentalDates.getLast();
        
        // car information
        int idCar = getCustomerInfo.getIdCar();
        String idToString = Integer.toString(idCar);
        double rentalPrice = getCustomerInfo.getPrice();
        String carName = getCarName.GetString("vehicules", idCar, "vehicule_name");

        // gets the customer & car info
        purposeRecap = getCustomerInfo.getPurpose();
        String firstNamePurpose = getCustomerInfo.getName();
        String lastNamePurpose = getCustomerInfo.getLastName();
        String priceToString = Integer.toString((int) rentalPrice);
        int daysTakenByCustomer = getCustomerInfo.getDays();
        username = getCustomerInfo.getUserLogin();
        
        if(event.getSource() == m_test){
            m_firstLabel.setText(firstNamePurpose);
            m_lastLabel.setText(lastNamePurpose);
            m_RentalFirstLabel.setText(first.toString());
            m_RentalLastLabel.setText(last.toString());
            m_carNameLabel.setText(carName);
            m_purposeLabel.setText(purposeRecap);
            m_totalPrice.setText(priceToString);
            m_usernameUsed.setText(username);
            
        }
        
        if(event.getSource() == m_bookingConfirm){

            
            JOptionPane.showMessageDialog(null, "You the reservation is being proceded","info", JOptionPane.INFORMATION_MESSAGE);
            TimeUnit.SECONDS.sleep(2);
            JOptionPane.showMessageDialog(null, "The reservation is validated. thank you for choosing us " +firstNamePurpose+ " " + lastNamePurpose+ "","info", JOptionPane.INFORMATION_MESSAGE);
            LocalDate availableLast = last.plusDays(daysTakenByCustomer + 1); // sets the last day when the car will be available after rental period
            dataUpdate.run("UPDATE vehicules SET first_date ='"+last+"' WHERE vehicules.Vehicule_id = "+idCar); // updates the first date
            dataUpdate.run("UPDATE vehicules SET last_date ='"+availableLast+"' WHERE vehicules.Vehicule_id = "+idCar);  // updates the last date

            numberOfOrders++; // get accumulation of orders
            moneyGenerated = moneyGenerated + rentalPrice; // get accumulation of money gain
            
            // goes back to main page
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/FXMLDocument.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.centerOnScreen();
            window.show();
        }
    }
}