package Controleur;

import Model.Customer;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Logger;
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
    private Button m_validateDate;
    
    protected static LocalDate first;
    protected static LocalDate last;

    public LocalDate getFirst() {
        return first;
    }

    public LocalDate getLast() {
        return last;
    }

    public void setFirst(LocalDate first) {
        FXMLDateEntranceController.first = first;
    }

    public void setLast(LocalDate last) {
        FXMLDateEntranceController.last = last;
    }
    
    public FXMLDateEntranceController() {
    
    }
    
    /*
    * Source for get value of DatePicker : https://stackoverflow.com/questions/20446026/get-value-from-date-picker
    */
    @FXML
    void onClickedDate(ActionEvent event) throws IOException {
         if(event.getSource() == m_closeDate){
            JOptionPane.showMessageDialog(null, "The application is about to close","information", JOptionPane.INFORMATION_MESSAGE);
            exit(); 
        }
        
        else if(event.getSource() == m_validateDate){
            try{
                LocalDate currentDate = LocalDate.now(); // todays date
                first = m_startDate.getValue();   // gets the first date
                last = m_endDate.getValue();     // gets the last day
                    
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
                    
                    Parent tableViewParent = FXMLLoader.load(getClass().getResource("/View/FXML_ListOfCarsCustomer.fxml"));
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