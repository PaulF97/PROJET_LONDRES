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
public class ExceptionCarNotChoosen extends Exception {

    public ExceptionCarNotChoosen() {
        JOptionPane.showMessageDialog(null, "You need to enter a car number identification before passing to paiment","error", JOptionPane.ERROR_MESSAGE);    
    }
    
}
