import java.util.*;
public class Joueur {
    protected String pseudo;
    protected LinkedList<Gommette> mesg;
    // protected int score;
    public Joueur(String nom){
	this.pseudo=nom;
	mesg= new LinkedList<Gommette>();
	//score=0;
    }
 public Joueur(){
	this.pseudo="inconnu";
	mesg= new LinkedList<Gommette>();
	//score=0;
    }
    public int taille(){return mesg.size();}
    public void setPseudo(String n){this.pseudo=n;}
    public void setMesg(LinkedList<Gommette>m){mesg=m;}
    public void AfficherGommette(){
	System.out.println(this.pseudo);
	if(mesg.size()==0) {System.out.println("pas de Gommette");
	    return;
	}
	Iterator i = mesg.iterator();
	while(i.hasNext()){
	    Gommette x = (Gommette)i.next();
	    System.out.println(x+"-");
	}
    }
    public boolean contientGommette(Gommette d){
		Iterator i= mesg.iterator();
	while(i.hasNext()){
	    Gommette x = (Gommette)i.next();
	    if(x.getForme()==d.getForme() && x.getCouleur()==d.getCouleur()) return true;
    }
	return false;
    }
   
    public static void main(String[]args){
	Joueur j= new Joueur("MOMO");
	Joueur t= new Joueur();
	EnsembleGommette e= new EnsembleGommette();
       j.mesg=e.distribuer();
       j.AfficherGommette();
       System.out.println(j.contientGommette(new Gommette("tringle","jaune")));
    }
}
