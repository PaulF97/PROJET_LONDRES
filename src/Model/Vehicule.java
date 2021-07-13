/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * class that will set the information of a vehicule
 * author : Paul Fisher and Savinien Godineau
 */
public class Vehicule {
   
    protected String carType;
    protected double pricePerDay;
    protected double consuption;
    protected boolean available;
            
    public Vehicule(String carType, double pricePerDay, double availabilities, double consuption, boolean available){
        this.carType = carType;
        this.pricePerDay = pricePerDay;
        this.consuption = consuption;
        this.available = available;
    }
}
