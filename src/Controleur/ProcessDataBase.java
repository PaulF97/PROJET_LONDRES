/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import javax.swing.JOptionPane;

/**
 * This class assures the connection of the database
 * and the run() method interprets SQL commands and reads 
 * in database
 * Savinien Godineau 
 */
public class ProcessDataBase {

    /*This method allows you to calculate the total cost of renting a vehicle over a period delimited by 2 dates in LOCALDATE format. 
    *It is also necessary to specify which vehicle you wish to rent (the vehicle is designated by its ID) and to specify whether or not the client has a discount.
    */
    public double price_calculation(int vehiculeID, String type, LocalDate first_date, LocalDate last_date){
        DBGetter Getdata = new DBGetter();
        double discount = 0;
        
        //Calculation of an eventual discount : 
        if("business".equals(type)){
            discount = Getdata.GetInt("vehicules", vehiculeID, "discount");
        }else discount = 0;
        
        //Period between dates calculation : 
        int period = period_calculator(first_date, last_date);
        
        //Calculation of the cost for the indicated period : 
        double resultat = period * Getdata.GetInt("vehicules", vehiculeID, "rental_price");
       
        //Discount application : 
        return resultat - ((discount /100)*resultat);
    }
    
    /*
    *This method calculates the duration between 2 dates in LOCALDATE format
    */
    public int period_calculator(LocalDate first_date, LocalDate last_date){        
        Period period = Period.between(first_date, last_date);
        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();
        
        //Total amount of time : 
        int total_day_nb = (years * 365) + (months * 30) + days;
        return total_day_nb;
    }
    
    /*This method allows to know if the login information entered by an user are correct. This method takes 2 parameters : 
    *the username entered by the client.
    *the password entered by the client. 
    *If the input matches the data in the database, the method returns "true" otherwise it returns "false".
    */
    public boolean Check_Login(String username, String password) throws IOException{
        DBGetter Getdata = new DBGetter();
        if (Getdata.GetStringUser("person", username, "Username").equals(username) && Getdata.GetStringUser("person", username, "password").equals(password)){
            JOptionPane.showMessageDialog(null, "You have login","information Customer", JOptionPane.INFORMATION_MESSAGE); 
            return true;
        }else {
            return false;
        }
    }
}
