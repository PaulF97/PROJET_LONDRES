/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import javax.swing.JOptionPane;

/**
* This personalized exception will be excecuted if 
* the last rental date is before the first rental date by the customer
* and the employee if he want's to add a car
* author Paul Fisher
*/
public class ExceptionDateLastBeforeFirst extends Exception {
            
    public ExceptionDateLastBeforeFirst(){
        JOptionPane.showMessageDialog(null, "The ending date cannot be before the first day","error", JOptionPane.ERROR_MESSAGE);
    }
}
