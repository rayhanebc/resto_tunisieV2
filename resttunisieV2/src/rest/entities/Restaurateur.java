/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.entities;

import java.sql.Time;

/**
 *
 * @author Rayhane
 */
public class Restaurateur {
    
    protected int id_resto;
    protected String nom_resto;
    protected String num_tel;
    protected Time h_ouv;
    protected Time h_fer;
    protected float budget;
    protected String login;
    protected String fax;
    
    
     public Restaurateur() {
    }

    public Restaurateur(int id_resto, String nom_resto, String num_tel, Time h_ouv, Time h_fer, float budget, String login, String fax) {
        this.id_resto = id_resto;
        this.nom_resto = nom_resto;
        this.num_tel = num_tel;
        this.h_ouv = h_ouv;
        this.h_fer = h_fer;
        this.budget = budget;
        this.login = login;
        this.fax = fax;
    }

    public int getId_resto() {
        return id_resto;
    }

    public void setId_resto(int id_resto) {
        this.id_resto = id_resto;
    }

    public String getNom_resto() {
        return nom_resto;
    }

    public void setNom_resto(String nom_resto) {
        this.nom_resto = nom_resto;
    }

    public String getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
    }

    public Time getH_ouv() {
        return h_ouv;
    }

    public void setH_ouv(Time h_ouv) {
        this.h_ouv = h_ouv;
    }

    public Time getH_fer() {
        return h_fer;
    }

    public void setH_fer(Time h_fer) {
        this.h_fer = h_fer;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
     
     
     
}
