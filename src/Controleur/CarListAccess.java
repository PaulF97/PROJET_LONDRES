/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fishe
 */
public class CarListAccess {
    
    public static Connection getConnection(){
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=");
            return conn;

        } catch (SQLException ex) {
            Logger.getLogger(CarListAccess.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
}
