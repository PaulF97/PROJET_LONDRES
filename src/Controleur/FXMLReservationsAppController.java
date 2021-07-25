/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * this class will show to the customer
 * the reservations of the application
 * Author : Paul fisher
 */
public class FXMLReservationsAppController implements Initializable {

    @FXML
    private TableView<TableReservations> m_tableReservation;
    
    @FXML
    private TableColumn<TableReservations, String> m_nameClient;

    @FXML
    private TableColumn<TableReservations, Date> m_startResa;

    @FXML
    private TableColumn<TableReservations, String> m_purposeResa;

    @FXML
    private TableColumn<TableReservations, String> m_usernameUsed;

    @FXML
    private TableColumn<TableReservations, Date> m_endDate;

    @FXML
    private TableColumn<TableReservations, Integer> m_resaTable;

    @FXML
    private TableColumn<TableReservations, String> m_carResa;

    @FXML
    private TableColumn<TableReservations, String> m_lastClient;

    @FXML
    private Button m_backResa;

    ObservableList<TableReservations> listOfReservations = FXCollections.observableArrayList();

    @FXML
    void onClickedResa(ActionEvent event) throws IOException {
        if(event.getSource() == m_backResa){
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/FXMLSelectionPersonType.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.centerOnScreen();
            window.show();   
        }
    }
    /**
     * The method will display all the reservations
     * to the admin
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Connection con = CarListAccess.getConnection();

            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM reservation");
          
            while(rs.next()){
                listOfReservations.add(new TableReservations(rs.getInt("numberReservation"), rs.getString("vehicule_name"), rs.getDate("starting_date"), rs.getDate("ending_date"), rs.getString("firstName_client"), rs.getString("lastName_client"), rs.getString("purpose_client"), rs.getString("username_used")));
   
            }

        } catch (SQLException ex) {
            Logger.getLogger(FXML_ListOfCarsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        m_resaTable.setCellValueFactory(new PropertyValueFactory<>("nbReservation"));
        m_carResa.setCellValueFactory(new PropertyValueFactory<>("carName"));
        m_startResa.setCellValueFactory(new PropertyValueFactory<>("firstDay"));
        m_endDate.setCellValueFactory(new PropertyValueFactory<>("lastDay"));
        m_nameClient.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        m_lastClient.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        m_purposeResa.setCellValueFactory(new PropertyValueFactory<>("purpose"));
        m_usernameUsed.setCellValueFactory(new PropertyValueFactory<>("usernameOfReservation"));

        m_tableReservation.setItems(listOfReservations);
    }  
  }    

