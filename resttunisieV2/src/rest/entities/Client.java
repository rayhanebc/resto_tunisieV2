/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.entities;

/**
 *
 * @author acer
 */
public class Client extends User {

    private int cin;
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private String mail;

    public Client(int cin, String nom, String prenom, String adresse, String telephone, String mail, String login, String mdp) {
        super(login, mdp);
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.mail = mail;
    }
    public Client()
    {
    
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    
    
}
