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
import javax.swing.JOptionPane;


/**
* This class will manege the page where the customer
* needs to choose if he will login or go to the sinup page
* to create a account
* author : Paul Fisher
*/
public class FXMLAccountCheckCustomerController {

    @FXML
    private Button m_buttonYes;

    @FXML
    private Button m_buttonNO;
    
    @FXML
    private Button m_backAccountCheck;

    @FXML
    private Button m_closeAccountCheck;

    
    
    @FXML
    void onClickedChoice(ActionEvent event) throws IOException {
        if(event.getSource() == m_buttonYes){ // if the customer has already a account
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/FXMLRegisterCustomer.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.centerOnScreen();
            window.show();
        } else if(event.getSource() == m_buttonNO){ // if the person is a "New Customer", he will need to sign up before continuing
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/FXMLSignInPlatform.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.centerOnScreen();
            window.show();
        } else if(event.getSource() == m_backAccountCheck){ // go back to person selection
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/FXMLSelectionPersonType.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.centerOnScreen();
            window.show();
        } else if(event.getSource() == m_closeAccountCheck){ // close app
            JOptionPane.showMessageDialog(null, "The application is about to close","information", JOptionPane.INFORMATION_MESSAGE);
            exit();
        }
    }
}