/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rest.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import rest.entities.Commentaire;
import rest.util.MyConnection;

/**
 *
 * @author lenovo
 */
public class CommentaireDAO implements InterfaceDAO{
    private static CommentaireDAO instance = null;

    public CommentaireDAO() {
    }

    @Override
    public void create(Object o) {
        Commentaire com = (Commentaire) o;
        String requete = "insert into commentaire values (?,?,?)";

        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, com.getLabel());
            ps.setInt(2, com.getClient());
            ps.setInt(3, com.getResto());

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
       Commentaire com = (Commentaire) o;
        String requete = "delete from commentaire where id_commentaire=?";

        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, com.getId());
            ps.executeUpdate();
            System.out.println("suppression ok");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la supp " + ex.getMessage());
        }
    }

      @Override
    public Object find(int id) {
         String requete = "select * from commentaire where id_commentaire=";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            Commentaire c = new Commentaire();
                c.setLabel(resultat.getString("contenu"));
                c.setClient(resultat.getInt("cin"));
                c.setResto(resultat.getInt("id_resto"));
                c.setResto(resultat.getInt("id_commentaire"));
             return c;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement du commentaire " + ex.getMessage());
            return null;
        }
    }




    @Override
    public List<Object> displayAll() {
         List<Object> listecom = new ArrayList<Object>();

        String requete = "select * from commentaire";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Commentaire c = new Commentaire();
                c.setLabel(resultat.getString("contenu"));
                c.setClient(resultat.getInt("cin"));
                c.setResto(resultat.getInt("id_resto"));
                c.setId(resultat.getInt("id_commentaire"));
                listecom.add(c);

            }
            return listecom;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des commentaires " + ex.getMessage());
            return null;
        }
    }
    
    
       public static CommentaireDAO getInstance() {
        if (instance == null) {
            instance = new CommentaireDAO();
            return instance;
        } else {
            return instance;
        }
    }
}
