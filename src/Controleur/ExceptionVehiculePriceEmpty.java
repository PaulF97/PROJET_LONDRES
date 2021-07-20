/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import javax.swing.JOptionPane;

/**
 * This personalized exception will be excecuted if
 * the employee has not entered the vehicule price
 * Paul fisher
 */
public class ExceptionVehiculePriceEmpty extends Exception {

    public ExceptionVehiculePriceEmpty() {
        JOptionPane.showMessageDialog(null, "you need to enter the vehicule price","error", JOptionPane.ERROR_MESSAGE);
    }
    
}
