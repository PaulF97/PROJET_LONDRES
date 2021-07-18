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
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class FXMLSignInPlatformController {

    @FXML
    private Button m_buttonSign;

    @FXML
    private ToggleGroup m_purpose;

    @FXML
    private RadioButton m_notAccept;

    @FXML
    private TextField m_firstName;

    @FXML
    private Button m_backSignUp;

    @FXML
    private RadioButton m_accept;

    @FXML
    private RadioButton m_individual;

    @FXML
    private PasswordField m_passwordConfirm;

    @FXML
    private Button m_closeSignUp;

    @FXML
    private TextField m_lastName;

    @FXML
    private PasswordField m_password;

    @FXML
    private TextField m_username;
    
    @FXML
    private RadioButton m_business;

    @FXML
    private ToggleGroup m_choice;
    
    @FXML
    private TextField m_purposeWrite;
    
    @FXML
    void onClickedSign(ActionEvent event) throws IOException {
        
        /*
        * If the customer want's to go back or
        * close the app
        */
        if(event.getSource() == m_backSignUp){
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/Vue/FXMLAccountCheckCustomer.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.centerOnScreen();
            window.show();
        } else if(event.getSource() == m_closeSignUp){
            JOptionPane.showMessageDialog(null, "The application is about to close","information", JOptionPane.INFORMATION_MESSAGE);
            exit();
        }
        
        
        if(event.getSource() == m_buttonSign){
            // exception handling. Maxing sure that the data is correcty entered
            try{
                if(m_password.getText().isEmpty() && !m_password.getText().equals(m_passwordConfirm.getText()) && m_passwordConfirm.getText().isEmpty() && m_choice.getSelectedToggle() == m_notAccept && m_firstName.getText().isEmpty() && m_username.getText().isEmpty() && m_lastName.getText().isEmpty()){
                    throw new ExceptionFormEmpty();
                } else if(m_password.getText().isEmpty()){ // if the password has not been entered
                    throw new ExceptionPasswordEmpty();
                } else if(!m_password.getText().equals(m_passwordConfirm.getText())){ // if the password has not been confirmed correctly
                    throw new ExceptionPasswordMistake();
                } else if(m_passwordConfirm.getText().isEmpty()){ // if the password has not been confirmed
                    throw new ExceptionPasswordConfirm();
                } else if(m_choice.getSelectedToggle() == m_notAccept || m_choice.getSelectedToggle() != m_accept){ // if the GNU has not been accepted
                    throw new ExceptionAcceptConditions();
                } else if(m_firstName.getText().isEmpty()){ // if the first name has not been entered
                    throw new ExceptionFirstNameEmpty();
                } else if(m_username.getText().isEmpty()){ // if the username has not been entered
                    throw new ExceptionUsernameEmpty();
                } else if(m_lastName.getText().isEmpty()){ // if the last name has not been entered
                    throw new ExceptionLastNameMissing();
                }else if(m_purpose.getSelectedToggle() != m_business && m_purpose.getSelectedToggle() != m_individual){ // if the purpose has not been selected
                    throw new ExceptionPurpose();
                }
                else{ // if no exception has been thrown
                    String name = m_firstName.getText();
                    String lastName = m_lastName.getText();
                    String password = m_password.getText();
                    String user = m_username.getText();
                    String type = null;
                    
                    // set String value of the purpose
                    if(m_purpose.getSelectedToggle() == m_business){
                        type = "business";
                    }else if(m_purpose.getSelectedToggle() == m_individual){
                        type = "individual";
                    }
     
                    // write the information of the new customer in the database
                    CustomerDBQuery dataEnter = new CustomerDBQuery();        
                    dataEnter.run("INSERT INTO `person` (`Username`, `firstname`, `lastname`, `password`, `purpose`) VALUES ('"+user+"' , '"+name+"' , '"+lastName+"' , '"+password+"' , '"+type+"')");
                    JOptionPane.showMessageDialog(null, "Hello " + name + " " + lastName + " thank you for sining up","sign up", JOptionPane.INFORMATION_MESSAGE);
                    
                    Parent tableViewParent = FXMLLoader.load(getClass().getResource("/Vue/FXMLDateEntrance.fxml"));
                    Scene tableViewScene = new Scene(tableViewParent);
                    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    window.setScene(tableViewScene);
                    window.centerOnScreen();
                    window.show();
                }
             // exception processing   
            } catch(ExceptionPasswordMistake e){
                e.getMessage();
            } catch(ExceptionAcceptConditions e){
                e.getMessage();
            } catch(ExceptionPasswordConfirm e){
               e.getMessage();
            } catch(ExceptionFirstNameEmpty e){
                e.getMessage();
            } catch(ExceptionPasswordEmpty e){
                e.getMessage();
            } catch(ExceptionUsernameEmpty e){
               e.getMessage();
            } catch (ExceptionLastNameMissing e) {
                e.getMessage();
            } catch(ExceptionFormEmpty e){
                e.getMessage();
            } catch(ExceptionPurpose e){
                e.getMessage();
            }
        } 
    }
}