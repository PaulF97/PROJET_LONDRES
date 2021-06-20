/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author fishe
 */
public class Business extends Member_Customer{
    
    public Business(String firstName, String lastName, double idNumber, String type) {
        super(firstName, lastName, idNumber, type);
    }
    
    public double Business_Discount(){
        
        return 0;
    }
}