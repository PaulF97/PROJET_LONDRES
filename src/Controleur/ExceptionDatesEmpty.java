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
public class ExceptionDatesEmpty extends Exception {
    
    public ExceptionDatesEmpty(){
        JOptionPane.showMessageDialog(null, "You havn't entered the rental dates","error", JOptionPane.ERROR_MESSAGE);

    }
}