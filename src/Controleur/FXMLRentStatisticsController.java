/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
* This class will manege and display
* the statictics rental of the application
* Renting purposes and best customers
* Only accessible with Employee's codes
* author : Paul Fisher
*/
public class FXMLRentStatisticsController implements Initializable {

    @FXML
    private PieChart m_charPurpose;

    
    @FXML
    private Button m_back;
    
    // statics variables
    protected static double purposeBusiness = 0;
    protected static double purposeIndividual = 0;
    protected static String user;
    
    // classes instances
    FXMLReservationInformationController dataPieChart = new FXMLReservationInformationController();
    
        @FXML
    void onActionStats(ActionEvent event) throws IOException {
        if(event.getSource() == m_back){
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/FXMLSelectionPersonType.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.centerOnScreen();
            window.show();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
             // get the usefull data for piechart
        String currentPurpose = dataPieChart.getPurposeRecap();
        user = dataPieChart.getUsername();
        String nextUser = null;
        if("business".equals(currentPurpose)){
            purposeBusiness++;
        } else if ("individual".equals(currentPurpose)){
            purposeIndividual = purposeIndividual + 1;
        }
        
        // statistics purposes
        ObservableList<PieChart.Data> pieChartDataPurpose =
                FXCollections.observableArrayList(
                        new PieChart.Data("business",purposeBusiness++),
                        new PieChart.Data("individual",purposeIndividual++));
        
        m_charPurpose.setData(pieChartDataPurpose); 
    }   

}
