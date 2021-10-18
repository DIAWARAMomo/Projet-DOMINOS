import java.util.*;
public abstract class Jeu{
    protected Joueur[] joueur;
    protected EnsembleDomino ensemble;
    protected PlateauD plateau;
    public Jeu(){
	joueur= new Joueur[0];
	ensemble=new EnsembleDomino();
	plateau= new PlateauD();
    }

    public Jeu(int n,EnsembleDomino e,PlateauD p) /*throws NombreDeJoueurException*/ {
	/*if(n<=1 || n>4) throw new NombreDeJoueurException(n);*/
	 if(n<=1 || n>4){
	     n=2;
	     throw new IllegalArgumentException(" les regles du jeux ne sont pas respecter");
	    
	 }
		else{
	joueur=new Joueur[n];
	ensemble=e;
	plateau=p;
		}

    }
    public int taille(){return joueur.length;}

    public abstract void commencer();
    public abstract void partage();
     public abstract void quiCommence();
}
