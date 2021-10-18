import java.util.*;
import java.util.Collections;
import java.lang.Enum;
import java.util.Random;
public class EnsembleCarte{
    protected LinkedList<Carte> ensemble;
    public EnsembleCarte(){
	ensemble=new LinkedList<Carte>();
	initialisation();
    }
    public int taille(){return ensemble.size();}
    public boolean EstVide(){ return ensemble.isEmpty();}
    public void initialisation(){
	for(int i=0;i<40;i++){
	     CheminMine c= new CheminMine("Path");
	     ensemble.add(c);
	 }
	 String[]t={"lampecasser","lampeReparer","piochecasser","piochereparer","wagonnercaser", "wagonnereparer","lampecasser","lampeReparer","piochecasser","piochereparer","wagonnercaser","wagonreparer"};
	 for(int i=0;i<t.length;i++){
	     CarteSpeciale c=new CarteSpeciale(t[i]);
	     ensemble.add(c);
	 }
      }
     public LinkedList<Carte> distribuer(){
	LinkedList<Carte> part=new LinkedList<Carte>();
	for(int i=0;i<7;i++){
	    Random a= new Random();	
	    int x= a.nextInt(taille());
	    part.add(ensemble.get(x));
	    ensemble.remove(x);
	}
	return part;
     }
    public Carte piocher(){
	if(EstVide()){System.out.println("impossible de piocher"); return null;}
	Carte d=ensemble.get(taille()-1);
	ensemble.remove(taille()-1);
	return d;
    }
    public static void afficherPart(LinkedList<Carte>d1){
	for(int i=0;i<d1.size();i++){
	    System.out.print("(carte " + (i+1) +")" + d1.get(i).toString() + "//");
	}
	System.out.println();
    }

     public static void main(String[]args){
     EnsembleCarte e = new EnsembleCarte();
     System.out.println(e.taille());
      System.out.println(e.EstVide());
      LinkedList<Carte>l=e.distribuer();
      l.add(e.piocher());
      // e.affichage();
       afficherPart(l);
 }
}
