import java.util.*;
public class Joueur {
    protected String pseudo;
    protected LinkedList<Domino> mesd;
    protected int score;
    public Joueur(String nom){
	this.pseudo=nom;
	mesd= new LinkedList<Domino>();
	score=0;
    }
    public int taille(){return mesd.size();}
 public Joueur(){
	this.pseudo="inconnu";
	mesd= new LinkedList<Domino>();
	score=0;
    }
    public void setPseudo(String n){this.pseudo=n;}
    public void setMesd(LinkedList<Domino>m){mesd=m;}
    public void AfficherDomino(){
	System.out.println(this.pseudo);
	if(mesd.size()==0) {System.out.println("pas de domino");
	    return;
	}
	Iterator i = mesd.iterator();
	while(i.hasNext()){
	    Domino x = (Domino)i.next();
	    System.out.print(x+"-");
	}
	System.out.println();
    }
    public int compterDomino(){
	int nb=0;
	Iterator i = mesd.iterator();
	while(i.hasNext()){
	    Domino x = (Domino)i.next();
	    nb+=x.valeur();
	}
	return nb;
    }
    public boolean contientDomino(Domino d){
	Iterator i= mesd.iterator();
	while(i.hasNext()){
	    Domino x = (Domino)i.next();
	    if(x.getM1()==d.getM1() && x.getM2()==d.getM2()) return true;
    }
	return false;
    }
    public Joueur joueurPossedePlusgrand(Joueur J){
	int x=0;
	int y=0;
	Iterator i = mesd.iterator();
	Iterator j =J.mesd.iterator();
	while(i.hasNext()){
	    Domino d = (Domino)i.next();
	    if(d.estDouble() && d.valeur()>x) x=d.valeur();
	}
	while(j.hasNext()){
	    Domino d = (Domino)j.next();
	    if(d.estDouble() && d.valeur()>y) y=d.valeur();
	}
	if(x>y) return this;
	return J;
    }
    public static void main(String[]args){
	EnsembleDomino e=new EnsembleDomino();
	e.initialisation();
	 Joueur j= new Joueur("Momo");
	 j.mesd=e.distribuer();
	// j.setPseudo("Mohamed");
	// Joueur j2=new Joueur();
	// System.out.println(j.pseudo);
	 	j.AfficherDomino();
	// 	j.mesd.add(new Domino(3,1));
	// 	j.mesd.add(new Domino(3,3));
	// 	j2.mesd.add(new Domino(3,1));
	// 	j2.mesd.add(new Domino(5,5));
	// 	Domino d1= new Domino(3,1);
	// System.out.println(j.contientDomino(d1));
	// j.compterDomino();
	// System.out.println();
	// j.AfficherDomino();
	// System.out.println(j.joueurPossedePlusgrand(j2).pseudo);
    }
	
}
