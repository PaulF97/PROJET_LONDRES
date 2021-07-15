package Controleur;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/*
* Bibliographie : https://www.youtube.com/watch?v=LoiQVoNil9Q&t=416s
*/
public class FXML_ListOfCarsController implements Initializable{

    @FXML
    private TableView<TableCar> tableCar;
        


    @FXML
    private TableColumn<TableCar, Double> vehicule_id;
    
    @FXML
    private TableColumn<TableCar, String> vehicule_type;


    @FXML
    private TableColumn<TableCar, String> availableFirst;

    @FXML
    private TableColumn<TableCar, Double> discount;

    @FXML
    private TableColumn<TableCar, String> availableLast;
    
    @FXML
    private TableColumn<TableCar, Double> price;

    ObservableList<TableCar> listOfCar = FXCollections.observableArrayList();
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            Connection con = CarListAccess.getConnection();
            
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM vehicules");
            
            while(rs.next()){
                listOfCar.add(new TableCar(rs.getDouble("vehicule_id"), rs.getString("vehicule_name"), rs.getString("first_date"), rs.getString("last_date"), rs.getDouble("discount"), rs.getDouble("rental_price")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(FXML_ListOfCarsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        vehicule_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        vehicule_type.setCellValueFactory(new PropertyValueFactory<>("name"));
        availableFirst.setCellValueFactory(new PropertyValueFactory<>("firstDate"));
        availableLast.setCellValueFactory(new PropertyValueFactory<>("lastDate"));
        discount.setCellValueFactory(new PropertyValueFactory<>("discount"));
        price.setCellValueFactory(new PropertyValueFactory<>("rentalPrice"));
        
        tableCar.setItems(listOfCar);

    }

}