/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import javax.swing.JOptionPane;

/**
 * this personalized exception will be excecuted
 * if no car has been entered
 * Paul fisher
 */
public class ExceptionCarNotChoosen extends Exception {

    public ExceptionCarNotChoosen() {
        JOptionPane.showMessageDialog(null, "You need to enter an available car","error", JOptionPane.ERROR_MESSAGE);    
    }
    
}
