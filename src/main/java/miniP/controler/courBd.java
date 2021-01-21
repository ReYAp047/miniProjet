package miniP.controler;

import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import miniP.view.Cour;
import miniP.view.group;

public class courBd {
    
    public static void insert(String nomCour, String niveau, String fichier, String idP){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/cour_du_soir?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String username = "root";
            String password = "";
            Connection con1 = DriverManager.getConnection(url, username, password);

            PreparedStatement insert = con1.prepareStatement("insert into cours(nomCour,niveau,fichier,idP)values(?,?,?,?)");
            insert.setString(1, nomCour);
            insert.setString(2, niveau);
            insert.setString(3, fichier);
            insert.setInt(4, 1);
            insert.executeUpdate();
    
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(group.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
            Logger.getLogger(group.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public static void update(String nomCour, String niveau, String fichier, String idP, String nomm){
   try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/cour_du_soir?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String username = "root";
            String password = "";
       Connection con1 = DriverManager.getConnection(url, username, password);

       PreparedStatement update = con1.prepareStatement("update cours set nomCour =? ,niveau =? ,fichier =? ,idP =? where nomCour=?");
            update.setString(1, nomCour);
            update.setString(2, niveau);
            update.setString(3, fichier);
            update.setInt(4, 1);
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
    
    public static void delete(String nomCour){
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                String url = "jdbc:mysql://localhost:3306/cour_du_soir?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
                String username = "root";
                String password = "";
                Connection con1 = DriverManager.getConnection(url, username, password);

            PreparedStatement delete = con1.prepareStatement("Delete from cours where nomCour=?"); 
                delete.setString(1, nomCour);
                delete.executeUpdate();

                

            }
            catch (ClassNotFoundException ex) {
                Logger.getLogger(group.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (SQLException ex) {
                Logger.getLogger(group.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
            
}
