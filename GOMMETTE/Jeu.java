import java.util.*;
public abstract class Jeu{
    protected Joueur joueur;
    protected EnsembleGommette ensemble;
    protected PlateauGommette plateau;

    public Jeu(Joueur j,EnsembleGommette e,PlateauGommette p){

	joueur=j;
	ensemble=e;
	plateau=p;

    }
     public Jeu(){
	 joueur=new Joueur();
	 ensemble= new EnsembleGommette();
		plateau=new PlateauGommette();

    }
   

    public abstract void commencer();
    // //public abstract void botAction(int i);
     public abstract void partage();
}
