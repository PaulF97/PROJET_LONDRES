package Controleur;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Platform.exit;
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
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/*
* Display the cars available to the customer
* accourding to his rental dates
* Bibliographie : https://www.youtube.com/watch?v=LoiQVoNil9Q&t=416s
*/
public class FXML_ListOfCarsCustomerController implements Initializable{

    public ToggleGroup radioButtons = new ToggleGroup();
    
    @FXML
    private Button m_modifyDates;

    @FXML
    private Button m_exitList;
       
    @FXML
    private TableView<TableCarCustomer> tableCar;
  
    @FXML
    private TableColumn<TableCarCustomer, String> vehicule_type;

    @FXML
    private TableColumn<TableCarCustomer, Double> price;
    



    ObservableList<TableCarCustomer> listOfCarCustomer = FXCollections.observableArrayList();
      
    FXMLDateEntranceController obj = new FXMLDateEntranceController();
    
    @FXML
    void onActionListCustomer(ActionEvent event) throws IOException {
        if(event.getSource() == m_modifyDates){
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/FXMLDateEntrance.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.centerOnScreen();
            window.show();            
        } else if(event.getSource() == m_exitList){
            JOptionPane.showMessageDialog(null, "The application will close","customer information", JOptionPane.INFORMATION_MESSAGE);
            exit();
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        try {
            Connection con = CarListAccess.getConnection();
            

           LocalDate first = obj.getFirst();
           LocalDate last = obj.getLast();
              
           System.err.println(first);
           System.err.println(last);
           
          //ResultSet rs = con.createStatement().executeQuery("SELECT * FROM `vehicules` where first_date >= '"+first+"' AND last_date <= '"+last+"'");
            
          ResultSet rs = con.createStatement().executeQuery("SELECT vehicule_name, rental_price FROM vehicules where first_date >= '"+first+"' AND last_date <= '"+last+"'");

            while(rs.next()){
                listOfCarCustomer.add(new TableCarCustomer(rs.getString("vehicule_name"), rs.getDouble("rental_price")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(FXML_ListOfCarsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        vehicule_type.setCellValueFactory(new PropertyValueFactory<>("vehiculeName"));
        price.setCellValueFactory(new PropertyValueFactory<>("vehiculePrice"));
        tableCar.setItems(listOfCarCustomer);
    }
}