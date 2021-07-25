/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
* This class will manege and display the financal data
* of the application
* Only accessible with Employee's codes
* author : Paul Fisher
*/
public class FXMLFinanceResultsController implements Initializable {

    FXMLReservationInformationController financeData = new FXMLReservationInformationController();
    
    @FXML
    private Label m_CA;

    @FXML
    private Label m_rentals;
    
    @FXML
    private Button m_return;
    
    @FXML
    void onEmployeeFinance(ActionEvent event) throws IOException {
        if(event.getSource() == m_return){
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/FXMLSelectionPersonType.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.centerOnScreen();
            window.show();
        }

    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        int orders = financeData.getNumberOfOrders();
        double gain = financeData.getMoneyGenerated();
        String ordersToString = Integer.toString(orders);
        String gainToString = Integer.toString((int) gain);
        m_rentals.setText(ordersToString);
        m_CA.setText(gainToString);
        
    }    
    
}
