/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import javax.swing.JOptionPane;

/**
* This personalized exception will be excecuted if 
* the customer has entered a incorrect username or password
* while login
* author Paul Fisher
*/
public class ExceptionLoginCustomerFailed extends Exception{

    public ExceptionLoginCustomerFailed() {
        JOptionPane.showMessageDialog(null, "The username or the password is incorrect","error", JOptionPane.ERROR_MESSAGE);
    }
    
}
