/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import javax.swing.JOptionPane;

/**
* This personalized exception will be excecuted if 
* the customer has not entered the purpose of his rental issue
* the application
* author Paul Fisher
*/
public class ExceptionPurpose extends Exception {
    
    public ExceptionPurpose(){
        JOptionPane.showMessageDialog(null, "you need to write the purpose","error", JOptionPane.ERROR_MESSAGE);
    }
}
