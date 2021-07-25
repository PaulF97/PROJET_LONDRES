/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import javax.swing.JOptionPane;

/**
 * this personalized exception will be excecuted
 * if the car name entered by the customer is wrong
 * author Paul fisher
 */
public class ExceptionCarNameWrong extends Exception {

    public ExceptionCarNameWrong() {
        JOptionPane.showMessageDialog(null, "You need to choose a available car before passing to the paiement","error", JOptionPane.ERROR_MESSAGE);    
    }
}