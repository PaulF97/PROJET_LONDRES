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
    
    ProcessDataBase obj = new ProcessDataBase();
    @FXML
    void onClickedRegister(ActionEvent event) throws IOException {

        
        if(event.getSource() == m_backCustomerLogin){
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/FXMLAccountCheckCustomer.fxml"));
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
                 DBGetter Getdata = new DBGetter();
                 if(m_username.getText().isEmpty() && m_passwordField.getText().isEmpty()){
                    throw new ExceptionPasswordANDusernameEmpty();
                } else if(m_passwordField.getText().isEmpty()){
                    throw new ExceptionPasswordEmpty();
                } else if(m_username.getText().isEmpty()){
                    throw new ExceptionUsernameEmpty();
                }
                else{ // if no exceptions has been throwned
                    boolean login;
                    login = obj.Check_Login(m_username.getText(), m_passwordField.getText()); // check the correlation between username and password in the table
                   
                    // check return value of Check_Login method.
                    if(login == true){ // true : login successful
                        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/FXMLPurpose.fxml"));
                        Scene tableViewScene = new Scene(tableViewParent);
                        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                        window.setScene(tableViewScene);
                        window.centerOnScreen();
                        window.show();  
                    } else{ // false : throws exception because error in username or password
                       throw new ExceptionLoginCustomerFailed();
                    }
                }
            }
        // exception processing   
        }catch(ExceptionPasswordEmpty e){ // password empty
            e.getMessage();
        } catch (ExceptionUsernameEmpty e){ // username empty
            e.getMessage();
        }catch(ExceptionPasswordANDusernameEmpty e){ // both empty
            e.getMessage();
        } catch (ExceptionLoginCustomerFailed ex) { // username or password incorrect
           ex.getMessage();
        }
    }
}