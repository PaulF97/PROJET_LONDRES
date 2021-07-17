/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Business class that inherited of MemberCustomer that will contain the information of a customer
 * with a business purpose
 * author : Paul Fisher and Savinien Godineau
 */
public class Business extends MemberCustomer{
    
    public Business(String firstName, String lastName, String idNumber, String password, String typePerson) {
        super(firstName, lastName, idNumber, password, typePerson);
    }
    
    public double businessDiscount(){
        
        return 0;
    }
}