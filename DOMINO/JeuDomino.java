import java.util.*;
public class JeuDomino extends Jeu{
    
    public JeuDomino(){}
    public JeuDomino(int n,EnsembleDomino e,PlateauD p){
	super(n,e,p);
	for(int i=0;i<n;i++){
	    Scanner sc = new Scanner(System.in);
	    System.out.println("entrez le pseudo "+ (i+1));
	    String s= sc.nextLine();
	    joueur[i]=new Joueur(s);
	}
    }
    public void partage(){
	for(int i=0;i<taille();i++){
	    super.joueur[i].setMesd(ensemble.distribuer());
       	}
    }
    public void echanger(Joueur j1,Joueur j2){
     	Joueur temp=j1;
     	j1=j2;
     	j2=temp;
    }

    public void quiCommence(){
	Joueur temp= new Joueur();
	System.out.println("Le joueur ayant le plus grand double commence");
	for(int i=0;i<taille()-1;i++){
	    temp=(this.joueur[i].joueurPossedePlusgrand(joueur[i+1]));
	    
	}
	for(int j=0;j<taille();j++){
	    if(this.joueur[j]==temp)echanger(joueur[0],joueur[j]);
	    //	System.out.println(temp.pseudo);
	}
    }
    
    public LinkedList<Domino> lesDominosJouables(Joueur j){
	LinkedList<Domino> lj= new LinkedList<Domino>();
	for(Domino x:j.mesd){
	    if(((PlateauD)plateau).possibilityG(x) || ((PlateauD)plateau).possibilityD(x) || ((PlateauD)plateau).possibilityGD(x)){
		lj.add(x);
	    }
	}
	return lj;
    }
    public void afficherLesJouables(LinkedList<Domino> d){
	if(d.size()==0) {
	    System.out.println("coup impossible");
	}
	else{
	    for(Domino x:d) System.out.print( x + ";");
	}
    }	
    // public boolean terminer(){
    // 	for(int i=0;i<taille();i++){
    // 	    if(this.joueur[i].score==10) return true;
    // 	}
    // 	return false;
    // }
    public boolean terminer(){
	for(int i=0;i<joueur.length;i++){
	    if(this.joueur[i].taille()==0) return true;
	}
	return false;
    }
    public Joueur gagant(){
	for(int i=0;i<taille();i++){
	    if(joueur[i].score>=10) return joueur[i];
	}
	return null;
    }
    public void commencer(){
	Scanner sc1=new Scanner(System.in);
	System.out.println("choisissez le nombre de joueurs entre 2 et 4 ");
	int a=sc1.nextInt();
	EnsembleDomino e= new EnsembleDomino();
	PlateauD t= new PlateauD();
	JeuDomino j=new JeuDomino(a,e,t);
	System.out.println("on commence le jeu");
      	j.partage();
	//	j.quiCommence();
	boolean b=false;
	while(!j.terminer()){
	    for(int i=0;i<a;i++){
		if(t.taille()==0){
		    j.joueur[i].AfficherDomino();
		    System.out.println( j.joueur[i].pseudo +" choisissez le 1er coup a joueur entre "+ 0 + " et "+ (j.joueur[i].mesd.size()-1));
	      	    Scanner sc= new Scanner(System.in);
	      	    int ch=sc.nextInt();
	      	    System.out.println(t.toString());
	      	    if(0>ch || ch>(j.joueur[i].mesd.size()-1)){
	      		System.out.println("choix impossible");
	 		System.out.println("entrez un coup possible");
	      		sc= new Scanner(System.in);
			ch=sc.nextInt();
	      	    }
		    if(t.AjouterDomino(j.joueur[i].mesd.get(ch))){
			j.joueur[i].mesd.remove(j.joueur[i].mesd.get(ch));
			System.out.println( "Le plateau est : "+"\n" +t.toString());
		    }
		}
	      	else{
		    j.joueur[i].AfficherDomino();
		    LinkedList<Domino>lj=j.lesDominosJouables(j.joueur[i]);
		    if(lj.size()!=0){
			System.out.println( j.joueur[i].pseudo + " choisissez le coup a joueur de votre choix entre "+ 0 +" et " + (lj.size()-1 ));
			afficherLesJouables(lj);
			Scanner sc= new Scanner(System.in);
			System.out.println();
			int ch=sc.nextInt();
			//	System.out.println(t.toString());
			if(0>ch || ch>(j.joueur[i].mesd.size()-1)){
			    System.out.println("choix impossible");
			    System.out.println("entrez un coup possible");
			    sc= new Scanner(System.in);
			    ch=sc.nextInt();
			}
			if(t.AjouterDomino(lj.get(ch))){
			    j.joueur[i].mesd.remove(j.joueur[i].mesd.get(ch));
			    System.out.println(  "Le plateau est : "+"\n" + t.toString());
			}
			if(lj.size()==0 && j.joueur[i].mesd.size()!=0){
			    Domino dj=e.piocher();
			    j.joueur[i].mesd.add(dj);
			    System.out.println("coup impossible piocher et fait passez le tour");
			    if(i!=j.taille()-1) i++;
			     else{i=0;}
			}
		    }
	 	}
	    }
	}
    }
    public static void main(String[]args){
	// Ensemble e=new EnsembleDomino ();
	// Plateau p= new PlateauD();
	// JeuDomino jd= new JeuDomino(2,e, p);
	// jd.partage();
	// jd.quiCommence();
	// Domino d= new Domino(0,1);
	// Domino d1= new Domino(1,1);
	// Domino d2= new Domino(0,1);
	// PlateauD t =(PlateauD)p;
	// t.AjouterDomino(d,3);
	// System.out.println(t.toString());
	// t.AjouterDomino(d1);
	// System.out.println(t.toString());
	// t.AjouterDomino(d2);
	// System.out.println(t.toString());
	JeuDomino j=new JeuDomino();
	j.commencer();
	
    }
}
