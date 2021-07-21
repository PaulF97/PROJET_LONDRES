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
 *
 * @author fishe
 */
public class FXMLSelectionPersonTypeController {

    @FXML
    private Button m_buttonEmployee;

    @FXML
    private Button m_buttonCustomer;
    
    @FXML
    private Button m_closeType;

    @FXML
    void onClickedChoice(ActionEvent event) throws IOException {
        if(event.getSource() == m_buttonCustomer){ // if the person is a customer, a page will open where to check if he has an account
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/FXMLAccountCheckCustomer.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.centerOnScreen();
            window.show();
        } else if(event.getSource() == m_buttonEmployee){ // if the person is a employee, a page will open where he will need to enter the admin codes
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/FXMLRegisterEmployee.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.centerOnScreen();
            window.show();
        } else if(event.getSource() == m_closeType){
            JOptionPane.showMessageDialog(null, "The application is about to close","information", JOptionPane.INFORMATION_MESSAGE);
            exit();
        }
    }
}
