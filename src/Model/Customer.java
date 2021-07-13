/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * class that inherited of Person that will contain the information of a customer
 * author : Paul Fisher and Savinien Godineau
 */
public class Customer extends Person {
    
    protected boolean typePerson;
    
    public Customer(String firstName, String lastName, String username, String password, boolean typePerson) {
        super(firstName, lastName, username, password);
        this.typePerson = typePerson;
    }

    @Override
    public void browseCar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // getter
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    
    public boolean getType(){
        return typePerson;
    }
}