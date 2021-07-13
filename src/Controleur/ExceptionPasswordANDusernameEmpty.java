/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import javax.swing.JOptionPane;

/**
* This personalized exception will be excecuted if 
* the employee who has a account has not entered the username
* and his password
* author Paul Fisher
*/
public class ExceptionPasswordANDusernameEmpty extends Exception{
    
    public ExceptionPasswordANDusernameEmpty(){
    
        JOptionPane.showMessageDialog(null, "You need to enter the password and username","error", JOptionPane.ERROR_MESSAGE);

    }
}
