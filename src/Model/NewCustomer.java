/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * NewCustomer class that inherited of MemberCustomer that will contain the information of a customer
 * who does not have an account
 * author : Paul Fisher and Savinien Godineau
 */
public class NewCustomer extends Customer{
    
    public NewCustomer(String firstName, String lastName, String username, String password, boolean typePerson) {
        super(firstName, lastName, username, password, typePerson);
    }
    
    public void register(){
        
    }
}
