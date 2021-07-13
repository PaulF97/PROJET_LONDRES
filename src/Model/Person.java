/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * abstract class that will represent the model of Person
 * author : Paul Fisher and Savinien Godineau
 */
public abstract class Person {
    
    protected String firstName;
    protected String lastName;
    protected String username;
    protected String password;
    
    public Person(String firstName, String lastName, String username, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;

    }
    
    public abstract void browseCar();
}
