/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import javax.swing.JOptionPane;

/**
 * This personalized exception will be excecuted if
 * the employee has not entered the vehicule name
 * Paul fisher
 */
public class ExceptionVehiculeNameEmpty extends Exception {

    public ExceptionVehiculeNameEmpty() {
        JOptionPane.showMessageDialog(null, "you need to enter the vehicule name","error", JOptionPane.ERROR_MESSAGE);

    }
    
}
