/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import java.util.concurrent.TimeUnit;
import static javafx.application.Platform.exit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


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
    private TextField m_emailField;
    
    // static variables. static to call use them in other class
    protected static String purposeRecap;
    protected static String firstNamePurpose;
    protected static String lastNamePurpose;
    protected static LocalDate first;
    protected static LocalDate last;
    protected static String priceToString;
    protected static String carName;
    protected static String mail;

    public FXMLReservationInformationController() {}
    
    
    // getters and setters
    public String getPurposeRecap() {
        return purposeRecap;
    }

    public void setPurposeRecap(String purposeRecap) {
        FXMLReservationInformationController.purposeRecap = purposeRecap;
    }

    public String getFirstNamePurpose() {
        return firstNamePurpose;
    }

    public void setFirstNamePurpose(String firstNamePurpose) {
        FXMLReservationInformationController.firstNamePurpose = firstNamePurpose;
    }

    public String getLastNamePurpose() {
        return lastNamePurpose;
    }

    public void setLastNamePurpose(String lastNamePurpose) {
        FXMLReservationInformationController.lastNamePurpose = lastNamePurpose;
    }

    public LocalDate getFirst() {
        return first;
    }

    public void setFirst(LocalDate first) {
        FXMLReservationInformationController.first = first;
    }

    public LocalDate getLast() {
        return last;
    }

    public void setLast(LocalDate last) {
        FXMLReservationInformationController.last = last;
    }

    public String getPriceToString() {
        return priceToString;
    }

    public void setPriceToString(String priceToString) {
        FXMLReservationInformationController.priceToString = priceToString;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        FXMLReservationInformationController.carName = carName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        FXMLReservationInformationController.mail = mail;
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
          
        int idCar = getCustomerInfo.getIdCar();
        String idToString = Integer.toString(idCar);
        double rentalPrice = getCustomerInfo.getPrice();
        
        // gets the rental dates
        first = getRentalDates.getFirst();
        last = getRentalDates.getLast();
        
        // gets the customer & car info
        purposeRecap = getCustomerInfo.getPurpose();
        firstNamePurpose = getCustomerInfo.getName();
        lastNamePurpose = getCustomerInfo.getLastName();
        priceToString = Integer.toString((int) rentalPrice);
        carName = getCarName.GetString("vehicules", idCar, "vehicule_name");
        int daysTakenByCustomer = getCustomerInfo.getDays();
        
        if(event.getSource() == m_test){
            m_firstLabel.setText(firstNamePurpose);
            m_lastLabel.setText(lastNamePurpose);
            m_RentalFirstLabel.setText(first.toString());
            m_RentalLastLabel.setText(last.toString());
            m_carNameLabel.setText(carName);
            m_purposeLabel.setText(purposeRecap);
            m_totalPrice.setText(priceToString);
            System.err.println(idCar);
        }
        
        if(event.getSource() == m_bookingConfirm){
            mail = m_emailField.getText();
            /*                if(mail.isEmpty()){ // if email empty
            throw new ExceptionMailConfirmationEmpty();
            } else{
            JOptionPane.showMessageDialog(null, "You the reservation is being proceded","info", JOptionPane.INFORMATION_MESSAGE);
            TimeUnit.SECONDS.sleep(2);
            JOptionPane.showMessageDialog(null, "The reservation is validated. thank you for choosing us " +firstNamePurpose+ " " + lastNamePurpose+ "","info", JOptionPane.INFORMATION_MESSAGE);
            dataUpdate.run("UPDATE vehicules SET first_date ='"+first+"' WHERE vehicules.Vehicule_id = "+idCar); // updates the first date
            dataUpdate.run("UPDATE vehicules SET last_date ='"+last+"' WHERE vehicules.Vehicule_id = "+idCar);  // updates the last date
            
            MailSendInfo mailSend = new MailSendInfo();
            //mailSend.send();
            }*/
            
            
            JOptionPane.showMessageDialog(null, "You the reservation is being proceded","info", JOptionPane.INFORMATION_MESSAGE);
            TimeUnit.SECONDS.sleep(2);
            JOptionPane.showMessageDialog(null, "The reservation is validated. thank you for choosing us " +firstNamePurpose+ " " + lastNamePurpose+ "","info", JOptionPane.INFORMATION_MESSAGE);
            LocalDate availableLast = last.plusDays(daysTakenByCustomer + 1); // sets the last day when the car will be available after rental period
            dataUpdate.run("UPDATE vehicules SET first_date ='"+last+"' WHERE vehicules.Vehicule_id = "+idCar); // updates the first date
            dataUpdate.run("UPDATE vehicules SET last_date ='"+availableLast+"' WHERE vehicules.Vehicule_id = "+idCar);  // updates the last date
            
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/FXMLDocument.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.centerOnScreen();
            window.show();
        }
    }
}