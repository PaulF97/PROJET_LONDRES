package Controleur;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;



/**
 * Display the cars available to the customer
 * accourding to his rental dates
 * author : Paul fisher
 */
public class FXML_ListOfCarsCustomerController implements Initializable{

    public ToggleGroup radioButtons = new ToggleGroup();
    
    @FXML
    private TableColumn<TableCarCustomer, Double> rentalPrice;

    @FXML
    private TableColumn<TableCarCustomer, String> vehicule_type;

    @FXML
    private TableView<TableCarCustomer> tableCar;

    @FXML
    private Button m_modifyDates;
    
    @FXML
    private Button m_buttonChooseCar;

    @FXML
    private Button m_exitList;

    @FXML
    private TextField m_vehiculeChoice;
    
    @FXML
    private Label m_lastDate;
    
    @FXML
    private Label m_firstDate;
    
    ArrayList<String> listOfCarsCustomers = new ArrayList<>(10);

    ObservableList<TableCarCustomer> listOfCarCustomer = FXCollections.observableArrayList();
      
    // static variables
    protected static String purpose;
    protected static String carName;
    protected static int idCar;
    protected static String name;
    protected static String lastName;
    protected static double price;
    protected static int days;
    protected static String userLogin;
    
    // classes instances
    FXMLDateEntranceController obj = new FXMLDateEntranceController();
    ProcessDataBase calculatePrice = new ProcessDataBase();
    DBGetter getCustomerPurpose = new DBGetter();
    FXMLRegisterCustomerController getUser = new FXMLRegisterCustomerController();
    
    // gets the values from the DateEntranceClass
    LocalDate first = obj.getFirst();
    LocalDate last = obj.getLast();

    

    public FXML_ListOfCarsCustomerController() {}

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        FXML_ListOfCarsCustomerController.userLogin = userLogin;
    }
    
    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        FXML_ListOfCarsCustomerController.days = days;
    }
    
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        FXML_ListOfCarsCustomerController.price = price;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        FXML_ListOfCarsCustomerController.idCar = idCar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        FXML_ListOfCarsCustomerController.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        FXML_ListOfCarsCustomerController.lastName = lastName;
    }
    
    public String getCarName() {
        return carName;
    }

    public static void setCarName(String carName) {
        FXML_ListOfCarsCustomerController.carName = carName;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        FXML_ListOfCarsCustomerController.purpose = purpose;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        m_firstDate.setText(first.toString());
        m_lastDate.setText(last.toString());
        try {
            Connection con = CarListAccess.getConnection();

            ResultSet rs = con.createStatement().executeQuery("SELECT vehicule_name, rental_price FROM vehicules where first_date >= '"+first+"' AND last_date <= '"+last+"'");
          
            while(rs.next()){
                listOfCarCustomer.add(new TableCarCustomer(rs.getString("vehicule_name"), rs.getDouble("rental_price")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(FXML_ListOfCarsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        vehicule_type.setCellValueFactory(new PropertyValueFactory<>("vehiculeName"));
        rentalPrice.setCellValueFactory(new PropertyValueFactory<>("vehiculePrice"));
        
        tableCar.setItems(listOfCarCustomer);
    }
    
    @FXML
    void onActionListCustomer(ActionEvent event) throws IOException {
        // additional options
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
        
        // choice of car
        try{

            if(event.getSource() == m_buttonChooseCar){
                if(m_vehiculeChoice.getText().isEmpty()){
                    throw new ExceptionCarNotChoosen();
                }else {
                    
                    userLogin = getUser.getUser(); // gets the user value during registration
                    carName = m_vehiculeChoice.getText();
                    idCar = getCustomerPurpose.GetPrimaryID("vehicules", carName, "vehicule_id"); // gets the vehicule ID of chosen car
                    purpose = getCustomerPurpose.GetStringUser("person", userLogin, "purpose"); // gets the purpose of the customer
                    price = calculatePrice.price_calculation(idCar,purpose, first, last); // calculates the price of the car
                    days = calculatePrice.period_calculator(first, last);
                    
                    System.err.println(days);
                    name = getCustomerPurpose.GetStringUser("person", userLogin, "firstname"); // gets the first name matching with the username
                    lastName = getCustomerPurpose.GetStringUser("person", userLogin, "lastname"); // gets the last name matching with the username
                    System.err.println(idCar);
                    Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/FXMLReservationInformation.fxml"));
                    Scene tableViewScene = new Scene(tableViewParent);
                    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    window.setScene(tableViewScene);
                    window.centerOnScreen();
                    window.show();
                }
            }
        } catch (ExceptionCarNotChoosen ex) {
            ex.getMessage();
        }
    }
    
    int index = -1;
    @FXML
    void getSelect(MouseEvent event) {
        index = tableCar.getSelectionModel().getSelectedIndex();
        if(index <= -1){
            return;
        }
        System.err.println("test");
    }
}