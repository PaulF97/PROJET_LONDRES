/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import javax.swing.JOptionPane;

/**
* This personalized exception will be excecuted if 
* the customer has not entered  his email
* when he is confirming the booking
* author Paul Fisher
*/
public class ExceptionMailConfirmationEmpty extends Exception {

    public ExceptionMailConfirmationEmpty() {
        JOptionPane.showMessageDialog(null, "Please enter a valid email adress","error", JOptionPane.ERROR_MESSAGE);
        
    }
    
}
