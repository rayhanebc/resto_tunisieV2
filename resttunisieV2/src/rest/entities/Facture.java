/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.entities;

import java.sql.Date;

/**
 *
 * @author acer
 */
public class Facture {

    private int num_fact;
    private Date date;
    private String designation;
    private float total_prix;
    private int id_res;

    public Facture(int num_fact, Date date, String designation, float total_prix, int id_res) {
        this.num_fact = num_fact;
        this.date = date;
        this.designation = designation;
        this.total_prix = total_prix;
        this.id_res = id_res;
    }

    public Facture() {
        this.num_fact = 0;
        this.date = null;
        this.designation = null;
        this.total_prix = 0;
        this.id_res = 0;
    }

    public int getNum_fact() {
        return num_fact;
    }

    public void setNum_fact(int num_fact) {
        this.num_fact = num_fact;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public float getTotal_prix() {
        return total_prix;
    }

    public void setTotal_prix(float total_prix) {
        this.total_prix = total_prix;
    }

    public int getId_res() {
        return id_res;
    }

    public void setId_res(int id_res) {
        this.id_res = id_res;
    }
}
