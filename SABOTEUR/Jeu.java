import java.util.*;
public abstract class Jeu{
    protected Joueur[] joueur;
    protected EnsembleCarte ensemble;
    protected Plateau plateau;
    public Jeu(){
	joueur= new Joueur[0];
	ensemble=new EnsembleCarte();
	plateau= new Plateau();
    }

    public Jeu(EnsembleCarte e,Plateau p){
	joueur=new Joueur[3];
	ensemble=e;
	plateau=p;
    }
    public int taille(){return joueur.length;}
    public abstract void commencer();
    public abstract void partage();
}
