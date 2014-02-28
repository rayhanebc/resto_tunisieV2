/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import rest.entities.Client;
import rest.util.MyConnection;

/**
 *
 * @author acer
 */
public class ClientDAO implements InterfaceDAO {

    private static ClientDAO instance = null;

    private ClientDAO() {
    }

    @Override
    public void create(Object o) {
        Client client = (Client) o;
        String requete = "insert into client values (?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, client.getCin());
            ps.setString(2, client.getNom());
            ps.setString(3, client.getPrenom());
            ps.setString(4, client.getTelephone());
            ps.setString(5, client.getMail());
            ps.setString(6, client.getAdresse());
            ps.setString(7, client.getLogin());

            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
        }
    }

    @Override
    public void update(Object o) {
        Client client = (Client) o;
        String req = "update client set nom=?, prenom=? ,tel=? ,email=? ,adresse=? where cin=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(req);
            ps.setString(1, client.getNom());
            ps.setString(2, client.getPrenom());
            ps.setString(3, client.getTelephone());
            ps.setString(4, client.getMail());
            ps.setString(5, client.getAdresse());
            ps.setInt(6, client.getCin());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete(Object o) {
        Client client = (Client) o;
        String req = " delete from client where cin=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(req);
            ps.setInt(1, client.getCin());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Object find(int id) {

        Client client = new Client();
        String req = "select * from client where cin=?";

        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                client.setCin(result.getInt(1));
                client.setNom(result.getString(2));
                client.setPrenom(result.getString(3));
                client.setTelephone(result.getString(4));
                client.setMail(result.getString(5));
                client.setAdresse(result.getString(6));
                client.setLogin(result.getString(7));

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return client;

    }

    @Override
    public List<Object> displayAll() {
        List<Object> listeClients = new ArrayList<Object>();

        String req = "select * from client";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(req);

            while (resultat.next()) {

                Client client = new Client();
                client.setCin(resultat.getInt(1));
                client.setNom(resultat.getString(2));
                client.setPrenom(resultat.getString(3));
                client.setTelephone(resultat.getString(4));
                client.setMail(resultat.getString(5));
                client.setAdresse(resultat.getString(6));
                client.setLogin(resultat.getString(7));

                listeClients.add(client);
            }
            return listeClients;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return null;
        }

    }

    public static ClientDAO getInstance() {
        if (instance == null) {
            instance = new ClientDAO();
            return instance;
        } else {
            return instance;
        }
    }
}
