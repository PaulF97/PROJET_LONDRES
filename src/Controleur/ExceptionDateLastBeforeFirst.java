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
public class ExceptionDateLastBeforeFirst extends Exception {
            
    public ExceptionDateLastBeforeFirst(){
        JOptionPane.showMessageDialog(null, "The ending date cannot be before the first day","error", JOptionPane.ERROR_MESSAGE);
    }
}
