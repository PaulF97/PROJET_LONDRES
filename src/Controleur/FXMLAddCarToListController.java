/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.io.IOException;
import java.time.LocalDate;
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
    void ActionAddCar(ActionEvent event) throws IOException {
        if(event.getSource() == m_addCar){
            
            LocalDate first = m_firstDate.getValue(); // gets the first date
            LocalDate last = m_lastDate.getValue(); // gets the last day
            
            // exception handling
            if(m_vehiculeID.getText().isEmpty()){
                
            } else if(m_vehiculeName.getText().isEmpty()){
                
            } else if(m_discount.getText().isEmpty()){
                
            } else if(m_rentalPrice.getText().isEmpty()){
                
            } else if(first == null && last == null){
                System.err.println("2 dates not entered");
            } else if(first == null){
                System.err.println("first date not entered");
            } else if(last == null){
                System.err.println("first date not entered");
            } 
            else{
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
                
                Parent tableViewParent = FXMLLoader.load(getClass().getResource("/Vue/FXMLChoiceActionEmployee.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);
                Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                window.setScene(tableViewScene);
                window.centerOnScreen();
            }
            
        }
    }

}