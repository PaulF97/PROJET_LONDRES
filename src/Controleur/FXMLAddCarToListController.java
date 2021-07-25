/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Platform.exit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
* This class will manege the page where the employee 
* will add a car to the database
* author : Paul Fisher
*/
public class FXMLAddCarToListController {

    @FXML
    private DatePicker m_lastDate;

    @FXML
    private TextField m_discount;

    @FXML
    private TextField m_vehiculeName;

    @FXML
    private TextField m_rentalPrice;

    @FXML
    private DatePicker m_firstDate;

    @FXML
    private TextField m_vehiculeID;
    
    @FXML
    private Button m_addCar;
    
    @FXML
    private Button m_exitAddCar;
    
    @FXML
    private Button m_backAddCar;

    @FXML
    void ActionAddCar(ActionEvent event) throws IOException {
        
        // optimization
        if(event.getSource() == m_backAddCar){ // go back
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/FXMLChoiceActionEmployee.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.centerOnScreen();
            window.show();
        } else if(event.getSource() == m_exitAddCar){ // exit the app
            exit();
        }
    
        try{
            if(event.getSource() == m_addCar){
    
                LocalDate first = m_firstDate.getValue(); // gets the first date
                LocalDate last = m_lastDate.getValue(); // gets the last day
                LocalDate current = LocalDate.now();
                // exception handling
                if(m_vehiculeID.getText().isEmpty()){
                    throw new ExceptionVehiculeIDEmpty();
                } else if(m_vehiculeName.getText().isEmpty()){
                    throw new ExceptionVehiculeNameEmpty();
                } else if(m_discount.getText().isEmpty()){
                    throw new ExceptionVehiculeDiscountEmpty();
                } else if(m_rentalPrice.getText().isEmpty()){
                    throw new ExceptionVehiculePriceEmpty();
                } else if(first == null && last == null){
                    throw new ExceptionDatesEmpty();
                } else if(first == null){
                    throw new ExceptionDateStartEmpty();
                } else if(last == null){
                    throw new ExceptionDateEndEmpty();                
                } else if(last.isBefore(first)){
                    throw new ExceptionDateLastBeforeFirst();
                } else if(first.isBefore(current)){
                    throw new ExceptionDateStartBeforeCurrent();
                }
                else{ // if no error has exception has been thrown..
                    String id = m_vehiculeID.getText();
                    String name = m_vehiculeName.getText();
                    String discount = m_discount.getText();
                    String rental = m_rentalPrice.getText();

                    // convertion to int before adding on vehicule table
                    int idToInt = Integer.parseInt(id);
                    int discountToInt = Integer.parseInt(discount);
                    int rentalToInt = Integer.parseInt(rental);


                    // adds the new information in the table
                    CustomerDBQuery dataEnter = new CustomerDBQuery();                    
                    dataEnter.run("INSERT INTO `vehicules` (`Vehicule_id`, `vehicule_name`, `first_date`, `last_date`, `discount`, `rental_price`) VALUES ('"+idToInt+"', '"+name+"' , '"+first+"' , '"+last+"' , '"+discountToInt+"', '"+rentalToInt+"')");

                    JOptionPane.showMessageDialog(null, "the car has been added","info employee", JOptionPane.INFORMATION_MESSAGE);

                    
                    Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/FXMLChoiceActionEmployee.fxml"));
                    Scene tableViewScene = new Scene(tableViewParent);
                    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    window.setScene(tableViewScene);
                    window.centerOnScreen();
                }
            
            } 
        } catch (ExceptionDatesEmpty ex) { // exception code excecuted..
            ex.getMessage();
        } catch (ExceptionDateStartEmpty ex) {
            ex.getMessage();
        } catch (ExceptionDateEndEmpty ex) {
            ex.getMessage();
        } catch (ExceptionVehiculePriceEmpty ex) {
            ex.getMessage();
        } catch (ExceptionVehiculeDiscountEmpty ex) {
            ex.getMessage();
        } catch (ExceptionVehiculeNameEmpty ex) {
            ex.getMessage();
        } catch (ExceptionVehiculeIDEmpty ex) {
            ex.getMessage();
        } catch (ExceptionDateLastBeforeFirst ex) {
            ex.getMessage();
        } catch (ExceptionDateStartBeforeCurrent ex) {
            ex.getMessage();
        }
        

    }

}