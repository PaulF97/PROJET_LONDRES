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
    void ActionChoiceCustomer(ActionEvent event) throws IOException {
        if(event.getSource() == m_displayEmployee){
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/FXML_ListOfCars.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.centerOnScreen();
            window.show();
        } else if (event.getSource() == m_addCarEmployee){
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/FXMLAddCarToList.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.centerOnScreen();
            window.show();
        } else if(event.getSource() == m_deleteEmployee){
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/FXMLDeleteCarOfList.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.centerOnScreen();
            window.show();
        } else if(event.getSource() == m_financeCompany){
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/FXMLFinanceResults.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.centerOnScreen();
            window.show();
        } else if(event.getSource() == m_rentCarac){
            
        } 
        else if(event.getSource() == m_exitEmployee){
            exit();
        }
    }

}
