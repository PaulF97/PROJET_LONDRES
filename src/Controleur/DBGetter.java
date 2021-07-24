/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.sql.*;

/**
 *
 * savig
 */
public class DBGetter {
    
// Database URL Constant
   public final String DB_URL = "jdbc:mysql://localhost:3306/project"; //DB_URL is the database url to connect to. projet is the name of our project
   public final String user = "root"; //user is your username to connect to the database
   public final String password = ""; //password is your password to connect to the database       
   private Connection conn;      

   public DBGetter(){}
   
   //The role of this method is to retrieve data from the vehicule table. It is necessary to define several parameters :
   //the name of the table in which the data to be acquired is located, we could do without this parameter but it allows a better readability 
   //the number of the line we are interested in (the number of the line corresponds to the ID of the vehicle, we can know it by looking at the database for example) 
   //the name of the column which is finally the name of the data we are trying to obtain.
   //For example, if we want to know the name of the vehicle with ID 5, we can use the following command: GetString("vehicles", 5, "vehicle_name")+ " car") 
   //The method will return the name of the vehicle as a String. 

   public String GetString (String table_name, int line_number, String column_name){      
      getDatabaseConnection();  
      String data = "xxx";
      try
      {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         String query = "SELECT * FROM "+table_name+" WHERE Vehicule_id<="+line_number+" AND Vehicule_id>"+ mineone(line_number);        
         ResultSet results = stmt.executeQuery(query);
         while (results.next()) { 
         // Get the data from the current row using the column index
         data = results.getString(1);          
         // Get the data from the current row using the column name
         data = results.getString(column_name);
 
 
}
         stmt.close();
         conn.close();         
      }
      catch (SQLException ex)
      {
         ex.printStackTrace();
      }
      return data;
   }
   
    public int GetPrimaryID (String table_name, String carname, String column_name){
        getDatabaseConnection();
        String data = "xxx";
        try
        {
           Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           String query = "SELECT * FROM "+table_name+" WHERE vehicule_name LIKE '"+carname+"'";
           ResultSet results = stmt.executeQuery(query);
           while (results.next()) { 
                // Get the data from the current row using the column index
                data = results.getString(1);
                // Get the data from the current row using the column name
                data = results.getString(column_name);
            }
            stmt.close();
            conn.close();
        }catch (SQLException ex){
           ex.printStackTrace();
        }
        return Integer.parseInt(data);
   }
   
   //This method has exactly the same role and use as the previous one except that it will return an int and not a string, which is more convenient for processing.
   public int GetInt (String table_name, int line_number, String column_name){      
      getDatabaseConnection();  
      String data = "xxx";
      try
      {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         String query = "SELECT * FROM "+table_name+" WHERE Vehicule_id<="+line_number+" AND Vehicule_id>"+ mineone(line_number);        
         ResultSet results = stmt.executeQuery(query);
         while (results.next()) { 
         // Get the data from the current row using the column index
         data = results.getString(1);          
         // Get the data from the current row using the column name
         data = results.getString(column_name);
 
 
}
         stmt.close();
         conn.close();         
      }
      catch (SQLException ex)
      {
         ex.printStackTrace();
      }     
      
      //Convert String to int : 
      return Integer.parseInt(data);     
   }

   //The role of this method is to retrieve data from the person table. It is necessary to define several parameters :
   //the name of the table in which the data to be acquired is located, we could do without this parameter but it allows a better readability 
   //the Username value of the user we are interested in 
   //the name of the column which is finally the name of the data we are trying to obtain.
   //For example, if we want to know the firstname of the User called Sav, we can use the following command : GetStringUser("person", "Sav", "firstname")
   //The method will return the firstname of the User called Sav as a String. 
   public String GetStringUser (String table_name, String username, String column_name){      
      getDatabaseConnection();  
      String data = "xxx";
      try
      {
         Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
         String query = "SELECT * FROM "+table_name+" WHERE Username LIKE '"+username+"'";        
         ResultSet results = stmt.executeQuery(query);
         while (results.next()) { 
         // Get the data from the current row using the column index
         data = results.getString(1);          
         // Get the data from the current row using the column name
         data = results.getString(column_name);
 
 
}
         stmt.close();
         conn.close();         
      }
      catch (SQLException ex)
      {
         ex.printStackTrace();
      }
      return data;
   }   
   
public void getDatabaseConnection() //Create the connection to the database.
   {
      try
      {         
         conn = DriverManager.getConnection(DB_URL, user, password);
      }
      catch (Exception ex)
      {
         ex.printStackTrace();
         System.exit(0);
      }
   }
   
   //This method is not important, it just allows a better readability.
   private int mineone(int a){
       return a-1;
   }
}
