/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * sets the information of a vehicule
 * 
 */
public class Vehicule {
    protected String carType;
    protected double pricePerDay;
    protected double availabilities;
    protected double consuption;
    
    public Vehicule(String carType, double pricePerDay, double availabilities, double consuption){
        this.carType = carType;
        this.pricePerDay = pricePerDay;
        this.availabilities = availabilities;
        this.consuption = consuption;
    }
}
