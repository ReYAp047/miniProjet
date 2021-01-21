package miniP.model;

import miniP.controler.apprenantBd;

public class Apprenant {
    private String nomPre;
    private String niveau;
    private String dateEntrer;
    private int nbSeances;
    private int numTel;
    private String  payement;
    private String nomG;

public Apprenant(String nomPre,String niveau,String dateEntrer,int nbSeances,int numTel,String  payement,String nomG){
    this.nomPre = nomPre;
    this.niveau = niveau;
    this.dateEntrer = dateEntrer;
    this.nbSeances = nbSeances;
    this.numTel = numTel;
    this.payement = payement;
    this.nomG = nomG;  
}

public Apprenant(String nomPre, String niveau, int nbSeance, int numTel, String etat, String nomG){
    this.nomPre = nomPre;
    this.niveau = niveau;
    this.nbSeances = nbSeance;
    this.numTel = numTel;
    this.payement = etat;
    this.nomG = nomG;  
    
}

public Apprenant(int tel, String nomG){
    this.numTel = tel ;
    this.nomG = nomG ;
}



public void Afficher(){
    
}

public void Modifier(int tel){
    apprenantBd.update(nomPre, niveau, nbSeances, numTel, payement, nomG, tel);
}

public void Supprimer(){
   apprenantBd.delete(numTel,nomG);
}

public void Changer_etat(){
    
}

public void Ajouter(){
    apprenantBd.insert( this.nomPre, this.niveau, this.dateEntrer, this.nbSeances, this.numTel,this.payement,this.nomG);
}

}
