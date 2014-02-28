/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.entities;

/**
 *
 * @author acer
 */
public class User {

    protected  String login;
    protected String mdp;

    public User() {
        this.login = null;
        this.mdp = null;
    }

    
    public User(String login, String mdp) {
        this.login = login;
        this.mdp = mdp;
    }
   
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
}
