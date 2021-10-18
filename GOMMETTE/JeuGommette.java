import java.util.*;
public class JeuGommette extends Jeu{
    
    public JeuGommette(){}
    public JeuGommette(Joueur j,EnsembleGommette e,PlateauGommette p){
	super(j,e,p);
	System.out.println("entrez le pseudo ");
	Scanner sc = new Scanner(System.in);
	String s= sc.nextLine();
	joueur=new Joueur(s);
    }
    public void partage(){
	super.joueur.setMesg(ensemble.distribuer());
    }
 
    public boolean terminer(){
	return(this.joueur.mesg.isEmpty());
    }
    public void commencer(){
	Joueur g=new Joueur();
	EnsembleGommette e= new EnsembleGommette();
	PlateauGommette d= new PlateauGommette();
	JeuGommette j=new JeuGommette(g,e,d);
	System.out.println("on commence le jeu");
	j.partage();
	boolean b=false;
	while(b==false){
	    if(d.taille()==0){
		j.joueur.AfficherGommette();
		System.out.println("choisissez la 1ere gommette a joueur entre "+ 0 + " et "+ (j.joueur.mesg.size()-1));
		Scanner sc= new Scanner(System.in);
		int ch=sc.nextInt();
		System.out.println(d.toString());
		if(0>ch || ch>(j.joueur.mesg.size()-1)){
		    System.out.println("choix impossible");
		    System.out.println("entrez un coup possible");
		    sc= new Scanner(System.in);
		    ch=sc.nextInt();
		}
		if(d.AjouterGommette(j.joueur.mesg.get(ch))){
			j.joueur.mesg.remove(j.joueur.mesg.get(ch));
			System.out.println(d.toString());
		    }
		
	    }
	     else{
	     	j.joueur.AfficherGommette();
		System.out.println("choisissez le prochain coup a joueur entre "+ 0 +" et " + (j.joueur.mesg.size()-1));
		Scanner sc= new Scanner(System.in);
		int ch=sc.nextInt();
		System.out.println();
		System.out.println(d.toString());
		if(0>ch || ch>(j.joueur.mesg.size()-1)){
		    System.out.println("choix impossible");
		    System.out.println("entrez un coup possible");
		    sc= new Scanner(System.in);
		    ch=sc.nextInt();
		}
		if(d.AjouterGommette(j.joueur.mesg.get(ch))){
		    System.out.println(d.toString());
	     	    j.joueur.mesg.remove(j.joueur.mesg.get(ch));
		    if(j.joueur.mesg.size()==0){
			System.out.println("Felicitations vous avez gagner");
		    }
		}
		else{
		    System.out.println("---------perdu------- ");
		    System.out.println("voulez-vous rejouer ?" +"\n"+ " si oui tapez 1 sinon tapez 2 ");
		    sc= new Scanner(System.in);
		    ch=sc.nextInt();
		    if(0>ch || ch>2){
			System.out.println("choix impossible");
			System.out.println("tapez si oui 1 sinon tapez 2");
			sc= new Scanner(System.in);
			ch=sc.nextInt();
		    }
		    if(ch==1){
			b=true;
			j.commencer();
		    }
		}
		
	     }
	    
	}
	
    }
    
    public static void main(String[]args){
	JeuGommette j=new JeuGommette();
	j.commencer();
    }
}
