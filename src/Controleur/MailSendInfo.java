/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.time.LocalDate;

/**
 * This class will gather the needed information
 * to send a confirmation mail when the booking 
 * is confirmed
 * author : Paul Fisher 
 */
public class MailSendInfo {

    FXMLReservationInformationController customerResaInfo = new FXMLReservationInformationController();
    
    
    
    public MailSendInfo() {
        // get the customer info of reservation
        String name = customerResaInfo.getFirstNamePurpose();
        String last = customerResaInfo.getLastNamePurpose();
        LocalDate rentalFirst = customerResaInfo.getFirst();
        LocalDate rentalLast = customerResaInfo.getLast();
        String price = customerResaInfo.getPriceToString();
        String motif = customerResaInfo.getPurposeRecap();
        String sendConfirmation = customerResaInfo.getMail();
        
        System.err.println("test mail class");
        System.out.println(name);
        System.out.println(last);
        System.out.println(rentalFirst);
        System.out.println(rentalLast);
        System.out.println(price);
        System.out.println(motif);
        System.out.println(sendConfirmation);
    }
    
    /*
    *this method will send the email 
    *to the adress writing in the confirmation 
    *class
    * source : https://www.youtube.com/watch?v=A7HAB5whD6I&t=361s
    * author : Paul Fisher
    */
   
    public void sentConfirmation(){
        
    }
}
