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
    
    
    FXMLDateEntranceController getRentalDates = new FXMLDateEntranceController();
    FXML_ListOfCarsCustomerController getCustomerInfo = new FXML_ListOfCarsCustomerController();
    DBGetter getCarName = new DBGetter();
    // gets the rental dates
    LocalDate first = getRentalDates.getFirst();
    LocalDate last = getRentalDates.getLast();
   
    // gets the customer & car info
    String purposeRecap = getCustomerInfo.getPurpose();
    String firstNamePurpose = getCustomerInfo.getName();
    String lastNamePurpose = getCustomerInfo.getLastName();
    int idCar = getCustomerInfo.getIdCar();
    double rentalPrice = getCustomerInfo.getPrice();
    String idToString = Integer.toString(idCar);
    String priceToString = Integer.toString((int) rentalPrice);
    String carName = getCarName.GetString("vehicules", idCar, "vehicule_name");
    
    /*
    * Source for email : 
    * https://www.youtube.com/watch?v=A7HAB5whD6I&t=361s
    */
    @FXML
    void onActionRecap(ActionEvent event) throws InterruptedException {
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
                if(m_emailField.getText().isEmpty()){ // if email empty
                    throw new ExceptionMailConfirmationEmpty();
                } else{
                    JOptionPane.showMessageDialog(null, "You the reservation is being proceded","info", JOptionPane.INFORMATION_MESSAGE);
                    TimeUnit.SECONDS.sleep(2);
                    JOptionPane.showMessageDialog(null, "The reservation is validated. thank you for choosing us " +firstNamePurpose+ " " + lastNamePurpose+ "","info", JOptionPane.INFORMATION_MESSAGE);
                     
                }
                    
                    exit();
                }  
            
        } catch (ExceptionMailConfirmationEmpty ex) {
            ex.getMessage();
        }
    }
    
}