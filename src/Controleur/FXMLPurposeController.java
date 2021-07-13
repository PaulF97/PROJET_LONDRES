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

public class FXMLPurposeController {

    @FXML
    private Button m_closePurpose;

    @FXML
    private Button m_personnal;

    @FXML
    private Button m_business;

    @FXML
    void onClickedPurpose(ActionEvent event) throws IOException {
        if(event.getSource() == m_personnal || event.getSource() == m_business){
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/Vue/FXML_ListOfCars.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.centerOnScreen();
            window.show();
        } else if(event.getSource() == m_closePurpose){ // if the customer want's to interupt the processt
            exit();
        }
    }

}
