/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * Individual class that inherited of MemberCustomer that will contain the information of a customer
 * with a Individual purpose
 * author : Paul Fisher and Savinien Godineau
 */
public class Individual extends MemberCustomer{
    
    public Individual(String firstName, String lastName, String username, String password, String typePerson) {
        super(firstName, lastName, username, password, typePerson);
    }
    
    public double individualDiscount(){
        return 0;
    }
}
