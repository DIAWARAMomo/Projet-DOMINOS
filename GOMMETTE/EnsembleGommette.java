import java.util.*;
import java.util.Collections;
public class EnsembleGommette implements Ensemble{
protected LinkedList<Gommette> ensemble;
    protected boolean melange=false;
    public EnsembleGommette(){
	super();
	ensemble=new LinkedList<Gommette>();
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
 public LinkedList<Gommette> distribuer(){
	LinkedList<Gommette> part=new LinkedList<Gommette>();
	for(int i=0;i<15;i++){
	    Random a= new Random();	
	    int x= a.nextInt(taille());
	    part.add(ensemble.get(x));
	    ensemble.remove(x);
	}
	return part;
    }
    
    public void initialisation(){
	String a="";
	String b="";
	for(int i=0;i<7;i++){
	    if(i==0)a="carré";
	    if(i==1)a="cercle";
	    if(i==2)a="triangle";
	    if(i==3)a="trapèse";
	    if(i==4)a="losange";
	    if(i==5)a="piramide";
	    if(i==6)a="cone";
	    for(int j=i;j<7;j++){
		if(j==0)b="blanc";
		if(j==1)b="rouge";
		if(j==2)b="jaune";
		if(j==3)b="maron";
		if(j==4)b="vert";
		if(j==5)b="violet";
		if(j==6)b="orange";
		ensemble.add(new Gommette(a,b));
	    }
	}
    }
    

     public Gommette piocher(){
     	if(EstVide()){System.out.println("impossible de piocher"); return null;}
     	Gommette d=ensemble.get(taille()-1);
     	ensemble.remove(taille()-1);
     	return d;
     }
    public void affichage(){
	int nb=0;
	Iterator i = ensemble.iterator();
	while(i.hasNext()){
	    Gommette x = (Gommette)i.next();
	    nb++;
	    if(nb%7==0){
		System.out.println();
	    }
	    System.out.print(x+" // ");
	}
    }
    public static void main(String[]args){
	EnsembleGommette e= new EnsembleGommette();
	e.affichage();
    }

}
