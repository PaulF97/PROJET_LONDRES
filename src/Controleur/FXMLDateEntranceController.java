package Controleur;

import java.io.IOException;
import java.time.LocalDate;
import static javafx.application.Platform.exit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class FXMLDateEntranceController {

    @FXML
    private DatePicker m_startDate;

    @FXML
    private Button m_closeDate;

    @FXML
    private DatePicker m_endDate;

    @FXML
    private Button m_backDate;

    @FXML
    private Button m_validateDate;
    
    @FXML
    void onClickedDate(ActionEvent event) throws IOException {
        
        if(event.getSource() == m_closeDate){
            JOptionPane.showMessageDialog(null, "The application is about to close","information", JOptionPane.INFORMATION_MESSAGE);
            exit(); 
        } else if(event.getSource() == m_backDate){
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("/Vue/FXMLPurpose.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.centerOnScreen();
            window.show();
        }
        
        else if(event.getSource() == m_validateDate){
            try{
                LocalDate currentDate = LocalDate.now(); // todays date
                LocalDate first = m_startDate.getValue(); // gets the first date
                LocalDate last = m_endDate.getValue(); // gets the last day
          
                // exception check to detect following unmatching or not coerent rental dates
                if((first == null && last == null)){
                    throw new ExceptionDatesEmpty();
                } else if (first == null){
                    throw new ExceptionDateStartEmpty();
                } else if(last == null){
                   throw new ExceptionDateEndEmpty();
                } else if(last.isBefore(first)){
                    throw new ExceptionDateLastBeforeFirst();
                } else if(first.isBefore(currentDate)){
                    throw new ExceptionDateStartBeforeCurrent();
                } else{
                   //JOptionPane.showMessageDialog(null, "ça marche !!!! ","test", JOptionPane.INFORMATION_MESSAGE);
                    Parent tableViewParent = FXMLLoader.load(getClass().getResource("/Vue/FXML_ListOfCars.fxml"));
                    Scene tableViewScene = new Scene(tableViewParent);
                    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    window.setScene(tableViewScene);
                    window.centerOnScreen();
                    window.show();
                }
            // exception processing    
            }catch (ExceptionDatesEmpty e){
                e.getMessage();
            }catch(ExceptionDateStartEmpty e){
                e.getMessage();
            }catch(ExceptionDateEndEmpty e){
                e.getMessage();
            }catch(ExceptionDateStartBeforeCurrent e){
                e.getMessage();
            }catch(ExceptionDateLastBeforeFirst e){
                e.getMessage();
            }  
        }    
    }
}