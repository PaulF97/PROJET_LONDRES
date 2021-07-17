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
public class ExceptionPurposeEnter extends Exception {

    public ExceptionPurposeEnter() {
        JOptionPane.showMessageDialog(null, "you have not spell the write purpose. You can Only write 'individual' OR 'business' ","error", JOptionPane.ERROR_MESSAGE);
    }
    
}
