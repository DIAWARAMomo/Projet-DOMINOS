import java.util.*;
public class JeuSaboteur extends Jeu{
    
    public JeuSaboteur(){}
    public JeuSaboteur(EnsembleCarte e,Plateau p){
	super(e,p);
	for(int i=0;i<3;i++){
	    Scanner sc = new Scanner(System.in);
	    System.out.println("entrez le pseudo "+ (i+1));
	    String s= sc.nextLine();
	    joueur[i]=new Joueur(s);
	}
    }
     public void partage(){
     	for(int i=0;i<taille();i++){
     	    super.joueur[i].setMesc(ensemble.distribuer());
	}
     }
    
    // public LinkedList<Carte> lesCartesJouables(Joueur jo){
    // 	LinkedList<Carte> lj= new LinkedList<Carte>();
    //  	for(Carte x:jo.mesc){
    // 	    if( x instanceof CheminMine){
    // 	 	for(int i=0;i<plateau.tableau.length;i++){
    // 	 	    for(int j=0;j<plateau.tableau[i].length;j++){
    // 			if(j+1<plateau.tableau[0].length && plateau.tableau[i][j+1]!=null && plateau.tableau[i][j+1].nord==true && x.sud==true) lj.add(x);
    // 	 		if(j-1>=0 && plateau.tableau[i][j-1]!=null && plateau.tableau[i][j-1].sud==true && x.nord==true) lj.add(x);
    // 	 		if(i+1<plateau.tableau.length && plateau.tableau[i+1][j]!=null && plateau.tableau[i][j+1].est==true && x.ouest==true) lj.add(x);
    // 	 		if(i-1>=0 && plateau.tableau[i-1][j]!=null && plateau.tableau[i-1][j].ouest==true && x.est==true) lj.add(x);
    // 	 	    }
    // 	 	}
    // 	     }
    // 	 }
    // 	    return lj;
    //  }
    // public void afficherLesJouables(LinkedList<Carte> d){
    // 	if(d.size()==0) {
    // 	    System.out.println("coup impossible");
    // 	}
    // 	else{
    // 	    for(Carte x:d) System.out.print( x + ";");
    // 	}
    // }	
    
    public boolean terminer(){
     	for(int i=0;i<joueur.length;i++){
     	    if(this.joueur[i].taille()==0) return true;
     	}
     	return false;
    }
    public Joueur gagant(){
	Joueur temp=joueur[0];
	for(int i=1;i<taille();i++){
	    if(joueur[i].score>temp.score) temp=joueur[i];
	}
	for(int i=0;i<taille();i++){
     	    if(joueur[i].score==temp.score) return joueur[i];
	}
	return null;
    }
        public void commencer(){
    // 	Scanner sc1=new Scanner(System.in);
    // 	System.out.println("choisissez le nombre de joueurs entre 2 et 4 ");
    // 	int a=sc1.nextInt();
    // 	EnsembleDomino e= new EnsembleDomino();
    // 	PlateauD t= new PlateauD();
    // 	JeuDomino j=new JeuDomino(a,e,t);
    // 	System.out.println("on commence le jeu");
    //   	j.partage();
    // 	//	j.quiCommence();
    // 	boolean b=false;
    // 	while(!j.terminer()){
    // 	    for(int i=0;i<a;i++){
    // 		if(t.taille()==0){
    // 		    j.joueur[i].AfficherDomino();
    // 		    System.out.println( j.joueur[i].pseudo +" choisissez le 1er coup a joueur entre "+ 0 + " et "+ (j.joueur[i].mesd.size()-1));
    // 	      	    Scanner sc= new Scanner(System.in);
    // 	      	    int ch=sc.nextInt();
    // 	      	    System.out.println(t.toString());
    // 	      	    if(0>ch || ch>(j.joueur[i].mesd.size()-1)){
    // 	      		System.out.println("choix impossible");
    // 	 		System.out.println("entrez un coup possible");
    // 	      		sc= new Scanner(System.in);
    // 			ch=sc.nextInt();
    // 	      	    }
    // 		    if(t.AjouterDomino(j.joueur[i].mesd.get(ch))){
    // 			j.joueur[i].mesd.remove(j.joueur[i].mesd.get(ch));
    // 			System.out.println( "Le plateau est : "+"\n" +t.toString());
    // 		    }
    // 		}
    // 	      	else{
    // 		    j.joueur[i].AfficherDomino();
    // 		    LinkedList<Domino>lj=j.lesDominosJouables(j.joueur[i]);
    // 		    if(lj.size()!=0){
    // 			System.out.println( j.joueur[i].pseudo + " choisissez le coup a joueur de votre choix entre "+ 0 +" et " + (lj.size()-1 ));
    // 			afficherLesJouables(lj);
    // 			Scanner sc= new Scanner(System.in);
    // 			System.out.println();
    // 			int ch=sc.nextInt();
    // 			//	System.out.println(t.toString());
    // 			if(0>ch || ch>(j.joueur[i].mesd.size()-1)){
    // 			    System.out.println("choix impossible");
    // 			    System.out.println("entrez un coup possible");
    // 			    sc= new Scanner(System.in);
    // 			    ch=sc.nextInt();
    // 			}
    // 			if(t.AjouterDomino(lj.get(ch))){
    // 			    j.joueur[i].mesd.remove(j.joueur[i].mesd.get(ch));
    // 			    System.out.println(  "Le plateau est : "+"\n" + t.toString());
    // 			}
    // 			if(lj.size()==0 && j.joueur[i].mesd.size()!=0){
    // 			    Domino dj=e.piocher();
    // 			    j.joueur[i].mesd.add(dj);
    // 			    System.out.println("coup impossible piocher et fait passez le tour");
    // 			    if(i!=j.taille()-1) i++;
    // 			     else{i=0;}
    // 			}
    // 		    }
    // 	 	}
    // 	    }
    // 	}
     }
    public static void main(String[]args){
	 
	
    }
}
