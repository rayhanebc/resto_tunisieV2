/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rest.entities;

/**
 *
 * @author lenovo
 */
public class Commentaire {
     String label;
     int client;
     int resto;
     int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Commentaire(String label, int client, int resto, int id) {
        this.label = label;
        this.client = client;
        this.resto = resto;
        this.id = id;
    }
     
    public Commentaire() {
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public int getResto() {
        return resto;
    }

    public void setResto(int resto) {
        this.resto = resto;
    }
     
    public Commentaire(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
}
