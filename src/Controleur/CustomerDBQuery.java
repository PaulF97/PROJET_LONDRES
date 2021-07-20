/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class assures the connection of the database
 * and the run() method interprets SQL commands and reads 
 * in database
 * Savinien Godineau 
 */
public class CustomerDBQuery {
    
    // Database URL Constant
   public final String url = "jdbc:mysql://localhost:3306/project"; //DB_URL is the database url to connect to. projet is the name of our project
   public final String user = "root"; //user is your username to connect to the database
   public final String password = ""; //password is your password to connect to the database       
   private Connection conn;

    public CustomerDBQuery() {
       
    }
    
    /* 
    * Execute the query.
    */   
   public void run (String query){
      getDatabaseConnection(); // assure connection to the database      
      try
      {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);        
         int result = stmt.executeUpdate(query); // excecute SQL commands     
         stmt.close();
         conn.close();
      }
      catch (SQLException ex)
      {
         ex.printStackTrace();
      }
   }

   /*
   * Connection to the database
   */
    private void getDatabaseConnection() //Create the connection to the database.
    {
        try
        {         
           conn = DriverManager.getConnection(url, user, password);
        }
        catch (Exception ex)
        {
           ex.printStackTrace();
           System.exit(0);
        }
   }
   
}
