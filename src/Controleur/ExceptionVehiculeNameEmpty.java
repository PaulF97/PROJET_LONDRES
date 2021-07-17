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
public class ExceptionVehiculeNameEmpty extends Exception {

    public ExceptionVehiculeNameEmpty() {
        JOptionPane.showMessageDialog(null, "you need to enter the vehicule name","error", JOptionPane.ERROR_MESSAGE);

    }
    
}
