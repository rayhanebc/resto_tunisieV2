/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import rest.entities.User;
import rest.util.MyConnection;

/**
 *
 * @author acer
 */
public class UserDAO implements InterfaceDAO {

    private static UserDAO instance = null;
    
    private UserDAO(){
        
    }

    @Override
    public void create(Object o) {
        User user = (User) o;
        String requete = "insert into utilisateur values (?,?)";

        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getMdp());


            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
        }
    }

    @Override
    public void update(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object o) {
      User user = (User)o;
       String req = " delete from utilisateur where login=?";
       PreparedStatement ps;
        try {
            ps = MyConnection.getInstance().prepareStatement(req);
            ps.setString(1,user.getLogin()); 
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

   
    public Object find(String id) {
            User user = new User();
        String req = "select * from utilisateur where login=?";
        
        try {
          PreparedStatement ps = MyConnection.getInstance().prepareStatement(req);
          ps.setString(1, id);
          ResultSet result = ps.executeQuery();
            
            while(result.next()) {
                user.setLogin(result.getString(1));
                user.setMdp(result.getString(2));              
            }
                            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return user;
    }

    @Override
    public List<Object> displayAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean authificitation(User user) {
        boolean too = false;
        String requete = "select * from utilisateur where login=? and pwd=? ";
        try {
             PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
             
             ps.setString(1, user.getLogin());
             ps.setString(2, user.getMdp());
             ResultSet resultat = ps.executeQuery();
             
             resultat.last();
             
             int count = resultat.getRow();
             if(count!=1)
                 too = false;
             else
                 too= true ;   
                 
             
        } catch (Exception e) {
            
        }

        return too;
    }

    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
            return instance;
        } else {
            return instance;
        }
    }

    @Override
    public Object find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
