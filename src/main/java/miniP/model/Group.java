/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniP.model;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import miniP.controler.groupBd;
import miniP.view.group;

/**
 *
 * @author mefta
 */
public class Group {
    private String nomGroup;    
private int nombre;
private String niveau;
private int nbSeances;
private String seanceProch;
private String heur;
private String loginP;

public Group(String nomGroup,int nombre,String niveau, int nbSeances, String seanceProch, String heur, String loginP){
    this.nomGroup = nomGroup;
    this.nombre = nombre;
    this.niveau = niveau;
    this.nbSeances = nbSeances;
    this.seanceProch = seanceProch;
    this.heur = heur;
    this.loginP = loginP;
    
}
public Group(String nom){
    this.nomGroup=nom;
}

    public Group(String nomGroup, String niveau, String seanceProch, String heur, String loginP) {
       this.nomGroup =  nomGroup;
       this.niveau = niveau;
       this.seanceProch = seanceProch;
       this.heur = heur;
       this.loginP = loginP;
    }
    
    public Group(int nombre, String nomG) {
       this.nombre = nombre;
       this.nomGroup = nomG;
    }

public void Modifier(String nomm){
    groupBd.update(nomGroup, niveau, seanceProch, heur, loginP, nomm);
}

public void Supprimer(){
    groupBd.delete(nomGroup);
}

public void nbSeances(int nombreSeances){
    groupBd.updateSeance(nombre, nomGroup,nombreSeances);
}

public void Ajouter(){
   boolean b=groupBd.insert(nomGroup,nombre,niveau,nbSeances,seanceProch,heur,loginP);

}

}
