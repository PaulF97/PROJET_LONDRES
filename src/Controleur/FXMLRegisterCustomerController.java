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
    
    protected static String user;
    protected static String password;

    public FXMLRegisterCustomerController() {}

    public String getUser() {
        return user;
    }

    public static void setUser(String user) {
        FXMLRegisterCustomerController.user = user;
    }

    public String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        FXMLRegisterCustomerController.password = password;
    }
    
    
    
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
                 user = m_username.getText();
                 password = m_passwordField.getText();
                 if(user.isEmpty() && password.isEmpty()){
                    throw new ExceptionPasswordANDusernameEmpty();
                } else if(password.isEmpty()){
                    throw new ExceptionPasswordEmpty();
                } else if(user.isEmpty()){
                    throw new ExceptionUsernameEmpty();
                }
                else{ // if no exceptions has been throwned
                    boolean login;
                    login = obj.Check_Login(user, password); // check the correlation between username and password in the table
                   
                    // check return value of Check_Login method.
                    if(login == true){ // true : login successful
                        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/FXMLDateEntrance.fxml"));
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