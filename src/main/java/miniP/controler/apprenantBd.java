/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniP.controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import miniP.view.group;

/**
 *
 * @author mefta
 */
public class apprenantBd {
    
    public static void insert(String nomPre,String niveau,String dateEnter,int nbSeances,int numTel ,String payement, String nomG){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/cour_du_soir?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String username = "root";
            String password = "";
            Connection con1 = DriverManager.getConnection(url, username, password);

            PreparedStatement insert = con1.prepareStatement("insert into etudiants(nomPre,niveau,dateEnter,nbSeances,numTel ,payement, nomG)values(?,?,?,?,?,?,?)");
            insert.setString(1, nomPre);
            insert.setString(2, niveau);
            insert.setString(3, dateEnter);
            insert.setInt(4, nbSeances);
            insert.setInt(5, numTel);
            insert.setString(6, payement);
            insert.setString(7, nomG);
            insert.executeUpdate();
            
            //update le nombres d'apprenant du group
            PreparedStatement update = con1.prepareStatement("update groups set nombre=nombre+? where nomGroup=?");
            update.setInt(1, 1);
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
    



public static void delete(int tel,String nomG){
    try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/cour_du_soir?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String username = "root";
            String password = "";
        Connection con1 = DriverManager.getConnection(url, username, password);
        

        PreparedStatement delete = con1.prepareStatement("Delete from etudiants where numTel =?");
            delete.setInt(1, tel);
            delete.executeUpdate(); 
            
            //update le nombres d'apprenant du group
            PreparedStatement update = con1.prepareStatement("update groups set nombre=nombre-? where nomGroup=?");
            update.setInt(1, 1);
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

public static void update(String nomPre, String niveau, int nbSeances, int numTel , String payement, String nomG , int tel){
    try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/cour_du_soir?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String username = "root";
            String password = "";
        Connection con1 = DriverManager.getConnection(url, username, password);
                                                                    
        PreparedStatement update = con1.prepareStatement("update etudiants set nomPre =? ,niveau =? ,nbSeances =? ,numTel =?,payement=? ,nomG =? where numTel=?");
            update.setString(1, nomPre);
            update.setString(2, niveau);
            update.setInt(3, nbSeances);
            update.setInt(4, numTel);
            update.setString(5, payement);
            update.setString(6, nomG);
            update.setInt(7, tel);
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


