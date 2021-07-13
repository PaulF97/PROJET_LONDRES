/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import javax.swing.JOptionPane;

/**
* This personalized exception will be excecuted if 
* the customer has not entered correctly his password name will signing in
* the application
* author Paul Fisher
*/
public class ExceptionPasswordMistake extends Exception {
    
    public ExceptionPasswordMistake(){
        JOptionPane.showMessageDialog(null, "you have maked a writing mistake on the password or you did not confirm the password correctly","error", JOptionPane.ERROR_MESSAGE);
    }
}
