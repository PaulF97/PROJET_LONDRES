package Controleur;

import java.io.IOException;
import static javafx.application.Platform.exit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
* This class will manege and display the possible actions
* that the employee can do
* author : Paul Fisher
*/
public class FXMLChoiceActionEmployeeController {

    @FXML
    private Button m_displayEmployee;

    @FXML
    private Button m_rentCarac;

    @FXML
    private Button m_deleteEmployee;

    @FXML
    private Button m_exitEmployee;

    @FXML
    private Button m_financeCompany;

    @FXML
    private Button m_addCarEmployee;
    
    @FXML
    private Button m_reservations;
    
    @FXML
    void ActionChoiceCustomer(ActionEvent event) throws IOException {
        if(event.getSource() == m_displayEmployee){ // display list of cars
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/FXML_ListOfCars.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.centerOnScreen();
            window.show();
        } else if (event.getSource() == m_addCarEmployee){ // add car to the list
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/FXMLAddCarToList.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.centerOnScreen();
            window.show();
        } else if(event.getSource() == m_deleteEmployee){ // delete a car from the list
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/FXMLDeleteCarOfList.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.centerOnScreen();
            window.show();
        } else if(event.getSource() == m_financeCompany){ // access to finance results
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/FXMLFinanceResults.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.centerOnScreen();
            window.show();
        } else if(event.getSource() == m_rentCarac){ // get statistics of rentals
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/FXMLRentStatistics.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.centerOnScreen();
            window.show();
        } else if(event.getSource() == m_reservations){ // get the total reservations
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/FXMLReservationsApp.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.centerOnScreen();
            window.show();
        } 
        else if(event.getSource() == m_exitEmployee){ // exit app
            exit();
        }
    }
}