/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import javax.swing.JOptionPane;

/**
* This personalized exception will be excecuted if 
* the customer has not entered his username will signing in
* the application
* author Paul Fisher
*/
public class ExceptionUsernameEmpty extends Exception {
    
    public ExceptionUsernameEmpty(){
        JOptionPane.showMessageDialog(null, "you need to enter the username","error", JOptionPane.ERROR_MESSAGE);
    }
}
