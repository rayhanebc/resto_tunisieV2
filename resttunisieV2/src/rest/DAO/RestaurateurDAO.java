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
import rest.entities.Restaurateur;
import rest.util.MyConnection;

/**
 *
 * @author Rayhane
 */
public class RestaurateurDAO implements InterfaceDAO {

    private static RestaurateurDAO instance = null;

    public RestaurateurDAO() {
    }

    @Override
    public void create(Object o) {
        Restaurateur resto = (Restaurateur) o;
        String requete = "insert into restaurateur (nom_restaurant,telephone,h_ouverture,h_fermeture,budget,login,fax) values (?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(2, resto.getNom_resto());
            ps.setString(3, resto.getNum_tel());
            ps.setTime(4, resto.getH_ouv());
            ps.setTime(5, resto.getH_fer());
            ps.setFloat(6, resto.getBudget());
            ps.setString(7, resto.getLogin());
            ps.setString(7, resto.getFax());

            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
        }
    }

    @Override
    public void update(Object o) {
    }

    @Override
    public void delete(Object o) {
        Restaurateur restaurateur = (Restaurateur) o;
        String requete = "delete from restaurateur where id_resto=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, restaurateur.getId_resto());
            ps.executeUpdate();
            System.out.println("restaurant supprimée");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    @Override
    public Object find(int id) {
        Restaurateur restaurateur = new Restaurateur();
        String requete = "select * from  restaurateur where id_resto=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                restaurateur.setId_resto(resultat.getInt(1));
                restaurateur.setNom_resto(resultat.getString(2));
                restaurateur.setNum_tel(resultat.getString(3));
                restaurateur.setH_ouv(resultat.getTime(4));
                restaurateur.setH_fer(resultat.getTime(5));
                restaurateur.setBudget(resultat.getFloat(6));
                restaurateur.setLogin(resultat.getString(7));
                restaurateur.setFax(resultat.getString(8));
            }

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        return restaurateur;
    }

    @Override
    public List<Object> displayAll() {

        List<Object> lstresto = new ArrayList<>();
        String requete = "select * from restaurateur ";
        try {
            Statement statement = MyConnection.getInstance()
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Restaurateur r = new Restaurateur();
                r.setId_resto(resultat.getInt(1));
                r.setNom_resto(resultat.getString(2));
                r.setNum_tel(resultat.getString(3));
                r.setH_ouv(resultat.getTime(4));
                r.setH_fer(resultat.getTime(5));
                r.setBudget(resultat.getFloat(6));
                r.setLogin(resultat.getString(7));
                r.setFax(resultat.getString(8));
                lstresto.add(r);

            }
            return lstresto;


        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }


    }

    public static RestaurateurDAO getInstance() {
        if (instance == null) {
            instance = new RestaurateurDAO();
            return instance;
        } else {
            return instance;
        }
    }
}
