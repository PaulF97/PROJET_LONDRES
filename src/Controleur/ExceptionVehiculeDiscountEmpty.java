/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import javax.swing.JOptionPane;

/**
 *
 * @author fishe
 */
public class ExceptionVehiculeDiscountEmpty extends Exception {

    public ExceptionVehiculeDiscountEmpty() {
        JOptionPane.showMessageDialog(null, "you need to enter the discount price","error", JOptionPane.ERROR_MESSAGE);

    }
    
}
