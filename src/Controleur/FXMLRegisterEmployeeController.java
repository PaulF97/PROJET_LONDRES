package Controleur;

import Controleur.ExceptionAdminCodes;
import java.io.IOException;
import static javafx.application.Platform.exit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class FXMLRegisterEmployeeController {

    @FXML
    private Button m_buttonAdmin;

    @FXML
    private PasswordField m_passwordAdmin;

    @FXML
    private Button m_closeAdmin;

    @FXML
    private TextField m_userAdmin;

    @FXML
    private Button m_backAdmin;

    @FXML
    void onClickedAdmin(ActionEvent event) throws IOException { 

        
        if(event.getSource() == m_backAdmin){ 
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/Vue/FXMLSelectionPersonType.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.centerOnScreen();
            window.show();
        } else if(event.getSource() == m_closeAdmin){
            JOptionPane.showMessageDialog(null, "The application is about to close","information", JOptionPane.INFORMATION_MESSAGE);
            exit();
        }
            
        /*
        * Personalized Exception handling to prevent employee login errors
        *USERNAME = "admin"
        *PASSWORD = "root"
        */
        try{
            if(event.getSource() == m_buttonAdmin){
                if(!"admin".equals(m_userAdmin.getText()) || !"root".equals(m_passwordAdmin.getText())) // the admin login if false
                {
                    throw new ExceptionAdminCodes();
                } else{ // if the login is effective
                    Parent tableViewParent = FXMLLoader.load(getClass().getResource("/Vue/FXMLChoiceActionEmployee.fxml"));
                    Scene tableViewScene = new Scene(tableViewParent);
                    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    window.setScene(tableViewScene);
                    window.centerOnScreen();
                    window.show();
                }
            } 
        }catch(ExceptionAdminCodes e){ // Exception if login data is incorrect
            e.getMessage();
        }
    }
}