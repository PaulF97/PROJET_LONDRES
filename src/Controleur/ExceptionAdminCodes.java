/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import javax.swing.JOptionPane;

/**
* This personalized exception will be excecuted if 
* the employee has not entered the administrator login
* author Paul Fisher
*/
public class ExceptionAdminCodes extends Exception{
   
    public ExceptionAdminCodes(){

        JOptionPane.showMessageDialog(null, "You havn't entered the administrator ID","error", JOptionPane.ERROR_MESSAGE);
    }
}
