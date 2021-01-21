/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniP.controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import miniP.view.group;

/**
 *
 * @author mefta
 */
public class groupBd {
    
    public static boolean insert(String nomGroup,int nombre,String niveau,int nbSeances,String seancesProch,String heur,String loginP){
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");   

            String url = "jdbc:mysql://localhost:3306/cour_du_soir?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; 
            String username = "root";
            String password = "";
             Connection con1 = DriverManager.getConnection(url, username, password);
           
             PreparedStatement insert = con1.prepareStatement("insert into groups(nomGroup,nombre,niveau,nbSeances,seancesProch,heur)values(?,?,?,?,?,?)");
            insert.setString(1, nomGroup);
            insert.setInt(2, nombre);
            insert.setString(3, niveau);
            insert.setInt(4, nbSeances);
            insert.setString(5, seancesProch);
            insert.setString(6, heur);
            insert.executeUpdate();      
            return true;
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(group.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
            Logger.getLogger(group.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false; 
    }
    

     public static void delete(String nomm){
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");   

            String url = "jdbc:mysql://localhost:3306/cour_du_soir?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; 
            String username = "root";
            String password = "";
             Connection con1 = DriverManager.getConnection(url, username, password);
           
            PreparedStatement delete = con1.prepareStatement("Delete from groups where nomGroup=?");
            delete.setString(1, nomm);
           
            delete.executeUpdate();
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(group.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
            Logger.getLogger(group.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
      public static void update(String nomGroup,String niveau,String seancesProch,String heur,String loginP,String nomm){
          try {
            Class.forName("com.mysql.cj.jdbc.Driver");   

            String url = "jdbc:mysql://localhost:3306/cour_du_soir?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; 
            String username = "root";
            String password = "";
            Connection con1 = DriverManager.getConnection(url, username, password);
           
            PreparedStatement update = con1.prepareStatement("update groups set nomGroup =? ,niveau =? ,seancesProch =? ,heur =? where nomGroup=?");
            update.setString(1, nomGroup);
            update.setString(2, niveau);
            update.setString(3, seancesProch);
            update.setString(4, heur);
            update.setString(5, nomm);
            update.executeUpdate();    
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(group.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
            Logger.getLogger(group.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      
      
      public static void updateSeance(int nombre, String nomG, int nombreSeances){
          try {
            Class.forName("com.mysql.cj.jdbc.Driver");   

            String url = "jdbc:mysql://localhost:3306/cour_du_soir?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; 
            String username = "root";
            String password = "";
            Connection con1 = DriverManager.getConnection(url, username, password);
            
            //gérer le nombre des séances des apprenants
            
           
            int nb = nombreSeances;
              System.out.println(nb);
            if(nb>nombre)//il va diminumé
            {
                nb-= nombre; 
                PreparedStatement updateE = con1.prepareStatement("update etudiants set nbSeances=nbSeances-? where nomG=?");
                updateE.setInt(1, nb);
                updateE.setString(2, nomG);
                updateE.executeUpdate();
            }
            else
            {
                nb= nombre-nb; 
                PreparedStatement updateE = con1.prepareStatement("update etudiants set nbSeances=nbSeances+? where nomG=?");
                updateE.setInt(1, nb);
                updateE.setString(2, nomG);
                updateE.executeUpdate();
            }
            
            PreparedStatement update = con1.prepareStatement("update groups set nbSeances=? where nomGroup=?");
            update.setInt(1, nombre);
            update.setString(2, nomG);
            update.executeUpdate();    
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(group.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
            Logger.getLogger(group.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
     
}
