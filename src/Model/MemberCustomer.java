/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


/**
 * MemberCustomer class that inherited of MemberCustomer that will contain the information of a customer
 * who has an account
 * author : Paul Fisher and Savinien Godineau
 */
public class MemberCustomer extends Customer {
    
    public MemberCustomer(String firstName, String lastName, String username, String password, String typePerson) {
        super(firstName, lastName, username, password, typePerson);
    }
    
    public void login(){
        
    }
}
