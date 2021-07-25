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

    /**
     * class constructor
     */
    public FXMLReservationInformationController() {}
    
    // getters and setters

    /**
     * get the username
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * set the username
     * @param username
     */
    public void setUsername(String username) {
        FXMLReservationInformationController.username = username;
    }
    
    /**
     * get the money gain off app
     * @return
     */
    public double getMoneyGenerated() {
        return moneyGenerated;
    }

    /**
     * set the money gain
     * @param moneyGenerated
     */
    public void setMoneyGenerated(double moneyGenerated) {
        FXMLReservationInformationController.moneyGenerated = moneyGenerated;
    }

    /**
     * get the purpose of reservation
     * @return
     */
    public String getPurposeRecap() {
        return purposeRecap;
    }

    /**
     * set the purpose of reservation
     * @param purposeRecap
     */
    public void setPurposeRecap(String purposeRecap) {
        FXMLReservationInformationController.purposeRecap = purposeRecap;
    }
    
    /**
     * get number of orders off app
     * @return
     */
    public int getNumberOfOrders() {
        return numberOfOrders;
    }

    /**
     * set the number of orders
     * @param numberOfOrders
     */
    public void setNumberOfOrders(int numberOfOrders) {
        FXMLReservationInformationController.numberOfOrders = numberOfOrders;
    }
    
    // class instances
    FXMLDateEntranceController getRentalDates = new FXMLDateEntranceController();
    FXML_ListOfCarsCustomerController getCustomerInfo = new FXML_ListOfCarsCustomerController();
    DBGetter getCarName = new DBGetter();
    CustomerDBQuery dataUpdate = new CustomerDBQuery(); 

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
            int numberReservation = (int)(Math.random()*9000)+1000;
            String reseavation = Integer.toString(numberReservation);
            JOptionPane.showMessageDialog(null, "You the reservation is being proceded","info", JOptionPane.INFORMATION_MESSAGE);
            TimeUnit.SECONDS.sleep(2); // small time laps for validation
            JOptionPane.showMessageDialog(null, "The reservation is validated. thank you for choosing us. " +firstNamePurpose+ " " + lastNamePurpose+ "IMPORTANTE RESERVATION NUMBER : " +reseavation+ "","info", JOptionPane.INFORMATION_MESSAGE);
            LocalDate availableLast = last.plusDays(daysTakenByCustomer + 1); // sets the last day when the car will be available after rental period
            dataUpdate.run("UPDATE vehicules SET first_date ='"+last+"' WHERE vehicules.Vehicule_id = "+idCar); // updates the first date
            dataUpdate.run("UPDATE vehicules SET last_date ='"+availableLast+"' WHERE vehicules.Vehicule_id = "+idCar);  // updates the last date
            dataUpdate.run("INSERT INTO `reservation` (`numberReservation`, `vehicule_name`, `starting_date`, `ending_date`, `firstName_client`, `lastName_client`, `purpose_client`, `username_used`) VALUES ('"+numberReservation+"' , '"+carName+"' , '"+first+"' , '"+last+"' , '"+firstNamePurpose+"', '"+lastNamePurpose+"' , '"+purposeRecap+"' , '"+username+"')");
            
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