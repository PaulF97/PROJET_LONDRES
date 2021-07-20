/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import javax.swing.JOptionPane;

/**
* This personalized exception will be excecuted if 
* the rental dates are not entered by the customer 
* and the employee if he is adding a car
* author Paul Fisher
*/
public class ExceptionDatesEmpty extends Exception {
    
    public ExceptionDatesEmpty(){
        JOptionPane.showMessageDialog(null, "You havn't entered the rental dates","error", JOptionPane.ERROR_MESSAGE);

    }
}
