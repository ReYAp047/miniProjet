package miniP.model;

import miniP.controler.courBd;

public class Cours {
private String nomCour;    
private String niveau;
private String fichier;
private String loginP;

public Cours(String nomCour,String niveau,String fichier, String loginP){
    this.nomCour = nomCour;
    this.niveau = niveau;
    this.fichier = fichier;
    this.loginP = loginP;
}

public Cours(String nomCour){
    this.nomCour = nomCour;
}

public void Afficher(){
    
}

public void Modifier(String nomm){
  courBd.update(nomCour, niveau, fichier, loginP, nomm);
}

public void Supprimer(){
    courBd.delete(nomCour);
}

public void Ajouter(){
  courBd.insert(nomCour, niveau, fichier, loginP);
}

}
