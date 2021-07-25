/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import javax.swing.JOptionPane;

/**
*This personalized exception will be excecuted if 
* the customer has not accepted the general conditions
* of the application
* author Paul Fisher
*/
public class ExceptionAcceptConditions extends Exception{

    public ExceptionAcceptConditions(){
        JOptionPane.showMessageDialog(null, "you need to accept the terms and conditions","error", JOptionPane.ERROR_MESSAGE);
    }
}
