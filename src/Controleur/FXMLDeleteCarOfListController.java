package Controleur;

import java.io.IOException;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class FXMLDeleteCarOfListController {

    @FXML
    private Button m_back;

    @FXML
    private TextField m_IdDelete;

    @FXML
    private Button m_exit;

    @FXML
    private Button m_validateDelete;

    @FXML
    void onActionDeleteEmployee(ActionEvent event) throws IOException {
     
        try{
            if(event.getSource() == m_exit){
                exit();
            } else if(event.getSource() == m_back){
                Parent tableViewParent = FXMLLoader.load(getClass().getResource("/Vue/FXMLChoiceActionEmployee.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);
                Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                window.setScene(tableViewScene);
                window.centerOnScreen();
                window.show();
            }

            if(event.getSource() == m_validateDelete){
                
                if(m_IdDelete.getText().isEmpty()){ // exception handling
                    throw new ExceptionVehiculeIDEmpty();
                } else{
                    
                    // converts to int for the BDD table
                    int id = Integer.parseInt(m_IdDelete.getText());
                    
                    // delete the data and update the table
                    CustomerDBQuery dataEnter = new CustomerDBQuery();                    
                    dataEnter.run("DELETE FROM `vehicules` WHERE Vehicule_id = "+id+" ");

                    JOptionPane.showMessageDialog(null, "the car has been deleted","info employee", JOptionPane.INFORMATION_MESSAGE);

                    Parent tableViewParent = FXMLLoader.load(getClass().getResource("/Vue/FXMLChoiceActionEmployee.fxml"));
                    Scene tableViewScene = new Scene(tableViewParent);
                    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    window.setScene(tableViewScene);
                    window.centerOnScreen();
                }
            }
         // if an error has been detected..   
        } catch (ExceptionVehiculeIDEmpty ex) {
            ex.getMessage();
        }

    }
    
   
}