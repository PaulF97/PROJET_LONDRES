/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import javax.swing.JOptionPane;

/**
* This personalized exception will be excecuted if 
* the customer has not entered his password will signing in
* the application
* author Paul Fisher
*/
public class ExceptionPasswordEmpty extends Exception{
        
    public ExceptionPasswordEmpty(){
        JOptionPane.showMessageDialog(null, "you need to enter the password","error", JOptionPane.ERROR_MESSAGE);
    }
}
