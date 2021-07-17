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
public class ExceptionVehiculeIDEmpty extends Exception {

    public ExceptionVehiculeIDEmpty() {
        JOptionPane.showMessageDialog(null, "you need to enter the car number identification","error", JOptionPane.ERROR_MESSAGE);

    }
    
}
