/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

/**
 * This class will contain the information of the database
 * wich will be displayed when the customer will choose his car
 * Author : Paul fisher
 */
public class TableCarCustomer {
    

    protected String vehiculeName;
    protected double vehiculePrice;

    /**
     * initialize the class
     * @param vehiculeName
     * @param vehiculePrice
     */
    public TableCarCustomer(String vehiculeName, double vehiculePrice) {
        this.vehiculeName = vehiculeName;
        this.vehiculePrice = vehiculePrice;
    }
    
    /**
     * get the vehicule name
     * @return
     */
    public String getVehiculeName() {
        return vehiculeName;
    }

    /**
     * set the vehicule name
     * @param vehiculeName
     */
    public void setVehiculeName(String vehiculeName) {
        this.vehiculeName = vehiculeName;
    }

    /**
     * get the vehicule price
     * @return
     */
    public double getVehiculePrice() {
        return vehiculePrice;
    }

    /**
     * set the vehicule price
     * @param vehiculePrice
     */
    public void setVehiculePrice(double vehiculePrice) {
        this.vehiculePrice = vehiculePrice;
    }



}
