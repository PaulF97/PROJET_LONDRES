/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.sql.Date;
import java.time.LocalDate;

/**
 * display all the reservations to the employee
 * @author fishe
 */
public class TableReservations {
    
    // attributs
    protected int nbReservation;
    protected String carName;
    protected Date firstDay;
    protected Date lastDay;
    protected String firstName;
    protected String lastName;
    protected String purpose;
    protected String usernameOfReservation;

    /**
     * initialize class variables
     * @param nbReservation
     * @param carName
     * @param firstDay
     * @param lastDay
     * @param firstName
     * @param lastName
     * @param purpose
     * @param usernameOfReservation
     */
    public TableReservations(int nbReservation, String carName, Date firstDay, Date lastDay, String firstName, String lastName, String purpose, String usernameOfReservation) {
        this.nbReservation = nbReservation;
        this.carName = carName;
        this.firstDay = firstDay;
        this.lastDay = lastDay;
        this.firstName = firstName;
        this.lastName = lastName;
        this.purpose = purpose;
        this.usernameOfReservation = usernameOfReservation;
    }

    /**
     * get the reservation number
     * @return
     */
    public int getNbReservation() {
        return nbReservation;
    }

    /**
     * set the reservation number
     * @param nbReservation
     */
    public void setNbReservation(int nbReservation) {
        this.nbReservation = nbReservation;
    }

    /**
     * get the car name which is rented
     * @return
     */
    public String getCarName() {
        return carName;
    }

    /**
     * set the car name which is rented
     * @param carName
     */
    public void setCarName(String carName) {
        this.carName = carName;
    }

    /**
     * get the first rental date
     * @return
     */
    public Date getFirstDay() {
        return firstDay;
    }

    /**
     * set the firt rental day
     * @param firstDay
     */
    public void setFirstDay(Date firstDay) {
        this.firstDay = firstDay;
    }

    /**
     * get the last rental day
     * @return
     */
    public Date getLastDay() {
        return lastDay;
    }

    /**
     * set the last rental day
     * @param lastDay
     */
    public void setLastDay(Date lastDay) {
        this.lastDay = lastDay;
    }

    /**
     * get the first name
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * set the first name
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * get the last name
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * set the last name
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * get the purpose
     * @return
     */
    public String getPurpose() {
        return purpose;
    }

    /**
     * set the purpose
     * @param purpose
     */
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    /**
     * get the username used for reservation
     * @return
     */
    public String getUsernameOfReservation() {
        return usernameOfReservation;
    }

    /**
     * set the username used for reservation
     * @param usernameOfReservation
     */
    public void setUsernameOfReservation(String usernameOfReservation) {
        this.usernameOfReservation = usernameOfReservation;
    }

    
    
}
