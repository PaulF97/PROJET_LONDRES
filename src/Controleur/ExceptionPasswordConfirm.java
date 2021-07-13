/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import javax.swing.JOptionPane;

/**
* This personalized exception will be excecuted if 
* the customer has not confirmed his password will signing in
* the application
* author Paul Fisher
*/
public class ExceptionPasswordConfirm extends Exception{
    

    public ExceptionPasswordConfirm(){
        JOptionPane.showMessageDialog(null, "you need to confirm your password","error", JOptionPane.ERROR_MESSAGE);

    }
}
