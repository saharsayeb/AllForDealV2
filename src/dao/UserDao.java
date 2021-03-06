/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entite.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author maroo
 */
public class UserDao implements Idao.IDao<User>{
    private Connection connection;
    private PreparedStatement pst;
    
     public UserDao() {
        //initialiser la connection
        connection = DataSource.getInstance().getConnection();
     }
    @Override
    public void add(User t) {
        String req = "insert into fos_user_user(username, username_canonical, email, email_canonical, enabled, password, gender, phone, firstname, lastname, roles, created_at)"
               +"values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(req);

            pst.setString(1, t.getUsername());
            pst.setString(2, t.getUsernameCanonical());
            pst.setString(3, t.getEmail());
            pst.setString(4, t.getEmailCanonical());
             pst.setInt(5, t.getEnabled());
            pst.setString(6, t.getPassword());
         
            pst.setString(7, t.getGender());
            pst.setInt(8, t.getPhone());
            pst.setString(9, t.getFirstname());
            pst.setString(10, t.getLastname());
            pst.setString(11, t.getRoles());
            pst.setDate(12, (Date) t.getCreated_at());
            
           
           
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(User t) {
        String req = "update fos_user_user set username=? , username_canonical=?, email=? , email_canonical=? , enabled= ?, password=? , gender=? , phone=?, firstname=?, lastname=? , roles=? , updated_at=? where id=?";
        try {

            pst = connection.prepareStatement(req);

           
            pst.setString(1, t.getUsername());
            pst.setString(2, t.getUsernameCanonical());
            pst.setString(3, t.getEmail());
            pst.setString(4, t.getEmailCanonical());
             pst.setInt(5, t.getEnabled());
            pst.setString(6, t.getPassword());
         
            pst.setString(7, t.getGender());
            pst.setInt(8, t.getPhone());
            pst.setString(9, t.getFirstname());
            pst.setString(10, t.getLastname());
            pst.setString(11, t.getRoles());
            pst.setDate(12, (Date) t.getUpdated_at());
            pst.setInt(13, t.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removeById(int id) {
 String requete = "delete from fos_user_user where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Personne supprimé");
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<User> findAll() {
        List<User> listeUser = new ArrayList<>();
        String req = "select id ,username , email, created_at from fos_user_user ";
        try {
            pst = connection.prepareStatement(req);
            ResultSet resultat = pst.executeQuery(req);
            User p = new User();
            while (resultat.next()) {

                p.setId(resultat.getInt(1));
                p.setUsername(resultat.getString(2));
                p.setEmail(resultat.getString(3));
                p.setCreated_at(resultat.getDate(4));
                listeUser.add(p);
            }
            return listeUser;
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }         
    }

    @Override
    public User findById(int id) {
        User p = new User();
        String requete = "select id ,username , email, created_at from Personne where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                p.setId(resultat.getInt(1));
                p.setUsername(resultat.getString(2));
                p.setEmail(resultat.getString(3));
                 p.setCreated_at(resultat.getDate(4));
            }
            return p;

        } catch (SQLException ex) {
             Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
//    public List<User> findByLogin( String Login, String mdp ){
//        String req="select username , password from fos_user_user";
//       // List<User>
//    }

   
    
}
