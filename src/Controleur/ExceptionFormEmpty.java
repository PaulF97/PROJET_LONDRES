/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import javax.swing.JOptionPane;

/**
* This personalized exception will be excecuted if 
* the new customer has not signed up
* author Paul Fisher
*/
public class ExceptionFormEmpty extends Exception {
    
    public ExceptionFormEmpty(){
        JOptionPane.showMessageDialog(null, "you need to fill in the sign up form","error", JOptionPane.ERROR_MESSAGE);
    }
}
