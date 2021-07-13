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
 *
 * @author fishe
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
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/Vue/FXMLRegisterCustomer.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.centerOnScreen();
            window.show();
        } else if(event.getSource() == m_buttonNO){ // if the person is a "New Customer", he will need to sign up before continuing
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/Vue/FXMLSignInPlatform.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.centerOnScreen();
            window.show();
        } else if(event.getSource() == m_backAccountCheck){
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/Vue/FXMLSelectionPersonType.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.centerOnScreen();
            window.show();
        } else if(event.getSource() == m_closeAccountCheck){
            exit();
        }
    }
}