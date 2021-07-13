/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import javax.swing.JOptionPane;


/**
* This personalized exception will be excecuted if 
* the customer or employee has entered his username and password
* author Paul Fisher
*/
public class ExceptionIDEmpty extends Exception {
    
    public ExceptionIDEmpty(){
        JOptionPane.showMessageDialog(null, "you need to enter the password and username to login","error", JOptionPane.ERROR_MESSAGE);

    }
}
