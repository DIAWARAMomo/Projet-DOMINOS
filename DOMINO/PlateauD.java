import java .util.*;
import java.util.LinkedList;

public class PlateauD implements Plateau{
    
    protected LinkedList<Domino> d;
    protected int casesGauche,casesDroite;

    public PlateauD(){
	d=new LinkedList<Domino>();
	casesGauche=0;
	casesDroite=0;
    }
    public boolean EstVide(){return d.isEmpty();}
    public int taille(){return d.size();}
    public String toString(){
	String s="";
	Iterator i = d.iterator();
	while(i.hasNext()){
	    Domino x = (Domino)i.next();
	    s+=x.toString();
	}
	return s;
    }
    public void AjouterDomino(Domino d1,int a){
	d.add(a,d1);
	casesGauche=d.get(0).getM1();
	casesDroite= d.get(d.size()-1).getM2();
    }
    public boolean possibilityG(Domino d1){
	return (d1.getM2()==casesGauche || d1.getM1()==casesGauche);
    }
     public boolean possibilityD(Domino d1){
	return (d1.getM1()==this.casesDroite || d1.getM2()==this.casesDroite );
    }
    public boolean possibilityGD(Domino d1){
	return(possibilityG(d1) && possibilityD(d1));
    }
    public void AjouterGauche(Domino d1){
       
	if(possibilityG(d1)){
	    if(d1.getM2()==this.casesGauche){
		AjouterDomino(d1,0);
		return;
	    }
	    else{
		d1.changerCoté();
		AjouterDomino(d1,0);
		return;
	    }
	}
	
	
    }
    public void AjouterDroite(Domino d1){
	if(possibilityD(d1)){
	    if(d1.getM1()==this.casesDroite){
	 	AjouterDomino(d1,this.taille());
		return;
	    }
	    else{
	 	d1.changerCoté();
	 	AjouterDomino(d1,this.taille());
		return;
	    }
	}
    }

    public boolean AjouterDomino(Domino d1){
	if(EstVide()){
	    AjouterDomino(d1,0);
	    return true;
	}
	if (possibilityGD(d1)){
	     Scanner sc = new Scanner(System.in);
	     System.out.println("voulez-vous à 'Gauche' ou à 'Droite'");
	     String choix=sc.nextLine();
	     if(choix.equals("Gauche")) {
		 AjouterGauche(d1);
		 return true;
	     }
		else{
		    AjouterDroite(d1);
		    return true;
		}
	}
	if(possibilityD(d1)){
	    AjouterDroite(d1);
	    return true;
	}
	if(possibilityG(d1)){
	    AjouterGauche(d1);
	    return true;
	}
	return false;
    }
    public static void main(String[]args){
	PlateauD d= new PlateauD();
	//	System.out.println(d.EstVide());
	d.AjouterDomino( new Domino(0,1));
	System.out.println(d.taille());
	d.AjouterDomino( new Domino(3,1));
	d.AjouterDomino( new Domino(0,3));
	System.out.println(d.toString());
	
    }
}
	    
	    
	    




