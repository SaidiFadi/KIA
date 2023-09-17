/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientmanegmentsystemmiapop;

/**
 *
 * @author FADI
 */
public class bdData {
    private String bdName;
    private String dateCreation;
    private String nbMAX;
    
    
    public bdData(String bdName, String dateCreation, String nbMAX){
        this.bdName = bdName;
        this.dateCreation = dateCreation;
        this.nbMAX = nbMAX;
    }
    public String getBdName(){
        return bdName;
    }
    public String getDateCreation(){
        return dateCreation;
    }
    public String getNbMAX(){
        return nbMAX;
    }
}
