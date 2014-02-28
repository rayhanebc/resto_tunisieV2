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
import rest.entities.Facture;
import rest.util.MyConnection;

/**
 *
 * @author acer
 */
public class FactureDAO implements InterfaceDAO {
    
    private static FactureDAO instance = null;
    
    private FactureDAO() {
    }
    
    @Override
    public void create(Object o) {
        
        Facture facture = (Facture) o;
        String requete = "insert into facture (date_fact,designation,total_prix,id_res) values (?,?,?,?)";
        
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setDate(1, facture.getDate());
            ps.setString(2, facture.getDesignation());
            ps.setFloat(3, facture.getTotal_prix());
            ps.setInt(4, facture.getId_res());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public void update(Object o) {
        Facture facture = (Facture) o;
        String requete = "update facture set date_fact=?,designation=?,total_prix=?, where num_fact=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setDate(1, facture.getDate());
            ps.setString(2, facture.getDesignation());
            ps.setFloat(3, facture.getTotal_prix());
            ps.setInt(4, facture.getNum_fact());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public void delete(Object o) {
        Facture facture = (Facture) o;
        String requete = "delete from facture where num_fact=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, facture.getNum_fact());
            ps.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        
    }
    
    @Override
    public Object find(int id) {
        Facture facture = new Facture();
        String requete = "select * from facture where num_fact=?";
        
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                facture.setNum_fact(resultat.getInt(1));
                facture.setDate(resultat.getDate(2));
                facture.setDesignation(resultat.getString(3));
                facture.setTotal_prix(resultat.getFloat(4));
                facture.setId_res(resultat.getInt(5));
            }
            return facture;
            
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    @Override
    public List<Object> displayAll() {
        List<Object> facture = new ArrayList<>();
        String requete = "select * from depot";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            
            while (resultat.next()) {
                Facture fac = new Facture();
                
                fac.setNum_fact(resultat.getInt(0));
                fac.setDate(resultat.getDate(1));
                fac.setDesignation(resultat.getString(2));
                fac.setTotal_prix(resultat.getFloat(4));
                fac.setId_res(resultat.getInt(5));
                facture.add(fac);
            }
            return facture;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public static FactureDAO getInstance() {
        if (instance == null) {
            instance = new FactureDAO();
            return instance;
        } else {
            return instance;
        }
    }
}
