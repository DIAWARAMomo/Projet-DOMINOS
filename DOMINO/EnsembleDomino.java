import java.util.*;
import java.util.Collections;
import java.util.Random;
public class EnsembleDomino implements Ensemble{
    protected LinkedList<Domino> ensemble;
    protected boolean melange=false;
    public EnsembleDomino(){
	super();
	ensemble=new LinkedList<Domino>();
	melange=false;
	 initialisation();
	 melanger();
    }
    public int taille(){return ensemble.size();}
    public boolean EstVide(){ return ensemble.isEmpty();}
    public void melanger(){
		Collections.shuffle(ensemble);
		melange=true;
	}
    public LinkedList<Domino> distribuer(){
	LinkedList<Domino> part=new LinkedList<Domino>();
	for(int i=0;i<7;i++){
	    Random a= new Random();	
	    int x= a.nextInt(taille());
	    part.add(ensemble.get(x));
	    ensemble.remove(x);
	}
	return part;
    }
    public static void afficherPart(LinkedList<Domino>d1){
	for(int i=0;i<d1.size();i++){
	    System.out.print(d1.get(i));
	}
	System.out.println();
    }
    public void initialisation(){
	for(int i=0;i<7;i++){
	    for(int j=i;j<7;j++){
		ensemble.add(new Domino(i,j));
	    }
	}
    }
    public Domino piocher(){
	if(EstVide()){System.out.println("impossible de piocher"); return null;}
	Domino d=ensemble.get(taille()-1);
	ensemble.remove(taille()-1);
	return d;
    }
    public void affichage(){
	int nb=0;
	Iterator i = ensemble.iterator();
	while(i.hasNext()){
	    Domino x = (Domino)i.next();
	    nb++;
	    if(nb%7==0){
		System.out.println();
	    }
	    System.out.print(x+"-- ");
	}
    }
 public static void main(String[]args){
     EnsembleDomino e = new EnsembleDomino();
     System.out.println(e.taille());
      System.out.println(e.EstVide());
      //   e.affichage();
      LinkedList<Domino>l=e.distribuer();
      // e.affichage();
       afficherPart(l);
 }
}
