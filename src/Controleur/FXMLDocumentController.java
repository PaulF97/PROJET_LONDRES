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
* This class will display the welcome page of the application
* author : Paul Fisher
*/
public class FXMLDocumentController {

    @FXML
    private Button m_buttonFirst;
    
    
    @FXML
    private Button m_closeFirst;

    @FXML
    void onFirstClick(ActionEvent event) throws IOException{
        if(event.getSource() == m_buttonFirst){ // the start up page présenting our application
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/FXMLSelectionPersonType.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.centerOnScreen();
            window.show();
        } else if(event.getSource() == m_closeFirst){
            JOptionPane.showMessageDialog(null, "The application is about to close","information", JOptionPane.INFORMATION_MESSAGE);
            exit();
        }
    }
}