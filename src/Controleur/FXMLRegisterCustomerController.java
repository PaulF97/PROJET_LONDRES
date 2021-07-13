package Controleur;

import Controleur.ExceptionIDEmpty;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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


/**
 *
 * @author fishe
 */
public class FXMLRegisterCustomerController {


    @FXML
    private Button m_buttonRegister;

    @FXML
    private Button m_backCustomerLogin;

    @FXML
    private PasswordField m_passwordField;

    @FXML
    private Button m_closeCustomerLogin;

    @FXML
    private TextField m_username;

    @FXML
    void onClickedRegister(ActionEvent event) throws IOException {

       
        if(event.getSource() == m_backCustomerLogin){
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/Vue/FXMLAccountCheckCustomer.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.centerOnScreen();
            window.show();
        } else if(event.getSource() == m_closeCustomerLogin){
            JOptionPane.showMessageDialog(null, "The application is about to close","information", JOptionPane.INFORMATION_MESSAGE);
            exit();
        }
 
        /*
        * Personalized Exception handling to prevent customer login errors
        */
        try{
            if(event.getSource() == m_buttonRegister ){
                
                 if(m_username.getText().isEmpty() && m_passwordField.getText().isEmpty()){
                    throw new ExceptionPasswordANDusernameEmpty();
                } else if(m_passwordField.getText().isEmpty()){
                    throw new ExceptionPasswordEmpty();
                } else if(m_username.getText().isEmpty()){
                    throw new ExceptionUsernameEmpty();
                } else{ // if the login is succeded
                    Parent tableViewParent = FXMLLoader.load(getClass().getResource("/Vue/FXMLPurpose.fxml"));
                    Scene tableViewScene = new Scene(tableViewParent);
                    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    window.setScene(tableViewScene);
                    window.centerOnScreen();
                    window.show(); 
                }
            }
            }catch(ExceptionPasswordEmpty e){ // password empty
                e.getMessage();
            } catch (ExceptionUsernameEmpty e){ // username empty
                e.getMessage();
            }catch(ExceptionPasswordANDusernameEmpty e){
                e.getMessage();
            }
    }
}