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
public class FXMLDocumentController {

    @FXML
    private Button m_buttonFirst;
    
    
    @FXML
    private Button m_closeFirst;

    @FXML
    void onFirstClick(ActionEvent event) throws IOException{
        if(event.getSource() == m_buttonFirst){ // the start up page présenting our application
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/Vue/FXMLSelectionPersonType.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.centerOnScreen();
            window.show();
        } else if(event.getSource() == m_closeFirst){
            exit();
        }
    }
}