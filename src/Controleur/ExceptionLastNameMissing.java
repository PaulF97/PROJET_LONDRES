/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import javax.swing.JOptionPane;

/**
* This personalized exception will be excecuted if 
* the customer has not entered his last name will signing in
* the application
* author Paul Fisher
*/
public class ExceptionLastNameMissing extends Exception {
    
    public ExceptionLastNameMissing(){
        JOptionPane.showMessageDialog(null, "you need to enter the last name","error", JOptionPane.ERROR_MESSAGE);

    }
}
