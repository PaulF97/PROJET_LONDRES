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
 * database connection
 * author fishe
 */
public class CarListAccess {
    
    /**
     * connection with the database
     * @return null
     */
    public static Connection getConnection(){
        Connection conn;
        try {
            
            String url       = "jdbc:mysql://localhost:3306/project";
            String user      = "root";
            String password  = "";
            conn = DriverManager.getConnection(url, user, password); // BDD connection
            return conn;

        } catch (SQLException ex) {
            Logger.getLogger(CarListAccess.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
