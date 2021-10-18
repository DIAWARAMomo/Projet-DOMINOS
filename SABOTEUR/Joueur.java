import java.util.*;
public class Joueur {
    protected String pseudo;
    protected LinkedList<Carte> mesc;
    public LinkedList<Carte> devantjoueur;
    protected int score;
    public Joueur(String nom){
	this.pseudo=nom;
	mesc= new LinkedList<Carte>();
	devantjoueur=new LinkedList<Carte>();
	score=0;
    }
    public int taille(){return mesc.size();}
    public Joueur(){
	this.pseudo="inconnu";
	mesc= new LinkedList<Carte>();
	score=0;
    }
    public void setPseudo(String n){this.pseudo=n;}
    public void setMesc(LinkedList<Carte>m){mesc=m;}
    public void AfficherCarte(){
	System.out.println(this.pseudo);
	if(mesc.size()==0) {System.out.println("pas de Carte");
	    return;
	}
	Iterator i = mesc.iterator();
	while(i.hasNext()){
	    Carte x = (Carte)i.next();
	    System.out.print(x.toString()+"//");
	}
	System.out.println();
	
    }
    
    public static void main(String[]args){

    }
}
