/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientmanegmentsystemmiapop;

import java.sql.Date;

/**
 *
 * @author FADI
 */
public class clientData {
    private String clientId;
    private String firstName;
    private String lastName;
    private String CIN;
    private String adresse;
    private String phoneNumone;
    private String phoneNumtwo;
    private String etat;
    private Date date;
    
  private String ddSMS;
   private String ddReponse;
   private String commentaire;
   private String bdName;
    
    public clientData(String clientId, String firstName, String lastName, String CIN, String adresse, String phoneNumone, String phoneNumtwo, String etat, Date date){
    this.clientId = clientId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.CIN = CIN;
    this.adresse=adresse;
    this.phoneNumone = phoneNumone;
    this.phoneNumtwo = phoneNumtwo;
    this.etat = etat;
    this.date = date;
    
    }
    public clientData(String clientId, String firstName, String lastName, String CIN, String phoneNumone, String phoneNumtwo, Date date, String ddSMS, String etat, String ddReponse,String commentaire, String bdName){
    this.clientId = clientId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.CIN = CIN;
    this.phoneNumone = phoneNumone;
    this.phoneNumtwo = phoneNumtwo;
    this.date = date;
    this.ddSMS = ddSMS;
        this.etat = etat;
        this.ddReponse = ddReponse ;
        this.commentaire = commentaire;
        this.bdName = bdName;

    
    }
    public String getClientId(){
        return clientId;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getCIN(){
        return CIN;
    }
     public String getAdresse(){
        return adresse;
    }
    public String getPhoneNumone(){
        return phoneNumone;
    } 
    public String getPhoneNumtwo(){
        return phoneNumtwo;
    }  
   
    public String getEtat(){
        return etat;
    }
    public Date getDate(){
        return date;
    }
    public String getDdSMS(){
        return ddSMS;
    }
    public String getDdReponse(){
        return ddReponse;
    }
    public String getCommentaire(){
        return commentaire;
    }
     public String getBdName(){
        return bdName;
    } 
    }
