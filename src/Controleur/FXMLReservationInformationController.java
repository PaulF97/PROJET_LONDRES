/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

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

    /*
    * Source for email : 
    * https://www.youtube.com/watch?v=A7HAB5whD6I&t=361s
    */
    
    @FXML
    void onActionRecap(ActionEvent event) throws InterruptedException {
                
        // gets the rental dates
        first = getRentalDates.getFirst();
        last = getRentalDates.getLast();
        
        // gets the customer & car info
        purposeRecap = getCustomerInfo.getPurpose();
        firstNamePurpose = getCustomerInfo.getName();
        lastNamePurpose = getCustomerInfo.getLastName();
        int idCar = getCustomerInfo.getIdCar();
        String idToString = Integer.toString(idCar);
        double rentalPrice = getCustomerInfo.getPrice();
        priceToString = Integer.toString((int) rentalPrice);
        carName = getCarName.GetString("vehicules", idCar, "vehicule_name");
        
        if(event.getSource() == m_test){
            m_firstLabel.setText(firstNamePurpose);
            m_lastLabel.setText(lastNamePurpose);
            m_RentalFirstLabel.setText(first.toString());
            m_RentalLastLabel.setText(last.toString());
            m_carNameLabel.setText(carName);
            m_purposeLabel.setText(purposeRecap);
            m_totalPrice.setText(priceToString);
      
        }
        
        try{
            if(event.getSource() == m_bookingConfirm){
                mail = m_emailField.getText();
                if(mail.isEmpty()){ // if email empty
                    throw new ExceptionMailConfirmationEmpty();
                } else{
                    JOptionPane.showMessageDialog(null, "You the reservation is being proceded","info", JOptionPane.INFORMATION_MESSAGE);
                    TimeUnit.SECONDS.sleep(2);
                    JOptionPane.showMessageDialog(null, "The reservation is validated. thank you for choosing us " +firstNamePurpose+ " " + lastNamePurpose+ "","info", JOptionPane.INFORMATION_MESSAGE);
                    MailSendInfo mailSend = new MailSendInfo();
                }
                exit();
           }  
            
        } catch (ExceptionMailConfirmationEmpty ex) {
            ex.getMessage();
        }
    }
    
}