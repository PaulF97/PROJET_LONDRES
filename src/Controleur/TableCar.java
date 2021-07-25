/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

/**
 * This class will contain the information of the database
 * wich will be displayed when the employee will see the car list
 * Author : Paul fisher
 */
public class TableCar {
    
    protected double id;
    protected String name;
    protected String firstDate;
    protected String lastDate;
    protected double discount;
    protected double rentalPrice;

    /**
     * Initialize the class and attributs
     * @param id
     * @param name
     * @param firstDate
     * @param lastDate
     * @param discount
     * @param rentalPrice
     */
    public TableCar(double id, String name, String firstDate, String lastDate, double discount, double rentalPrice) {
        this.id = id;
        this.name = name;
        this.firstDate = firstDate;
        this.lastDate = lastDate;
        this.discount = discount;
        this.rentalPrice = rentalPrice;
    }

    /**
     * get the car ID
     * @return
     */
    public double getId() {
        return id;
    }

    /**
     * set the car ID
     * @param id
     */
    public void setId(double id) {
        this.id = id;
    }

    /**
     * get the car name
     * @return car name
     */
    public String getName() {
        return name;
    }

    /**
     *set the car name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get the first rental date
     * @return
     */
    public String getFirstDate() {
        return firstDate;
    }

    /**
     * set the first rental date
     * @param firstDate
     */
    public void setFirstDate(String firstDate) {
        this.firstDate = firstDate;
    }

    /**
     * get the last rental date
     * @return
     */
    public String getLastDate() {
        return lastDate;
    }

    /**
     * set the last rental date
     * @param lastDate
     */
    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    /**
     * get the discount percentage
     * @return
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * set the discount percentage
     * @param discount
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * get the total rental price
     * @return
     */
    public double getRentalPrice() {
        return rentalPrice;
    }

    /**
     * set the total rental price
     * @param rentalPrice
     */
    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }
}
