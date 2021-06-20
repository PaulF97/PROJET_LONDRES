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

public abstract class Person {
    
    protected String firstName;
    protected String lastName;
    protected double idNumber;
    protected String type;
    
    public Person(String firstName, String lastName, double idNumber, String type){
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.type = type;
    }
    
    public abstract void browse_car();
}
