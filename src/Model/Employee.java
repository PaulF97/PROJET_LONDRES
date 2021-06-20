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
public class Employee extends Person {
    
    public Employee(String firstName, String lastName, double idNumber, String type) {
        super(firstName, lastName, idNumber, type);
    }

    @Override
    public void browse_car() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}