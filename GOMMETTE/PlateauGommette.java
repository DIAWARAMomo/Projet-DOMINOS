import java.util.*;
public class PlateauGommette implements Plateau{
protected LinkedList<Gommette> plateau;
    protected String casesGauche;
    protected String casesDroite;
    
	public PlateauGommette(){
	    this.plateau=new LinkedList<Gommette>();
	    casesDroite="";
	    casesGauche="";
	}
    public void AjouterGommette(Gommette g, int index){
	if(plateau.isEmpty())index=0;
	this.plateau.add(index,g);
	    casesDroite=plateau.getLast().getCouleur();
	    casesGauche=plateau.getFirst().getForme();
	
    }
     public boolean possibilityG(Gommette d1){
    	return (d1.getForme()==casesGauche ||d1.getCouleur()==casesGauche);
     }
      public boolean possibilityD(Gommette d1){
      	return (d1.getForme()==casesDroite || d1.getCouleur()==casesDroite );
      }
    public boolean possibilityGD(Gommette d1){
     	return(possibilityG(d1) && possibilityD(d1));
     }
    public void AjouterDroite(Gommette d1){

	if(possibilityD(d1)){
	    if(d1.getForme()==this.casesDroite){
	 	AjouterGommette(d1,this.taille());
		return;
	    }
	    else{
	 	d1.changerCoté();
	 	AjouterGommette(d1,this.taille());
		return;
	    }
	}
    }
    public void AjouterGauche(Gommette d1){
	if(possibilityG(d1)){
	    if(d1.getCouleur()==this.casesGauche){
		AjouterGommette(d1,0);
		return;
	    }
	    else{
		d1.changerCoté();
		AjouterGommette(d1,0);
		return;
	    }
	}
	
	
    }
     public boolean EstVide(){return plateau.isEmpty();}
     public int taille(){return plateau.size();}
     public String toString(){
     	String s="";
     	Iterator i = plateau.iterator();
     	while(i.hasNext()){
     	    Gommette x = (Gommette)i.next();
     	    s+=x.toString();
     	}
     	return s;
     }

      public boolean AjouterGommette(Gommette d1){
	  if(EstVide()) {
	      AjouterGommette(d1,0);
	      return true;
	  }
	  if (possibilityGD(d1)){
	      Scanner sc = new Scanner(System.in);
	      System.out.println("voulez-vous à 'Gauche' ou à 'Droite'");
	      String choix=sc.nextLine();
	      if(choix=="Gauche") {
		  AjouterGauche(d1);
		  return true;
	      }
	      else{
		  AjouterDroite(d1);
		  return true;
	      }
	      // System.out.println("coup impossible");
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
		// PlateauGommette p= new PlateauGommette();
	// Gommette g= new Gommette("carré","blanc");
	// p.AjouterGommette(g,6);
	// System.out.println(p.taille());
	// p.AjouterGommette( new Gommette("carré","jaune"));
	// System.out.println(p.toString());

    }
    
}
    

